import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CheckService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

public API = '//localhost:8080';
  constructor(
    private http: HttpClient
  ) {
  }


  getBuyItems(): Observable<any> {
        return this.http.get(this.API + '/BuyItems');
  }

  getCategorize(): Observable<any> {
    return this.http.get(this.API + '/Categorize');
  }
  getChecks(): Observable<any> {
    return this.http.get(this.API + '/Checks');
  }

}
export class Checks{
  checksId:any;
  evaluate:string;
  weight:any;
  employee:Employee;
  buyItem:BuyItem;
  categorize:Categorize;
}
export class Categorize{
  categorizeId?: any;
  categorizeName?: string;
}

export class BuyItem{
  buyItemId?: any;
  itemName?: string;
  price?: any;
  amount?: number;
  totalPrice?: any;
}
export class Employee{
  eid?: any;
  ename?: string;
}

