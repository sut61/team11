import { Component, OnInit } from '@angular/core';
import { Cart, BuyItem, Category, Unit, SaleItem } from '../../shared/models/model-class';
import { Router, ActivatedRoute } from '@angular/router';
import { CreateCartService } from '../../shared/create-cart/create-cart.service';
import { AddItemService } from '../../shared/add-item/add-item.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NotificationService } from '../../shared/notification/notification.service';
import { SaveSaleitemService } from 'src/app/shared/save-saleitem/save-saleitem.service';

@Component({
  selector: 'app-save-saleitem',
  templateUrl: './save-saleitem.component.html',
  styleUrls: ['./save-saleitem.component.css']
})
export class SaveSaleitemComponent implements OnInit {
  form: FormGroup;
  cart: Cart = new Cart();
  buy: BuyItem = new BuyItem();
  // categories: Category[];
  // units: Unit[];
  saveitem: SaleItem;
  id:  any;
  id2: any;
  id3: any;
  amount: number;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private create: CreateCartService,
    private fb: FormBuilder,
    private add: AddItemService,
    private save: SaveSaleitemService,
    public notification: NotificationService
  ) { }

  ngOnInit() {

      this.route.params.subscribe(param => {
      this.id2 = param['id2'];
      //console.log("eid",this.id2);
  });

  
      this.route.params.subscribe(param => {
      this.id3 = param['id3'];
      //console.log("customerId",this.id3);
});

    this.createForm();
    this.route.params.subscribe(param => {
    this.id = param['id'];
      this.save.findBuyItem(this.id).subscribe((res) => {
        console.log(res);
        this.buy = res;
      });
    }, err => {
      console.log(err);
    });
  }
  submit(){
    this.saveitem = Object.assign({}, this.form.value);
    //console.log(this.saveitem);
    let a = this.buy.amount - this.saveitem.amount;
    if(a < 0){
      this.notification.over();
    }else{
      this.save.SaveSaleItem(this.id2,this.id3,this.id, this.saveitem).subscribe(() => {
        this.notification.success();
      }, err => {
        this.notification.error();  
      });
    }
  }

  createForm(){
      this.form = this.fb.group({
      // itemName: ['', Validators.required],      
      price: ['', Validators.required],
      amount: ['', Validators.required]
    });
  }
}
