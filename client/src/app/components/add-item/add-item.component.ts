import { Component, OnInit } from '@angular/core';
import { Cart, BuyItem, Category, Unit } from '../../shared/models/model-class';
import { Router, ActivatedRoute } from '@angular/router';
import { CreateCartService } from '../../shared/create-cart/create-cart.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit {
  form: FormGroup;
  cart: Cart = new Cart();
  buy: BuyItem = new BuyItem();
  categories: Category[];
  units: Unit[];
  id: any;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private create: CreateCartService,
    private fb: FormBuilder
  ) { }

  ngOnInit() {
    this.createForm();
    this.route.params.subscribe(param => {
      this.id = param['id'];
      this.create.getCart(this.id).subscribe((data) => {
        this.cart = data;
        console.log(this.cart);
      });
    }, err => {
      console.log(err);
    });
  }

  submit(){
    console.log(this.form.value);
    //
  }

  createForm(){
    this.form = this.fb.group({
      itemName: ['', Validators.required],
      category: ['', Validators.required],
      price: ['', Validators.required],
      amount: ['', Validators.required],
      unit: ['', Validators.required]
    });
  }

}
