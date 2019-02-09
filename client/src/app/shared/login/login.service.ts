import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Account } from '../models/model-class';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { NotificationService } from '../notification/notification.service';
@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public API: string = "http://localhost:8080";
  allowed: any;
  constructor(
    private notification: NotificationService,
    private http: HttpClient,
    private router: Router
  ) { 
    this.allowed = JSON.parse(localStorage.getItem('account'));
  }

  submit(username: any,password: any): Observable<any>{
    return this.http.get(this.API + '/Login/' + username + '/' + password);
  }
  login(id: any){
    return this.http.put(this.API + '/login/' + id, id).subscribe((res) => {
        localStorage.setItem('account',JSON.stringify(res));
        this.allowed = JSON.parse(localStorage.getItem('account'));
        this.router.navigate(['/customer']);
      }, err => {
        this.notification.error();
      });
  }
  logout(id:any){
    return this.http.put(this.API + '/logout/' + id, id).subscribe(() => {
      localStorage.clear();
      this.allowed = JSON.parse(localStorage.getItem('account'));
      this.router.navigate(['/login']);
    });
  }
}
