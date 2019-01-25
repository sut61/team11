import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/shared/employee/employee.service';
import { HttpClient} from '@angular/common/http';
import { EmployeeService } from 'src/app/shared/employee/employee.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employee : Employee = new Employee();
  branchs : Array<any>;
  positions : Array<any>;
  educations : Array<any>;
  province : Array<any>;

  constructor(private service : EmployeeService , private httpClient: HttpClient
    ) { }

    ngOnInit() {
      this.service.getBranch().subscribe(data => {
        this.branchs = data;
      });
      this.service.getEducation().subscribe(data => {
        this.educations = data;
      });
      this.service.getPosition().subscribe(data => {
        this.positions = data;
      });
      this.service.getProvince().subscribe(data => {
        this.province = data;
      });
    }
  save(){
    console.log(this.employee.bdate);
    this.httpClient.post('//localhost:8080/Employee/' + this.employee.title + '/'+
    this.employee.eName + '/' + this.employee.age + '/' + this.employee.bdate + '/' + 
    this.employee.tel + '/' + this.employee.address + '/'+ this.employee.province.pid + '/' + 
    this.employee.education.edid + '/' + this.employee.branch.bid + '/' + this.employee.position.psid
    ,this.employee).subscribe(
      data => {
        console.log('Save Successful, Congratulations ', data);
      },
      error => {
        console.log('!!!! Warning, Error !!!!!', error);
      }
       
    );
  }

}  
