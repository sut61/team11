import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CheckService {

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


  getBuyItems(): Observable<any> {
        return this.http.get(this.API + '/BuyItems');
  }

  getCategorize(): Observable<any> {
    return this.http.get(this.API + '/Categorize');
  }

}
export class Categorize{
  categorizeId?: any;
  categorizeName?: string;
}
