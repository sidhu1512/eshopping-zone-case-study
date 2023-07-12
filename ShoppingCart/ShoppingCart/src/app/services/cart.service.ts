import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { CartForInput } from '../model/cartForInput';

const httpOptions = {
  headers: new HttpHeaders({ 'response-Type': 'text' })
};

@Injectable({
  providedIn: 'root'
})
export class CartService {

  public cartItemList : any = [];
  public search = new BehaviorSubject<string>("");

  baseUrl1='http://localhost:8083/cart/';
  baseUrl2='http://localhost:8084/order/';

  constructor(private httpClient:HttpClient) { }

 
   
  placeOrder(cartData:any,fullName:any){
    return this.httpClient.post(`${this.baseUrl2}placeOrder/online/${fullName}`,cartData,fullName);
  }

  addAddress(addData:any){
    return this.httpClient.post(`${this.baseUrl2}addAddress`,addData);
  }


  gelAllOrders(){
    return this.httpClient.get(`${this.baseUrl2}getAll`);
  }

  getOneOrder(orderId:any){
    return this.httpClient.get(`${this.baseUrl2}getOrderById/${orderId}`,orderId);
  }

getOrderByCustomer(customerName:any){
  return this.httpClient.get(`${this.baseUrl2}getOrderByFullName/${customerName}`,customerName);
}


  pay(cartData:any){
  return this.httpClient.post('http://localhost:8084/order/pay',cartData);
  }

  addProductToCartCondition(cartId:any,productId:any){
    return this.httpClient.post(`${this.baseUrl1}addToCart/${cartId}/${productId}`,cartId,productId)
  }

  getCartByCartId(cartId:any){
    return this.httpClient.get(`${this.baseUrl1}findCart/${cartId}`,cartId);
  }

  deleteProductInCartById(productId:any,cartId:any){
    return this.httpClient.put(`${this.baseUrl1}delete/item/${productId}/${cartId}`,productId,cartId)
  }

  decreaseQuantityOfProduct(productId:any,cartId:any){
    return this.httpClient.put(`${this.baseUrl1}decreaseQuant/${productId}/${cartId}`,productId,cartId)
  }

  increaseQuantityOfProduct(productId:any,cartId:any){
    return this.httpClient.put(`${this.baseUrl1}increaseQuant/${productId}/${cartId}`,productId,cartId)
  }

  emptyCart(cartId:any){
    return this.httpClient.delete(`${this.baseUrl1}delete/${cartId}`,cartId);
  }


  public createTransaction(amount:any){
    return this.httpClient.get("http://localhost:8084/order/createTransaction/"+amount);
}
}
