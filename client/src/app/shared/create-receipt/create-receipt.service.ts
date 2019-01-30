import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Receipt } from '../view-cart-item/view-cart-item.service';

@Injectable({
  providedIn: 'root'
})
export class CreateReceiptService {
  public API: string = "http://localhost:8080";
  constructor(    private http: HttpClient
    ) { }

  getReceipt(netP: any,eId: any, bId: any, cartId: any, receipt: Receipt): Observable<any>{
    // console.log(id);
    // return this.http.get(this.API + `{/findCustomer/${customerId}}`);
    return this.http.get(this.API + '/newReceipt/'+ netP + '/' + eId + '/' + bId + '/' + cartId);
  }
  getBranch(): Observable<any> {
    return this.http.get(this.API + '/Branch');
  }
  getEmployee(): Observable<any> {
    return this.http.get(this.API + '/Employee');
  }
  getCart(id: any): Observable<any>{
    return this.http.get(this.API + '/getCart/' + id);
  }
}
