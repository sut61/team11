import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class QuotationService {

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

  getQuotation(): Observable<any> {
    return this.http.get(this.API + '/Quotation');
}

getEmployee(): Observable<any> {
  return this.http.get(this.API + '/Employee');
}

getCategory(): Observable<any> {
return this.http.get(this.API + '/Category');
}

getCustomer(): Observable<any> {
  return this.http.get(this.API + '/Customer');
}
}

export class Category {
  categoryId: any;
  categoryName: string;
}
export class Quotation {
  quotationidId: any;
  price: any;
  detail:any;
  date:Date;
  customer: Customer;
  employee:Employee;
  category: Category;
}
export class Customer {
  customerId: any;
  customerName: string;
}
export class Employee {
  eid: any;
  ename: any;
  title:any ;
  age: any;
  tel:any ;
  address: any;
}

