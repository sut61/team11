import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AssignmentService {
  public API: string = "http://localhost:8080";
  constructor(
    private http: HttpClient
  ) { 
  }
  getScoreAssignment():Observable<any> {
    return this.http.get(this.API + '/ScoreAssignment');
  }
  
}

export class Assignment {
  assignmentId: any;
  comment: any;
  scoreAssignment: ScoreAssignment;
}

export class ScoreAssignment{
  scoreAssignmentId: any;
  level: any;
}

export class Employee {
  eId: any;
  eName: any;
  title:any ;
  age: any;
  tel:any ;
  address: any;
}

export class Customer {
  customerid: any;
  customername: any;  
}