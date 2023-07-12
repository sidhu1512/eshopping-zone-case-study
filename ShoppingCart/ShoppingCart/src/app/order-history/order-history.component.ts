import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../services/cart.service';
import { StorageService } from '../services/storage.service';

@Component({
  selector: 'app-order-history',
  templateUrl: './order-history.component.html',
  styleUrls: ['./order-history.component.css']
})
export class OrderHistoryComponent {
  isLoggedIn = false;

  orderhis = false;
  private roles: string[] = [];
private orderId:any;

  orderData: any = [
    {
      orderId:'',
      ammountPaid: '',
      items: [],
    },
  ];


  constructor(
    // private cartService: CartService,
    private router: Router,
    private cartService:CartService,
    private storageService:StorageService
  ) {}

  ngOnInit(){
    this.isLoggedIn = !!this.storageService.getToken();

    if (this.isLoggedIn) {
      const user = this.storageService.getUser();
      this.roles = user.roles;


      this.orderhis = this.roles.includes('ROLE_USER');

    this.cartService.gelAllOrders().subscribe(data=>{
      console.log(data);
      if (Array.isArray(data)){
        for (let i=data.length ;i>0;i--){
          this.orderId = data[i-1].orderId;
          break;
      }
    }
    this.cartService.getOneOrder(this.orderId).subscribe(data=>{
      this.orderData=data;
      console.log(data);
    });
    });

   
  }
}



  onclickShopNow() {
    this.router.navigate(['/home']).then(() => {
      window.location.reload();
    });
  }

  // ngOnInit() {
  //   this.cartService.showOrderHistory().subscribe(data => this.OrderHistory = data);
  // }
}


