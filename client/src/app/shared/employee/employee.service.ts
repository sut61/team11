import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type' : 'application/json'
    })
  };
  public APT = '//localhost:8080';

  constructor(private http: HttpClient) { }
  getEducation(): Observable<any> {
    return this.http.get(this.APT + '/Education');
     
  }

  getPosition(): Observable<any> {
    return this.http.get(this.APT + '/Position');
   
  }

  getBranch(): Observable<any> {
    return this.http.get(this.APT + '/Branch');
   
  }

  getProvince(): Observable<any> {
    return this.http.get(this.APT + '/Province');
   
  }
}


export class Branch {
  bid:any;
  bname: String;
}
export class Position {
  psId:any;
  psName:String;
}
export class Education {
  edId: any;
  edName : String;
}
export class Province { 
  pid : any;
  pname : String;
}
export class Employee {
  eId : any;
  title : any ;
  ename : any;
  bDate : Date;
  age : any;
  tel :any ;
  address : any;
  province : Province;
  education : Education;
  branch : Branch;
  position : Position;
}



