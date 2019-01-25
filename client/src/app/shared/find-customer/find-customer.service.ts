import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class FindCustomerService {

  public API: string = "http://localhost:8080";

  constructor(
    private http: HttpClient
  ) { }

  findCustomer(id: any): Observable<any>{
    return this.http.get(this.API + '/findCustomer/' + id);
  }
}
