import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Receipt,  } from 'src/app/shared/view-cart-item/view-cart-item.service';
import { HttpClient } from '@angular/common/http';
import { Employee, RefindEmpService } from 'src/app/shared/refind-emp/refind-emp.service';
import { CreateReceiptService } from 'src/app/shared/create-receipt/create-receipt.service';
import { Branch, Cart, RefindCartService, Customer } from 'src/app/shared/refind-cart/refind-cart.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-create-receipt',
  templateUrl: './create-receipt.component.html',
  styleUrls: ['./create-receipt.component.css']
})
export class CreateReceiptComponent implements OnInit {
  private createR: Receipt = new Receipt();

  customer: Customer = new Customer();
  id: any;
  cart: Cart = new Cart();
  sub: Subscription;

  id2: any;
  employee: Employee = new Employee();
  sub2: Subscription;

  id3: any;
  branch: Branch = new Branch();
  sub3: Subscription;

  receipt: Receipt = new Receipt();

  netPrice: any;
  branchs: Array<any>;

  constructor(    
    private service:  CreateReceiptService,
    private route: ActivatedRoute,
    private router: Router,
    private httpClient: HttpClient
  ) { }

  ngOnInit() {
    this.set();
    this.getBranch();
  }
  SaveAndUpdate(){
    this.receipt.netPrice = this.createR.netPrice;
    this.service.create(this.receipt.netPrice, this.employee.eid, this.receipt.branch.bid, this.cart.cartId, this.receipt).subscribe((res) => {
      console.log(res);
      this.service.notificationSuccess();
    }, err => {
      this.service.notificationError();
      console.log(err);
    });
    this.service.reUpdate(this.cart.cartId,this.cart).subscribe((res) => {
      console.log(res);
    }, err => {
      console.log(err);
    });
    this.router.navigate([`/RefindEmp`]);
  }

  set(){
    this.sub = this.route.params.subscribe(param => {
      this.cart.cartId = param['id2'];
      console.log('PAGE4_CART_ID: ' + this.cart.cartId);
    }, err => {
      console.log(err + "Errororororor");
    });

    this.sub = this.route.params.subscribe(param => {
      this.employee.eid = param['id3'];
      console.log('PAGE4_EMP_ID: ' + this.employee.eid);
    }, err => {
      console.log(err + "Errororororor");
    });

    this.sub = this.route.params.subscribe(param => {
      this.createR.netPrice = param['id'];
      console.log('PAGE4_NETPRICE: ' + this.createR.netPrice);
    }, err => {
      console.log(err + "Errororororor");
    });
  }

  getBranch(){
    this.service.getBranch().subscribe(data =>{
      console.log(data);
      this.branchs = data;
    });
  }
}
