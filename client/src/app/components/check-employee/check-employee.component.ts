import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { CheckEmployeeService,Employee } from 'src/app/shared/checkEmployee/check-employee.service';



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
        this.router.navigate([`${this.employee.eid}/Check`]);
    },err => {
   
      console.log(err);
    });
  }

}
