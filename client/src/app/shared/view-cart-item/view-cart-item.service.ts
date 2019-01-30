import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from '../refind-emp/refind-emp.service';
import { BuyItem, Branch, Cart } from '../refind-cart/refind-cart.service';

@Injectable({
  providedIn: 'root'
})
export class ViewCartItemService {
  public API: string = "http://localhost:8080";
  constructor(    
    private http: HttpClient
  ){ }

}

export class Receipt{
  rId?: any;
  date?:any;
  netPrice?: any;
  Employee?: Employee;
  branch?: Branch;
  cart?: Cart;
}