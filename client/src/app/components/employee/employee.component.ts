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

  public API: string = "http://localhost:8080";

  employee : Employee = new Employee();
  branchs : Array<any>;
  positions : Array<any>;
  educations : Array<any>;
  provinces : Array<any>;
  bdate : Date;


  constructor(private service : EmployeeService , private httpClient: HttpClient
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
  // save(){
  //   console.log(this.employee);
  //   //console.log(this.employee.bdate);
    
    
  //   this.httpClient.post('//localhost:8080/Employee/' + this.employee.title + '/'+
  //   this.employee.eName + '/' + this.employee.age + '/' +'25-02-2556' + '/' + 
  //   this.employee.tel + '/' + this.employee.address + '/'+ this.employee.province.pid + '/' + 
  //   this.employee.education.edId + '/' + this.employee.branch.bid + '/' + this.employee.position.psId
  //   ,this.employee).subscribe(
  //     data => {
  //       console.log('Save Successful, Congratulations ', data);
  //     }
  //   ,
  //     error => {
  //       console.log('!!!! Warning, Error !!!!!', error);
  //     }
       
  //   );
  // }

  // save(){
  //   this.httpClient.post(this.API + '/Employee/' + this.employee.title + '/' + this.employee.eName + '/' + "25-02-2562" + '/' + this.employee.age + '/' + this.employee.tel + '/' + this.employee.address + '/' + this.employee.province.pid + '/' + this.employee.education.edId + '/' + this.employee.branch.bid + '/' + this.employee.position.psId, this.employee).subscribe((da) => {
  //     console.log(da);
  //   });
  // }

  save(){
    this.httpClient.post(this.API + '/newEmp', this.employee).subscribe((data) => {
      console.log(data);
      
    }, err => {
      console.log("Error Happen!!!!");
    });
  }

}  
