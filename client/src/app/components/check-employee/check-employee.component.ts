import { Component, OnInit, OnDestroy } from '@angular/core';
import { Employee } from '../../shared/models/model-class';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';


import { CheckEmployeeService } from 'src/app/shared/shared/check-employee.service';

@Component({
  selector: 'app-check-employee',
  templateUrl: './check-employee.component.html',
  styleUrls: ['./check-employee.component.css']
})
export class CheckEmployeeComponent implements OnInit {

  id: any;
  employee: Employee = new Employee();
  sub: Subscription;
  employees: Array<any>;
  constructor(
    
    private find: CheckEmployeeService,
    private router: Router,
    private route: ActivatedRoute,
    // public notification: NotificationService
  ) { }

  ngOnInit() {

  }
  
  onClick(){
      this.find.checkEmployee(this.id).subscribe((res) => {
        // console.log(res);
        this.employee = res;
        // console.log(this.employee.eId);
        this.router.navigate([`${this.employee.eid}/findCustomer`]);
    },err => {
   
      console.log(err);
    });
  }

}
