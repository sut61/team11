import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/shared/models/model-class';
import { FindCustomerService } from '../../shared/find-customer/find-customer.service';
import { Router } from '@angular/router';
import { NotificationService } from 'src/app/shared/notification/notification.service';
@Component({
  selector: 'app-find-customeras',
  templateUrl: './find-customeras.component.html',
  styleUrls: ['./find-customeras.component.css']
})
export class FindCustomerasComponent implements OnInit {

  customer: Customer = new Customer();
  id: any;  
  constructor(
    private find: FindCustomerService,
    private router: Router,   
    public notification: NotificationService
  ) { }

  ngOnInit() {
  }

  onClick(){
    this.find.findCustomer(this.id).subscribe((res) => {
      this.customer = res;
      console.log(res);
      console.log(this.customer.customerId);
      this.router.navigate([`${this.customer.customerId}/assignment`]);
    }, err => {
      if(err.error == null){
        this.notification.notFound();
      }else{
        this.notification.error();
      }
      console.log(err);
    });
  }

}
