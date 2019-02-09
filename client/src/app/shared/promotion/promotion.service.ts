import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PromotionService {

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

  getPromotion(): Observable<any> {
    return this.http.get(this.API + '/Promotion');
}

getEmployee(): Observable<any> {
  return this.http.get(this.API + '/Employee');
}

getTypePromotion(): Observable<any> {
return this.http.get(this.API + '/TypePromotion');
}

getBranch(): Observable<any> {
  return this.http.get(this.API + '/Branch');
}
}

export class TypePromotion {
  typePromotionId: any;
  typePromotionName: string;
}
export class Promotion {
  promotionId: any;
  promotionName: any;
  typePromotion: TypePromotion;
  numberOfTime:any;
  detailPromotion:any;
  dateIn:Date;
  dateOut:Date;
  branch: Branch;
  employee:Employee;
 
}
export class Branch  {
  bId: any;
  bName: string;
}
export class Employee {
  eid: any;
  ename: any;
  title:any ;
  age: any;
  tel:any ;
  address: any;
}

