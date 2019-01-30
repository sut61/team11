import { Component, OnInit } from '@angular/core';
import { FindCustomerService } from '../../shared/find-customer/find-customer.service';
import { Customer,SaleItem,BuyItem } from '../../shared/models/model-class';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription, from } from 'rxjs';
import { SaleItemService } from '../../shared/sale-item/sale-item.service';
import { FindEmployeeService } from 'src/app/shared/find-employee/find-employee.service';


@Component({
  selector: 'app-sale-item',
  templateUrl: './sale-item.component.html',
  styleUrls: ['./sale-item.component.css']
})
export class SaleItemComponent implements OnInit {

  customer: Customer = new Customer();
  sale: SaleItem = new SaleItem();
  id: any;
  sub: Subscription;
  saleItems: Array<SaleItem>;  
  displayedColumns: string[] = ['itemName', 'price', 'amount', 'totalPrice', 'category', 'unit'];
  buyItems: Array<BuyItem>;
  constructor(
    private find: FindCustomerService,
    private router: Router,
    private route: ActivatedRoute,
    private saleSer: SaleItemService,
    private emp : FindEmployeeService
    
  ) { }

  ngOnInit() {
        this.route.params.subscribe(param => {
        this.id = param['id'];
        // console.log(this.id);
        this.emp.findEmployee(this.id).subscribe((data2) =>{
        // console.log(data2);
        } ) 
         
        

         this.find.findCustomer(this.id).subscribe((data) => {
         this.customer = data;
       });

      // this.saleSer.getSaleItem(this.id).subscribe((data) => {
      //   this.sale = data;
      //   this.saleItems = [];
      //   this.sale.saleItems.forEach(el =>{
      //      console.log(el);
      //     this.saleItems.push(el);
      //   });
      //    console.log(this.sale);
      //    console.log(this.saleItems);
      // });
    }, err => {
      console.log(err + "Errororororor");
    });

    this.saleSer.getBuyItem().subscribe((data) => {
      // console.log(data);
      this.buyItems = data;
    });
  }

  // SaleItem(){
  //   this.saleSer.SaleItem(this.customer.customerId, this.sale).subscribe((res) => {
  //     console.log(res);
  //   })
  // }

}
