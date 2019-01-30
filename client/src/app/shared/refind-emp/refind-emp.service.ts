import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Branch } from '../refind-cart/refind-cart.service';
@Injectable({
  providedIn: 'root'
})
export class RefindEmpService {
  public API: string = "http://localhost:8080";

  constructor(
    private http: HttpClient
  ) { }
//????
  reFindEmployee(eId: any): Observable<any>{
    // console.log(customerId);
    // return this.http.get(this.API + `{/findCustomer/${customerId}}`);
    return this.http.get(this.API + '/reFindEmployee/' + eId);
  }

}
export class Employee {
  eid?: any;
  ename?: any;
  title?:any ;
  age?: any;
  tel?:any ;
  address?: any;
  branch?: Branch;
}