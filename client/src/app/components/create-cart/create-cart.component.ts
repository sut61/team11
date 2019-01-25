import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Customer, Cart } from '../../shared/models/model-class';
import { FindCustomerService } from '../../shared/find-customer/find-customer.service';
@Component({
  selector: 'app-create-cart',
  templateUrl: './create-cart.component.html',
  styleUrls: ['./create-cart.component.css']
})
export class CreateCartComponent implements OnInit {
  cart: Cart = new Cart();
  customer: Customer = new Customer();
  id: any;
  constructor(
    private find: FindCustomerService,
    private router: Router,
    private route: ActivatedRoute,
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
    // call service create cart
  }

}
