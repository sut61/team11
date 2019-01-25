import { Component, OnInit } from '@angular/core';
import {} from '@angular/router';
@Component({
  selector: 'app-find-customer',
  templateUrl: './find-customer.component.html',
  styleUrls: ['./find-customer.component.css']
})
export class FindCustomerComponent implements OnInit {

  id: any;
  constructor() { }

  ngOnInit() {
  }

  submit(){
    // console.log(this.id);
  }
}
