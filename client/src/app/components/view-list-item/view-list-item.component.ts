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
          // console.log(el);
          this.buyItems.push(el);
        });
        // console.log(this.cart);
        // console.log(this.buyItems);
      });
    }, err => {
      console.log(err);
      this.router.navigate(['/create-cart']);
    });
  }

  
  goAddItem(){
    this.router.navigate([`${this.cart.cartId}/add-item`]);
  }

}
