import { Component, OnInit } from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import { HttpClient} from '@angular/common/http';
import { CustomerService, Customer } from '../../shared/customer/customer.service';
import { Router } from '@angular/router';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material';

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
    private service: CustomerService , private httpClient: HttpClient,private router: Router,public snackBar: MatSnackBar) { }

    config: MatSnackBarConfig = {
      duration: 6000,
      horizontalPosition: 'right',
      verticalPosition: 'top'
    }
  ngOnInit() {
    this.service.getBranch().subscribe(data => {
      this.branchs = data;
    });
    this.service.getCareer().subscribe(data => {
      this.careers = data;
    });
    this.service.getCustomer().subscribe(data => {
        this.customer1s = data;
        // console.log(this.customer1s);
    });
    this.service.getEmployee().subscribe(data => {
      this.employees = data;
      // console.log(this.employees);
    });
    this.service.getProvince().subscribe(data => {
      this.provinces = data;
      // console.log(this.provinces);
    });

  }
  gocustomer(){
    this.router.navigate(['/customer']).then(() => {
      
    });
  }

  save() {
 if( this.customer.customername != null && this.customer.tel != null 
  && this.customer.address != null && this.customer.province.pid != null){
    this.httpClient.post('//localhost:8080/Customer/' + this.customer.branch.bid + '/' + this.customer.customername +'/'+ this.customer.tel + '/'
     + this.customer.career.cid + '/' + this.customer.address + '/' + this.customer.province.pid,
    this.customer)
    .subscribe(
        data => {
            console.log('PUT Request is successful', data);
            this.config['panelClass'] = ['notification','er'];
            this.snackBar.open('บันทึกข้อมูลเสร็จแล้ว','', this.config);
        },
        error => {
            console.log('Rrror', error);
            this.config['panelClass'] = ['notification','error'];
            this.snackBar.open('ไม่สามารถบันทึกข้อมูลได้','', this.config);
            
        }
      );
      this.router.navigate(['/customer']).then(() => {
      });
      
      }else{
        console.log("คุณกรอกข้อมูลไม่ครบ");
        this.config['panelClass'] = ['notification','error'];
        this.snackBar.open('ไม่สามารถบันทึกข้อมูลได้','', this.config);
      }
  }

}
