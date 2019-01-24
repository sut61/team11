import { Component, OnInit } from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import { HttpClient} from '@angular/common/http';
import { CustomerService, Customer } from '../../shared/customer/customer.service';
export interface Animal {
  name: string;
  name1: string;
  name2: string;
}
@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {


  customer: Customer = new Customer();
  branchs: Array<any>;
  careers: Array<any>;
  customer1s: Array<any>;
  employees: Array<any>;
  provinces: Array<any>;

  animalControl = new FormControl('', [Validators.required]);
  selectFormControl = new FormControl('', Validators.required);
  animals: Animal[] = [
  ];

  constructor(
    private service: CustomerService , private httpClient: HttpClient) { }

  ngOnInit() {
    this.service.getBranch().subscribe(data => {
      this.branchs = data;
    });
    this.service.getCareer().subscribe(data => {
      this.careers = data;
    });
    this.service.getCustomer().subscribe(data => {
        this.customer1s = data;
        console.log(this.customer1s);
    });
    this.service.getEmployee().subscribe(data => {
      this.employees = data;
      console.log(this.employees);
    });
    this.service.getProvince().subscribe(data => {
      this.provinces = data;
      console.log(this.provinces);
    });

  }
  save() {
    // this.report.athleteRegistration = this.report.payment.athleteRegistration;
    // this.report.athlete = this.report.payment.athleteRegistration.athlete; // set athlete ID
    console.log(this.customer.customername);
    console.log(this.customer.address);
    this.httpClient.post('//localhost:8080/Customer/' + this.customer.branch.bid + '/' + this.customer.customername +'/'+ this.customer.tel + '/'
     + this.customer.career.cid + '/' + this.customer.address + '/' + this.customer.province.pid,
    this.customer)
    .subscribe(
        data => {
            console.log('PUT Request is successful', data);
        },
        error => {
            console.log('Rrror', error);
        }
      );
      
  }
}
