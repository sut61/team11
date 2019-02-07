import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Branch } from '../refind-cart/refind-cart.service';

@Injectable({
  providedIn: 'root'
})
export class CheckEmployeeService {
  public API: string = "http://localhost:8080";

  constructor(
    private http: HttpClient
  ) { }
  checkEmployee(eId: any): Observable<any>{
    return this.http.get(this.API + '/checkEmployee/' + eId);
  }

}
export class Employee {
  eid?: any;
  ename?: any;
}