import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cart, BuyItem } from '../models/model-class';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class AddItemService {
  public API: string = "http://localhost:8080";

  constructor(
    private http: HttpClient
  ) { }

  getCategory():Observable<any>{
    return this.http.get(this.API + '/getCategories')
  }

  getUnit():Observable<any>{
    return this.http.get(this.API + '/getUnits')
  }

  newItem(cartId: any,buy:BuyItem){
    return this.http.post(this.API + '/' + cartId + '/newItem', buy);
  }
}
