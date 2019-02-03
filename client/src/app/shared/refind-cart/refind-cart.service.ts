import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class RefindCartService {
  public API: string = "http://localhost:8080";

  constructor(
    private http: HttpClient
  ) { }

  refindCart(cartId: any): Observable<any>{
    return this.http.get(this.API + '/reFindCart/' + cartId);
  }
  getCustomer(): Observable<any> {
    return this.http.get(this.API + '/Customer');
  }
}
export class Cart{
  cartId?: any;
  paymentStatus?: string;
  buyItems?: BuyItem[];
  customer?: Customer;
}
export class BuyItem{
  buyItemId?: any;
  itemName?: string;
  totalPrice?: any;
}
export class Branch {
  bid?: any;
  bname?: string;
}
export class Customer {
  customerId?: any;
  tel?: any;
  branch?: Branch;
  customerName?: any;
  address?: any;
}