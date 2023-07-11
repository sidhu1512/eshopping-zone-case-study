package com.eshoppingzone.orders.resource;

import java.util.List;     

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eshoppingzone.mailservice.EmailService;
import com.eshoppingzone.orders.model.Address;
import com.eshoppingzone.orders.model.Cart;
import com.eshoppingzone.orders.model.Items;
import com.eshoppingzone.orders.model.Orders;
import com.eshoppingzone.orders.model.Product;
import com.eshoppingzone.orders.model.TransactionDetails;
import com.eshoppingzone.orders.model.UserProfile;
import com.eshoppingzone.orders.service.OrderService;
import com.netflix.discovery.converters.Auto;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;


@RestController
@RequestMapping("/order")
@CrossOrigin(origins="*",maxAge = 3600)
public class OrderResource {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private PlacingOrder pl;
	
	@Autowired
	private DeletingCart dl;
	
	@Autowired
	private GetUserProfile ul;
	
	@Autowired
	private EmailService em;
	
	OrderResource(){
		
	}
	
	//get all placed orders
	@GetMapping("/getAll")
	public List<Orders> getAllOrders(){
		return orderService.getAllOrders();
		
	}
	
	//get all address
	@GetMapping("/getAllAddress")
	public List<Address> getAllAddress(){
		return orderService.getAllAddress();
	}
	
	//get order by customer Id
	@GetMapping("/getOrderByCust/{customerId}")
	public List<Orders> getOrderByCustomerId(@PathVariable int customerId){
		return orderService.getOrderByCustomerId(customerId);
		
	}
	
	
	@GetMapping("/getOrderById/{orderId}")
	public Orders getOrderById(@PathVariable int orderId){
		return orderService.getOrderById(orderId);
		
	}
	
	
	
	//get address by  customer by id
	@GetMapping("/getAddByCust/{customerId}")
	public List<Address> getAddressByCustomerId(@PathVariable int customerId) {
		return orderService.getAddressByCustomerId(customerId);
	}
	
	//place order for customer with fullName
	@PostMapping("/placeOrder/{mode}/{fullName}")
	public void placeOrder(@RequestBody Cart cart ,@PathVariable String mode,@PathVariable String fullName) {
		
		
		UserProfile up = ul.getByUserName(fullName);
		
		List<Items> i = cart.getItems();
		
		for(Items ac:i) {
			pl.decreaseItem(ac.getProductId(), ac.getQuantity());
		}
		
		
		orderService.placeOrder(cart, mode, fullName);
		
		dl.deleteCart(cart.getCartId());
		
		String body = "Hello "+fullName+" "+"Your order is placed successfully, You will recieve your order within 4-5 working days :). "+" "+"Kindly visit our website for more shopping. ";

		em.sendSimpleMail(up.getEmailId(), body, "Order Placed");
		
	}
	
	// online payment
	@GetMapping("/createTransaction/{amount}")
	public TransactionDetails createTransaction(@PathVariable double amount) {
		return orderService.createTransaction(amount);
	}
		
	
	//add address for order
	@PostMapping("/addAddress")
	public void storeAddress(@RequestBody Address address) {
		orderService.storeAddress(address);
	}
	
	//change status for confirmed status
	@PutMapping("/changeStatus/{orderId}")
	public void changeOrderStatus(@RequestBody String status, @PathVariable int orderId) {
		orderService.changeStatus(status, orderId);
	}
	
	//delete order by orderId
	@DeleteMapping("/deleteOrder/{orderId}")
	public ResponseEntity<String> deleteOrder(@PathVariable int orderId){
		orderService.deleteOrder(orderId);
		return  ResponseEntity.ok("Your order is deleted with "+ orderId);
	}
	
	//get order by customer fullName
	@GetMapping("/getOrderByFullName/{fullName}")
	public List<Orders> getOrderByfullName(@PathVariable String fullName){
		return orderService.findOrderByFullName(fullName);
		
	}

}
