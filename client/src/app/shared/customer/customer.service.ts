import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

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


  getBranch(): Observable<any> {
        return this.http.get(this.API + '/Branch');
  }

  getCareer(): Observable<any> {
    return this.http.get(this.API + '/Career');
  }

  getCustomer(): Observable<any> {
    return this.http.get(this.API + '/Customer');
  }
  getEmployee(): Observable<any> {
    return this.http.get(this.API + '/Employee');
  }
  getProvince(): Observable<any> {
    return this.http.get(this.API + '/Province');
  }

}
export class Branch {
  bid: any;
  bname: string;
}
export class Customer {
  customerid: any;
  tel: any;
  branch: Branch;
  career: Career;
  province: Province;
  customername: any;
  address: any;
}
export class Career {
  cid: any;
  cname: string;
}
export class Employee {
  eId: any;
  eName: any;
  title:any ;
  age: any;
  tel:any ;
  address: any;
}
export class Province {
  pid: any;
  pname: string;
}
