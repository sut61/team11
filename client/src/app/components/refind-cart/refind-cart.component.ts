import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { RefindCartService, Cart, Customer} from '../../shared/refind-cart/refind-cart.service';
import { RefindEmpService, Employee } from '../../shared/refind-emp/refind-emp.service';
import { FindEmployeeComponent } from '../find-employee/find-employee.component';
import { NotificationService } from 'src/app/shared/notification/notification.service';
@Component({
  selector: 'app-refind-cart',
  templateUrl: './refind-cart.component.html',
  styleUrls: ['./refind-cart.component.css']
})
export class RefindCartComponent implements OnInit {
  id: any;
  cart: Cart = new Cart();
  sub: Subscription;

  id2: any;
  employee: Employee = new Employee();
  sub2: Subscription;

  id3: any;
  customer: Customer = new Customer();
  sub3: Subscription;
  
  constructor(
    private findCart: RefindCartService,
    private findEmp: RefindEmpService,
    private router: Router,
    private route: ActivatedRoute,
    public notification: NotificationService

  ) { }

  ngOnInit() {
    this.findEmployee();
  }
  
  findEmployee(){
    this.sub2 = this.route.params.subscribe(param => {
      this.id2 = param['id'];
      console.log('PAGE2_EMP_ID: ' + this.id2);
      this.findEmp.reFindEmployee(this.id2).subscribe((data) => {
        console.log(data);
        this.employee = data;
      });
    }, err => {
      console.log(err + "Errororororor");
    });
  }

  onClickCart(){
    this.sub = this.findCart.refindCart(this.id).subscribe((res) => {
      this.cart = res;
      console.log('PAGE2_CART_ID: ' + this.cart.cartId);
      this.router.navigate([`${this.cart.cartId}/${this.id2}/view-cart-item`]);
    
    },err => {
      if(err.error == null){
        this.notification.notFound();
      }else{
        this.notification.error();
      }
      console.log(err);    });
  }
}
