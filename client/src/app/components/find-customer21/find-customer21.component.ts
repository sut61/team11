import { Component, OnInit } from '@angular/core';
import { FindCustomer2Service } from '../../shared/find-customer2/find-customer2.service';
import { Customer,Employee } from '../../shared/models/model-class';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { FindEmployeeService } from 'src/app/shared/find-employee/find-employee.service';
import { FindCustomerService } from '../../shared/find-customer/find-customer.service';

@Component({
  selector: 'app-find-customer21',
  templateUrl: './find-customer21.component.html',
  styleUrls: ['./find-customer21.component.css']
})
export class FindCustomer21Component implements OnInit {
  employee: Employee = new Employee();
  id: any;
  id2: any;
  customer: Customer = new Customer();
  sub: Subscription;
  sub2: Subscription;

  constructor(
    private find: FindEmployeeService,
    private find2: FindCustomerService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
        this.route.params.subscribe(param => {
        this.id2 = param['id'];
      // console.log(param);
      // console.log(this.id + "5555555555555");
        this.find.findEmployee(this.id2).subscribe((data) => {
        this.employee = data;
        // console.log(this.employee);
      });
    }, err => {
      console.log(err + "Errororororor");
    });
  }
  
  // onClick(){

  //     this.find2.findCustomer(this.id).subscribe((res) => {
  //     // console.log(res);
  //     this.customer = res;
  //     // console.log(this.customer.customerId);
  //     this.router.navigate([`${this.customer.customerId}/SaleItem`]);
  //   },err => {
  //     console.log('Error happen!!!', err);
  //   });
  // }
}

