import { Component, OnInit } from '@angular/core';
import { Cart, BuyItem, Category, Unit } from '../../shared/models/model-class';
import { Router, ActivatedRoute } from '@angular/router';
import { CreateCartService } from '../../shared/create-cart/create-cart.service';
import { AddItemService } from '../../shared/add-item/add-item.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NotificationService } from '../../shared/notification/notification.service';
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
    private fb: FormBuilder,
    private add: AddItemService,
    public notificaion: NotificationService
  ) { }

  ngOnInit() {
    this.createForm();
    this.route.params.subscribe(param => {
      this.id = param['id'];
      this.create.getCart(this.id).subscribe((data) => {
        this.cart = data;
      });
    }, err => {
      console.log(err);
    });
    this.add.getCategory().subscribe((cate) => {
      this.categories = cate;
    });
    this.add.getUnit().subscribe((unit) => {
      this.units =  unit;
    });
  }

  submit(){
    this.buy = Object.assign({}, this.form.value);
    this.add.newItem(this.id, this.buy).subscribe(() => {
      this.router.navigate([`${this.id}/view-list`]);
    }, err => {
      this.notificaion.error();
      console.log(err);
    });
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
