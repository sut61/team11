import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cart } from '../models/model-class';
@Injectable({
  providedIn: 'root'
})
export class CreateCartService {

  public API: string = "http://localhost:8080";

  constructor(
    private http: HttpClient
  ) { }

  createCart(customerId: any,cart: Cart){
    cart.paymentStatus = "Pending";
    return this.http.post(this.API + '/' + customerId + '/' + 'newCart', cart);
  }
}
