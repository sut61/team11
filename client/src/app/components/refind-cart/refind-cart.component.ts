import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { RefindCartService, Cart} from '../../shared/refind-cart/refind-cart.service';
import { RefindEmpService, Employee } from '../../shared/refind-emp/refind-emp.service';
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
  
  constructor(
    private findCart: RefindCartService,
    private findEmp: RefindEmpService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.sub2 = this.route.params.subscribe(param => {
      this.id2 = param['id'];
      console.log(this.id);
      this.findEmp.reFindEmployee(this.id2).subscribe((data) => {
        this.employee = data;
      });
    }, err => {
      console.log(err + "Errororororor");
    });
  }
  
  onClickCart(){
    this.sub = this.findCart.refindCart(this.id).subscribe((res) => {
      console.log(res);
      this.cart = res;
      console.log(this.cart.cartId);
      this.router.navigate([`${this.cart.cartId}/view-cart-item`]);
    },err => {
      console.log('Error happen!!!', err);
    });
  }
}
