import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RpfindEmpService {
  public API: string = "http://localhost:8080";

  constructor(    private http: HttpClient
    ) { }
  rpFindEmployee(eId:any): Observable<any>{
    return this.http.get(this.API + '/rpFindEmployee/'+ eId);
  }
}
export class Employee {
  eid?: any;
  ename?: any;
  title?:any ;
  age?: any;
  tel?:any ;
  address?: any;
}