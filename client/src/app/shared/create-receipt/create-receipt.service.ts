import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Receipt } from '../view-cart-item/view-cart-item.service';
import { Cart } from '../refind-cart/refind-cart.service';

@Injectable({
  providedIn: 'root'
})
export class CreateReceiptService {
  public API: string = "//localhost:8080";
  constructor(    private http: HttpClient
    ) { }

  reUpdate(cartId: any,cart: Cart){
    console.log(cart);
    return this.http.put(this.API + '/reUpdate/' + cart.cartId, cart);
  }

  create(netPrice: any, eid: any, bid: any, cartId: any, receipt: Receipt){
    console.log(receipt);
    return this.http.post(this.API + '/newReceipt/' + receipt.netPrice + '/' + eid + '/' + bid + '/' + cartId, receipt);
  }
}
