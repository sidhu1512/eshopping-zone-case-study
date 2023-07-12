import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {



  public type = new BehaviorSubject<any>("");
  
  constructor(private httpClient:HttpClient) { }

  getAllProduct():Observable<Product[]>{ 
     return this.httpClient.get<Product[]>('http://localhost:8082/product/allProducts')
  }
  
  getProductsByType(productType:any):Observable<Product[]>{
    return this.httpClient.get<Product[]>('http://localhost:8082/product/findByCategory/'+productType);
  }

  getProductByName(productName:any):Observable<Product[]>{
    return this.httpClient.get<Product[]>('http://localhost:8082/product/findByName/'+productName);
  }
    
  
  getOneProduct(productId:any):Observable<Product[]>{
    return this.httpClient.get<Product[]>('http://localhost:8082/product/findById/'+productId);
  }

}
