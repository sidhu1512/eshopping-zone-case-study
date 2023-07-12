import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { fromEvent, Subject, takeUntil } from 'rxjs';
import { Address } from '../model/address';
import { CartService } from '../services/cart.service';
import { StorageService } from '../services/storage.service';

declare var Razorpay:any;

@Component({
  selector: 'app-address-details',
  templateUrl: './address-details.component.html',
  styleUrls: ['./address-details.component.css'],
})
export class AddressDetailsComponent implements OnInit {
  private unsubscriber: Subject<void> = new Subject<void>();
  cartId: any;

 addressAdded = false;
  cartData: any = [
    {
      cartId: '',
      items: [],
      totalPrice: '',
    },
  ];

  addData: any = {
    fullName: '',
    mobileNumber: '',
    flatNumber: '',
    city: '',
    pincode: '',
    state: '',
  };

  cartForOutput: any = [
    {
      cartId: '',
      custId: '',
      pro: [],
      total: 0,
    },
  ];

  displayedColumns: string[] = [
    'ID',
    'Name',
    'Type',
    'Category',
    'Rating',
    'Review',
    'Price',
    'Description',
  ];

  username: any;

  constructor(
    private storageService: StorageService,
    private cartService: CartService,
    private router:Router
  ) {}

  ngOnInit(): void {
    this.username = this.storageService.getUser().username;
    this.addData.fullName = this.username;
    this.cartId = 1;
    this.cartService.getCartByCartId(this.cartId).subscribe((data) => {
      console.log(data);
      this.cartData = data;
      console.log(this.cartData);
    });
  }

  paymentLink() {
    // return "https://buy.stripe.com/test_aEU5kU9mHa9r9cQfZ0";
    //  return "https://buy.stripe.com/test_7sIdUBc3bfXf17qdQS";
    
    
  }

  



  openTransactionModel(response:any){
    var options = {
      order_id:response.orderId,
      key:response.key,
      amount:response.amount,
      currency:response.currency,
      name: 'Hrishikesh',
      description: "ShoppingZone Payment",
      image: '/assets/trolley.png',
      handler:(response :any)=>{
        this.processResponse(response);
      },
      prefill :{
        name:'Hrishikesh',
        email:'saratehrishikesh17@gmail.com',
        contact:'9702905375',
      },
      notes:{
        address:'ShoppingCart Orders'
      },
      theme:{
        color:"#F37254"
      }
    };

    var razorpay = new Razorpay(options);
    razorpay.open();
  }
  processResponse(resp:any){
    console.log(resp);
}






  fullName(cartData: any, fullName: any) {
    throw new Error('Method not implemented.');
  }
  goToCart() {
    this.router.navigate(['add-to-cart']);
  } 

  emptyCart(){

   
    this.cartService.placeOrder(this.cartData,this.username).subscribe(data=>{
      console.log(data);
    });


    this.cartService.emptyCart(this.cartId).subscribe(data=>{
      console.log(data); 
    });

    var response = this.cartService.createTransaction(this.cartData.totalPrice).subscribe(
      (response) =>{
        console.log(response);
        this.openTransactionModel(response);
      },
      (error) =>{
        console.log(error);
      }
    )
    this.openTransactionModel(response);
    this.router.navigate(['/home'])


  }

  onSubmit(){
    this.addressAdded = true;
    this.cartService.addAddress(this.addData).subscribe(data=>{
      console.log(data); 
    })

  }


}
