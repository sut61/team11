import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpClient } from 'selenium-webdriver/http';
import { CreateRpService, ReportProblem, ProblemType } from 'src/app/shared/create-rp/create-rp.service';
import { Employee } from 'src/app/shared/rpfind-emp/rpfind-emp.service';

@Component({
  selector: 'app-view-list-report',
  templateUrl: './view-list-report.component.html',
  styleUrls: ['./view-list-report.component.css']
})
export class ViewListReportComponent implements OnInit {
  id: any;
  reports: Array<ReportProblem>
  employee: Employee = new Employee();
  displayedColumns: string[] = ['id','date','eName','department','problemType','rpDetail'];
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private service: CreateRpService
  ) { }

  ngOnInit() {
    this.showListReport();
  }
  showListReport(){
    this.service.getReport().subscribe(data => {
      this.reports = data;
      console.log(this.reports);
  });
  }
  goEmp(){
    this.router.navigate([`rpfindEmp`]);
  }
}
