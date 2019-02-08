import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { NotificationService } from 'src/app/shared/notification/notification.service';
import { Employee, RpfindEmpService } from 'src/app/shared/rpfind-emp/rpfind-emp.service';
// import { E } from '@angular/core/src/render3';
import { Department, CreateRpService, ProblemType, ReportProblem } from 'src/app/shared/create-rp/create-rp.service';

@Component({
  selector: 'app-create-rp',
  templateUrl: './create-rp.component.html',
  styleUrls: ['./create-rp.component.css']
})
export class CreateRpComponent implements OnInit {
  id: any;
  report: ReportProblem = new ReportProblem();
  employee: Employee = new Employee();
  departments: Array<any>;
  problemTypes: Array<any>;
  sub: Subscription;
  constructor(
    private service: RpfindEmpService,
    private service1: CreateRpService,
    private router: Router,
    private route: ActivatedRoute,
    public notification: NotificationService
  ) { }

  ngOnInit() {
    this.findEmployee();
    this.getDepartment();
    this.getProblemType();
  }
  findEmployee(){
    this.sub = this.route.params.subscribe(param => {
      this.id = param['id'];
      console.log('PAGE2_EMP_ID: ' + this.id);
      this.service.rpFindEmployee(this.id).subscribe((data) => {
        console.log(data);
        this.employee = data;
      });
    }, err => {
      console.log(err + "Errororororor");
    });
  }

  getDepartment(){
    this.service1.getDepartment().subscribe(data =>{
      console.log(data);
      this.departments = data;
    });
  }

  getProblemType(){
    this.service1.getProblemType().subscribe(data =>{
      console.log(data);
      this.problemTypes = data;
    });
  }
  save(){
    this.service1.postReport(this.report.rpDetail, this.report.problemType.ptId, this.employee.eid, this.report.department.depId, this.report).subscribe((res) => {
      console.log('PUT Request is successful', res);
      // this.router.navigate([`${this.report.rpId}/${this.report.problemType.ptId}/${this.employee.eid}/${this.report.department.depId}/view-list-report`]);
      this.router.navigate([`view-list-report`]);
    }, err => {
      console.log('Rrror', err);
    });
  }
}
