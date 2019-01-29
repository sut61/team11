import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class EmpService {
  public API: string = "http://localhost:8080";

  constructor(
    private http: HttpClient
  ) { }

  reFindEmployee(eid: any): Observable<any>{
    console.log(eid);
    // return this.http.get(this.API + `{/findCustomer/${customerId}}`);
    return this.http.get(this.API + '/reFindEmployee/' + eid);
  }
}
