import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SaleItemService {


  public API: string = "http://localhost:8080";


  constructor(
    private http: HttpClient
  ) { }
  SaleItem(customerId: any): Observable <any>{
    return this.http.post(this.API + '/' + customerId + '/SaleItem', customerId);
  }

  // getSaleItem(id: any): Observable<any>{
  //   return this.http.get(this.API + '/getSaleItem/' + id);
  // }

  getBuyItem(): Observable<any>{
    return this.http.get(this.API + '/BuyItems');
  }
}

