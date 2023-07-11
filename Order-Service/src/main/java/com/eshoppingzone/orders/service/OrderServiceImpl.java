package com.eshoppingzone.orders.service;

import java.text.DateFormat;   
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;

import com.eshoppingzone.orders.model.Address;
import com.eshoppingzone.orders.model.Cart;
import com.eshoppingzone.orders.model.Orders;
import com.eshoppingzone.orders.model.Product;
import com.eshoppingzone.orders.model.TransactionDetails;
import com.eshoppingzone.orders.model.Items;
import com.eshoppingzone.orders.repository.OrderRepository;
import com.eshoppingzone.orders.repository.TransactionRepository;
import com.eshoppingzone.orders.repository.AddressRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;



@Service
public class OrderServiceImpl implements OrderService {

	Logger logger= LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private SequenceGeneratorService seqService;
	
	
	@Autowired
	private TransactionRepository transactionrepository;
	
private static final String KEY = "rzp_test_Ow82Z0SUwVS5QI";
	
	private static final String KEY_SECRET = "Ol43DVmM2ztA1XdWyeJ1JAxo";
	
	private static final String CURRENCY= "INR";

	
	
	//listing all orders 
	@Override
	public List<Orders> getAllOrders() {
		
		return orderRepository.findAll();
	}
	
	//place order using customer fullName and cartId
	@Override
	public void placeOrder(Cart cart,String mode,String fullName) {
		
		Orders order=new Orders();
		order.setOrderId(seqService.getSequenceNum(Orders.SEQUENCE_NAME));
	
		LocalDate today = LocalDate.now();
		
		Items i = new Items();

         Product pro  = new Product();
         
         
	
		order.setOrderDate(today);
		order.setAmmountPaid(cart.getTotalPrice());
		order.setFullName(fullName);
		order.setModeOfPayment(mode);
		order.setQuantity(cart.getItems().size());
		order.setOrderStatus("confirmed");
		Address address=  addressRepository.findByFullName(fullName).get(0);
		order.setCustomerId(address.getCustomerId());
		order.setAddress(address); 
		order.setItems(cart.getItems());
		
		
		orderRepository.save(order);
		 logger.info(("order is placed with"+order.getOrderId()));
		 

		
	}
	
	//change order status of existing order
	@Override
	public String changeStatus(String status, int orderId) {
		
	Orders order =orderRepository.findById(orderId).orElseThrow();
	order.setOrderStatus(status);
	
	return "Order Status is changed to "+status;
		
		
	}
	
	//delete order by orderId
	@Override
	public void deleteOrder(int orderId) {
		orderRepository.deleteById(orderId);
		
	}
	
	//get order by  customer Id
	@Override
	public List<Orders> getOrderByCustomerId(int customerId) {
		
		return orderRepository.findByCustomerId(customerId);
	}
	
	//store  address  for each order
	@Override
	public void storeAddress(Address address) {
		address.setCustomerId(seqService.getSequenceNum(Address.SEQUENCE_NAME));
		
		addressRepository.save(address);
		
	}
	
	//get address by customer Id
	@Override
	public List<Address> getAddressByCustomerId(int customerId) {
		
		
		return addressRepository.findByCustomerId(customerId);
	}
	
	//get All address
	@Override
	public List<Address> getAllAddress() {
	
		return addressRepository.findAll();
	}
	
	// get Order by orderId
	@Override
	public Orders getOrderById(int orderId) {
		
		return orderRepository.findById(orderId).orElseThrow();
	}

	
	//online payment  to place order
	public TransactionDetails createTransaction(double amount) {
		try {
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("amount", (amount*100));
			jsonObject.put("currency", CURRENCY);
			
			RazorpayClient razorpayClient = new RazorpayClient(KEY, KEY_SECRET);
			
			Order order = razorpayClient.orders.create(jsonObject);
			
			return prepareTransactionDetails(order);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	private TransactionDetails prepareTransactionDetails(Order order) {
		String orderId = order.get("id");
		String currency = order.get("currency");
		Integer amount = order.get("amount");
		
		TransactionDetails details = new TransactionDetails(orderId,currency,amount,KEY);
		
		return transactionrepository.save(details);
	}
	
	
	
	
	//find order by customer fullName
	@Override
	public List<Orders> findOrderByFullName(String fullName) {
		
		return orderRepository.findByFullName(fullName);
	}

}
