import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { fromEvent, map, Subject, takeUntil } from 'rxjs';
import { Product } from '../model/product';
import { AdminService } from '../services/admin.service';
import { ProductService } from '../services/product.service';
import { StorageService } from '../services/storage.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {
  displayedColumns: string[] = ['ID', 'Name', 'Type', 'Category','Rating','Review','Price','Image','Description','Quantity','Action'];
isLoggedIn = false;
  products:Product[]=[];

  constructor(private productService:ProductService,private router:Router,private adminService:AdminService,private storageService: StorageService ){
  }
  ngOnInit(): void {
  
    this.isLoggedIn = !!this.storageService.getToken();
    this.showProducts();
  }

  showProducts(){
    this.productService.getAllProduct().subscribe(data=>{
      this.products=data;
      console.log(data);
    })
  }

  onClick(id:any){
    this.router.navigate(['update-product/',id]);
  }

  onClickDelete(id:any){
    this.adminService.deleteProduct(id).subscribe();
    alert('product deleted successfully');
    window.location.reload();
  }
}
