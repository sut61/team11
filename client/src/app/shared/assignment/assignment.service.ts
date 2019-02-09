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
  employee?: Employee;
}

export class ScoreAssignment{
  scoreAssignmentId: any;
  level: any;
}

export class Employee{
  eid?: any;
  ename?: string;
}

export class Customer {
  customerid: any;
  customername: any;  
}