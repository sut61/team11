import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { RefindCartService, Cart, BuyItem, Customer} from '../../shared/refind-cart/refind-cart.service';
import { ViewCartItemService, Receipt} from '../../shared/view-cart-item/view-cart-item.service';
import { Subscription } from 'rxjs';
import { HttpClient} from '@angular/common/http';
import { CustomerService } from '../../shared/customer/customer.service';
import { Employee } from 'src/app/shared/refind-emp/refind-emp.service';

@Component({
  selector: 'app-view-cart-item',
  templateUrl: './view-cart-item.component.html',
  styleUrls: ['./view-cart-item.component.css']
})
export class ViewCartItemComponent implements OnInit {
  id2:any;
  employee: Employee = new Employee();
  cart: Cart = new Cart();
  id: any;
  sub: Subscription;
  buyItems: Array<BuyItem>;
  netP: Receipt = new Receipt;
  sumttp: any;
  
  displayedColumns: string[] = ['id','itemName','totalPrice',];
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private findCart: RefindCartService,
    private httpClient: HttpClient
  ) { }

  ngOnInit() {
    this.showIteminCart();
    this.setEMP();
  }

  showIteminCart(){
    this.route.params.subscribe(param => {
      this.id = param['id'];
      this.findCart.refindCart(this.id).subscribe((data) => {
        this.buyItems = []; 
        this.cart = data;
        console.log(this.cart);
        this.cart.buyItems.forEach(el =>{
          this.buyItems.push(el);
        });
      });
    }, err => {
      console.log('Error' + err);
    });
  }

  setEMP(){
    this.route.params.subscribe(param => {
      this.id2 = param['id2'];
      console.log('PAGE3_employee_ID: '+this.id2);
    }, err => {
      console.log('Error' + err);
    });
  }
  
  netPrice(){
    this.sub = this.findCart.refindCart(this.id).subscribe((res) => {
      this.buyItems = []; 
      this.sumttp = 0;
      this.cart.buyItems.forEach(el =>{
        this.sumttp += el.totalPrice;
      });
      this.cart = res;
      console.log('PAGE3_NETPRICE: ' + this.sumttp);
      console.log('PAGE3_CART_ID: ' + this.cart.cartId);
      console.log('PAGE3_EMP_ID: ' + this.id2);
      console.log('PAGE3_BRANCH_ID: ' + this.cart.customer.branch.bid);
      this.router.navigate([`${this.sumttp}/${this.cart.cartId}/${this.id2}/${this.cart.customer.branch.bid}/create-receipt`]);
    },err => {
      console.log('Error happen!!!', err);
    });
  }

}
