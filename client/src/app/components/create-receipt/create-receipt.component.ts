import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Receipt,  } from 'src/app/shared/view-cart-item/view-cart-item.service';
import { HttpClient } from '@angular/common/http';
import { Employee, RefindEmpService } from 'src/app/shared/refind-emp/refind-emp.service';
import { CreateReceiptService } from 'src/app/shared/create-receipt/create-receipt.service';
import { Branch, Cart, RefindCartService } from 'src/app/shared/refind-cart/refind-cart.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-create-receipt',
  templateUrl: './create-receipt.component.html',
  styleUrls: ['./create-receipt.component.css']
})
export class CreateReceiptComponent implements OnInit {
  private createR: Receipt = new Receipt();
  private re: Receipt;
  private carts: Receipt;
  private employees: Receipt;


  id: any;
  cart: Cart = new Cart();
  sub: Subscription;

  id2: any;
  employee: Employee = new Employee();
  sub2: Subscription;

  id3: any;
  branch: Branch = new Branch();
  sub3: Subscription;


  constructor(    
    private service:  CreateReceiptService,
    private findCart: RefindCartService,
    private findEmp: RefindEmpService,  
    private route: ActivatedRoute,
    private router: Router,
    private httpClient: HttpClient
  ) { }

  ngOnInit() {
    this.sub2 = this.route.params.subscribe(param => {
      this.employee.eid = param['id'];
      console.log('EMP ID :',this.employee.eid);
      this.findEmp.reFindEmployee(this.employee.eid).subscribe((data) => {
        this.employee = data;
      });
    }, err => {
      console.log(err + "Errororororor");
    });

    this.sub = this.route.params.subscribe(param => {
      this.cart.cartId = param['id'];
      console.log('CART ID: ',this.cart.cartId);
      this.findCart.refindCart(this.id).subscribe((data) => {
        this.cart = data;
      });
    }, err => {
      console.log(err + "Errororororor");
    });

    this.sub = this.route.params.subscribe(param => {
      this.id2 = param['id'];
      console.log(this.id2);
      this.findEmp.reFindEmployee(this.id2).subscribe((data) => {
        this.employee.branch = data;
      });
    }, err => {
      console.log(err + "Errororororor");
    });
    
    this.sub = this.findCart.refindCart(this.id).subscribe((res) => {

      this.cart.buyItems = []; 
      // this.totalP = 0;
      this.createR.netPrice = 0;
      this.cart.buyItems.forEach(el =>{
        console.log(el.totalPrice);
        this.createR.netPrice += el.totalPrice;
        // this.totalP += el.totalPrice;

      });

    },err => {
      console.log('Error happen!!!', err);
    });
  }
  SaveAndUpdate(){
    this.service.getReceipt(this.createR.netPrice, this.employee.eid, this.branch.bid, this.cart.cartId,this.createR).subscribe((res) => {
      console.log(res);
      // this.carts = res;
      this.re = res;
      // this.router.navigate([`${this.carts.cartId}/view-list`]);
    }, err => {
      console.log('ERRORRRRRRRRRRRRRRRRRRRRRR',err);
    });
    // this.httpClient.post('//localhost:8080/newReceipt/'+ this.createR.netPrice + '/' +this.createR.Employee.eid + '/' + this.createR.branch.bid + '/' 
    // + this.createR.cart.cartId,this.createR)
  //   this.httpClient.post('//localhost:8080/newReceipt/'+ this.createR.cart.cartId,this.createR)
  //  .subscribe(
  //      data => {
  //          console.log('PUT Request is successful', data);
  //      },
  //      error => {
  //          console.log('EEEEEEERrror', error);
  //   console.log(this.createR.Employee.eid);
  //      }
  //    );
    
    //  this.create.createCart(this.customer.customerId,this.cart).subscribe((res) => {
    //   console.log(res);
    //   this.carts = res;
    //   this.router.navigate([`${this.carts.cartId}/view-list`]);
    // }, err => {
    //   console.log(err);
    // });
  }

}
