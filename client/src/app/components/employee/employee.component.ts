import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/shared/employee/employee.service';
import { HttpClient} from '@angular/common/http';
import { EmployeeService } from 'src/app/shared/employee/employee.service';
import {DialogService} from 'src/app/shared/dialog/dialog.service';
import { from } from 'rxjs';
import { Router,ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  public API: string = "http://localhost:8080";

  employee : Employee = new Employee();
  branchs : Array<any>;
  positions : Array<any>;
  educations : Array<any>;
  provinces : Array<any>;
  bdate : Date;


  constructor(private service : EmployeeService,
     private httpClient: HttpClient,
     private dialog: DialogService,
     private router: Router
    ) { }

    ngOnInit() {
      this.service.getBranch().subscribe(data => {
        this.branchs = data;
        console.log(this.branchs);
      });
      this.service.getEducation().subscribe(data => {
        this.educations = data;
        console.log( this.educations);
      });
      this.service.getPosition().subscribe(data => {
        this.positions = data;
        console.log(this.positions);
      });
      this.service.getProvince().subscribe(data => {
        this.provinces = data;
        console.log(this.provinces);
      });
      
    }
  save(){
    this.httpClient.post(this.API + '/newEmp', this.employee).subscribe((data) => {
      console.log("Congratulations^^");
      console.log(data);
      this.router.navigate(['/save-employee']).then(() => {
      });
     
      
    }, err => {
      console.log("Error Happen!!!!");
      this.dialog.foundNull();
    });
  }

}  
