import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { Employee } from 'src/app/shared/quotation/quotation.service';
import { EmpPromotionService } from 'src/app/shared/empPromotion/empPromotion.service';
import { NotificationService } from '../../shared/notification/notification.service';

@Component({
  selector: 'app-empPromotion',
  templateUrl: './empPromotion.component.html',
  styleUrls: ['./empPromotion.component.css']
})
export class EmpPromotionComponent implements OnInit {
  id: any;
  employee: Employee = new Employee();
  sub: Subscription;

  constructor(
    private find: EmpPromotionService,
    private router: Router,
    private route: ActivatedRoute,
    public notification: NotificationService
  ) { }

  ngOnInit() {
  }
  
  onClickEmp(){
    this.sub = this.find.reFindEmployee(this.id).subscribe((res) => {
      console.log(res);
      this.employee = res;
      console.log(this.employee.eid);
      this.router.navigate([`${this.employee.eid}/Promotion`]);
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

