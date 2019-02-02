import { Component, OnInit, OnDestroy } from '@angular/core';
import { Employee } from '../../shared/models/model-class';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { FindEmployeeService } from 'src/app/shared/find-employee/find-employee.service';
import { NotificationService } from 'src/app/shared/notification/notification.service';
@Component({
  selector: 'app-find-employee',
  templateUrl: './find-employee.component.html',
  styleUrls: ['./find-employee.component.css']
})
export class FindEmployeeComponent implements OnInit {
  id: any;
  employee: Employee = new Employee();
  sub: Subscription;
  employees: Array<any>;
  constructor(
    
    private find: FindEmployeeService,
    private router: Router,
    private route: ActivatedRoute,
    public notification: NotificationService
  ) { }

  ngOnInit() {
    // this.find.getEmployee().subscribe(data => {
    //   this.employees = data;
    //   console.log(this.employees);
    // });
  }
  
  onClick(){
      this.find.findEmployee(this.id).subscribe((res) => {
        // console.log(res);
        this.employee = res;
        // console.log(this.employee.eId);
        this.router.navigate([`${this.employee.eid}/findCustomer`]);
    },err => {
      if(err.error == null){
        this.notification.notFound();
      }else{
        this.notification.error();
      }
      console.log(err);
    });
  }

  // ngOnDestroy(){
  //   this.sub.unsubscribe();
  //   console.log("Unsub Find")
  // }
}
