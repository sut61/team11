import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class FindCustomerasService {

  public API: string = "http://localhost:8080";

  constructor(
    private http: HttpClient
  ) { }

  findCustomeras(id: any): Observable<any>{
    return this.http.get(this.API + '/findCustomer/' + id);
  }
}
