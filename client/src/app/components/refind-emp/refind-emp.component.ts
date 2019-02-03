import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { RefindEmpService, Employee } from '../../shared/refind-emp/refind-emp.service';
import { NotificationService } from 'src/app/shared/notification/notification.service';
@Component({
  selector: 'app-refind-emp',
  templateUrl: './refind-emp.component.html',
  styleUrls: ['./refind-emp.component.css']
})
export class RefindEmpComponent implements OnInit {
  id: any;
  employee: Employee = new Employee();
  sub: Subscription;

  constructor(
    private service: RefindEmpService,
    private router: Router,
    private route: ActivatedRoute,
    public notification: NotificationService
  ) { }

  ngOnInit() {
  }

  onClickEmp(){
    this.sub = this.service.reFindEmployee(this.id).subscribe((res) => {
      this.employee = res;
      console.log('PAGE1_EMP_ID: ' + this.employee.eid);
      this.router.navigate([`${this.employee.eid}/RefindCart`]);
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
