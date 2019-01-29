import { Component, OnInit } from '@angular/core';
import { Cart,Employee } from '../../shared/models/model-class';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { RefindCartService } from '../../shared/refind-cart/refind-cart.service';
import { RefindEmpService } from '../../shared/refind-emp/refind-emp.service';
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
    private find: RefindCartService,
    private find2: RefindEmpService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(param => {
      this.id2 = param['id'];
      // console.log(this.id);
      this.find2.reFindEmployee(this.id2).subscribe((data) => {
        this.employee = data;
      });
    }, err => {
      console.log(err + "Errororororor");
    });
  }
  
  onClickCart(){
    // this.sub = this.find.refindCart(this.id).subscribe((res) => {
    //   console.log(res);
    //   this.cart = res;
    //   console.log(this.cart.cartId);
    //   this.router.navigate([`${this.cart.cartId}/refind-cart`]);
    // },err => {
    //   console.log('Error happen!!!', err);
    // });
  }
}
