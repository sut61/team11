import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FindCustomerService } from '../../shared/find-customer/find-customer.service';
import { Customer } from '../../shared/models/model-class';
@Component({
  selector: 'app-find-customer',
  templateUrl: './find-customer.component.html',
  styleUrls: ['./find-customer.component.css']
})
export class FindCustomerComponent implements OnInit {

  id: any;
  customer: Customer = new Customer();
  constructor(
    private service:FindCustomerService,
    private router: Router
  ) { }

  ngOnInit() {
  }

  submit(){
    this.service.findCustomer(this.id).subscribe((res) => {
      this.customer = res;
      this.router.navigate([`${this.customer.customerId}/createCart`]);
    });
  }
}
