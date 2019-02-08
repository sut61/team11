import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from '../rpfind-emp/rpfind-emp.service';
@Injectable({
  providedIn: 'root'
})
export class CreateRpService {
  public API: string = "//localhost:8080";
  constructor(    private http: HttpClient
    ) { }
  postReport(  rpDetail:any, ptId:any, eId: any, depId: any, reportProblem: ReportProblem){
    console.log(reportProblem);
    // return this.http.post(this.API + '/newReport/' + depId, reportProblem);
    return this.http.post(this.API + '/newReport/' +ptId + '/' + eId + '/' + depId+ '/' + rpDetail , reportProblem);
  }
  getDepartment(): Observable<any>{
    return this.http.get(this.API + '/Department');
  }
  getProblemType(): Observable<any>{
    return this.http.get(this.API + '/ProblemType');
  }
  getReport(): Observable<any>{
    return this.http.get(this.API + '/reportProblem');
  }
}
export class ReportProblem{
  rpId: any;
  rpDetail: any;
  employee: Employee;
  department: Department;
  problemType: ProblemType;
}
export class Department{
  depId: any;
  depName: any;
}
export class ProblemType{
  ptId: any;
  ptName: any;
}
