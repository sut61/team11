import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Customer, Cart } from '../../shared/models/model-class';
import { FindCustomerService } from '../../shared/find-customer/find-customer.service';
import { CreateCartService } from '../../shared/create-cart/create-cart.service';
import { NotificationService } from '../../shared/notification/notification.service';
@Component({
  selector: 'app-create-cart',
  templateUrl: './create-cart.component.html',
  styleUrls: ['./create-cart.component.css']
})
export class CreateCartComponent implements OnInit {
  cart: Cart = new Cart();
  customer: Customer = new Customer();
  id: any;
  carts: Cart;
  constructor(
    private find: FindCustomerService,
    private router: Router,
    private route: ActivatedRoute,
    private create: CreateCartService,
    public notification: NotificationService
  ) { }

  ngOnInit() {
    this.route.params.subscribe(param => {
      this.id = param['id'];
      this.find.findCustomer(this.id).subscribe((data) => {
        this.customer = data;
      });
    }, err => {
      console.log(err);
      this.router.navigate(['/find-customer']);
    });
  }

  onSubmit(){
    this.create.createCart(this.customer.customerId,this.cart).subscribe((res) => {
      this.carts = res;
      this.router.navigate([`${this.carts.cartId}/view-list`]);
    }, err => {
      this.notification.error();
      console.log(err);
    });
  }

}
