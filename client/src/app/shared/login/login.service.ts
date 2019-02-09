import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Account } from '../models/model-class';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public API: string = "http://localhost:8080";

  constructor(
    private http: HttpClient
  ) { }

  submit(username: any,password: any): Observable<any>{
    return this.http.get(this.API + '/Login/' + username + '/' + password);
  }
  login(id: any){
    return this.http.put(this.API + '/login/' + id, id);
  }
  logout(id:any){
    return this.http.put(this.API + '/logout/' + id, id);
  }
}
