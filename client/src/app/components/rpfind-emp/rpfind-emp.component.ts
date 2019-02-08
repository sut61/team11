import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { Employee, RpfindEmpService } from 'src/app/shared/rpfind-emp/rpfind-emp.service';
import { NotificationService } from 'src/app/shared/notification/notification.service';

@Component({
  selector: 'app-rpfind-emp',
  templateUrl: './rpfind-emp.component.html',
  styleUrls: ['./rpfind-emp.component.css']
})
export class RpfindEmpComponent implements OnInit {
  id: any;
  employee: Employee = new Employee();
  sub: Subscription;
  constructor(
    private service: RpfindEmpService,
    private router: Router,
    private route: ActivatedRoute,
    public notification: NotificationService
  ) { }

  ngOnInit() {
  }

  findEmp(){
    this.service.rpFindEmployee(this.id).subscribe((res) =>{
      console.log(res);
        this.employee = res
        console.log('PAGE1_EMP_ID' + this.employee.eid);
        this.router.navigate([`${this.employee.eid}/create-rp`]);
    },err => {
      if(err.error == null){
        this.notification.notFound();
      }else{
        this.notification.error();
      }
      console.log(err);
    });
  }
}
