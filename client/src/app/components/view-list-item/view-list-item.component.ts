import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Customer, Cart, BuyItem } from '../../shared/models/model-class';

import { CreateCartService } from '../../shared/create-cart/create-cart.service';
@Component({
  selector: 'app-view-list-item',
  templateUrl: './view-list-item.component.html',
  styleUrls: ['./view-list-item.component.css']
})
export class ViewListItemComponent implements OnInit {
  cart: Cart = new Cart();
  customer: Customer = new Customer();
  id: any;
  buyItems: Array<BuyItem>;
  len: boolean = false;
  displayedColumns: string[] = ['itemName', 'price', 'amount', 'totalPrice', 'category', 'unit'];
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private create: CreateCartService
  ) { }
  ngOnInit() {
    this.route.params.subscribe(param => {
      this.id = param['id'];
      this.create.getCart(this.id).subscribe((data) => {
        this.cart = data;
        this.buyItems = [];
        this.cart.buyItems.forEach(el =>{
          this.buyItems.push(el);
          if(this.buyItems.length > 0){
            this.len = true;
          }
        });
      });
    }, err => {
      console.log(err);
    });
  }

  
  goAddItem(){
    this.router.navigate([`${this.cart.cartId}/add-item`]);
  }

  exit(){
    this.router.navigate(['/find-customer']);
  }

}
