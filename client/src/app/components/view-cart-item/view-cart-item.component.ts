import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { RefindCartService, Cart, BuyItem, Customer} from '../../shared/refind-cart/refind-cart.service';
import { ViewCartItemService, Receipt} from '../../shared/view-cart-item/view-cart-item.service';
import { Subscription } from 'rxjs';
import { HttpClient} from '@angular/common/http';
import { CustomerService } from '../../shared/customer/customer.service';

@Component({
  selector: 'app-view-cart-item',
  templateUrl: './view-cart-item.component.html',
  styleUrls: ['./view-cart-item.component.css']
})
export class ViewCartItemComponent implements OnInit {
  id2: any;
  cart: Cart = new Cart();
  sub2: Subscription;
  id: any;
  // customers: Customer = new Customer;
  buyItems: Array<BuyItem>;
  netP: Receipt = new Receipt;
  totalP: any;
  sub: Subscription;
  // ne: any;
  customer1s: Array<any>;

  displayedColumns: string[] = ['id','itemName','totalPrice',];
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private findCart: RefindCartService,
    // private sumNP: ViewCartItemService,
    // private service: CustomerService ,
    private httpClient: HttpClient
  ) { }
  ngOnInit() {


    this.sub2 = this.route.params.subscribe(param => {
      this.id2 = param['id'];
      console.log(this.id2);
      this.findCart.refindCart(this.id2).subscribe((data) => {
        this.cart = data;
      });
    }, err => {
      console.log(err + "Errororororor");
    });

    this.route.params.subscribe(param => {
      this.id = param['id'];
      this.findCart.refindCart(this.id).subscribe((data) => {

        this.buyItems = []; 
        this.cart = data;
        this.cart.buyItems.forEach(el =>{
          this.buyItems.push(el);
        });
      });
    }, err => {
      console.log(err);
      // this.router.navigate(['/refind-cart']);
    });
    // this.cart.
  }
  netPrice(){
    this.sub = this.findCart.refindCart(this.id).subscribe((res) => {

      this.buyItems = []; 
      this.totalP = 0;
      this.netP.netPrice = 0;
      this.cart.buyItems.forEach(el =>{
        this.netP.netPrice += el.totalPrice;
        this.totalP += el.totalPrice;

      });

      console.log(this.netP.netPrice);
      this.cart = res;
      console.log(this.cart.cartId);
      this.router.navigate([`${this.cart.cartId}/create-receipt`]);
    },err => {
      console.log('Error happen!!!', err);
    });
  }

}
