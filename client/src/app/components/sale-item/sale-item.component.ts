import { Component, OnInit } from '@angular/core';
import { FindCustomerService } from '../../shared/find-customer/find-customer.service';
import { Customer,SaleItem,BuyItem, Cart } from '../../shared/models/model-class';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription, from } from 'rxjs';
import { SaleItemService } from '../../shared/sale-item/sale-item.service';
import { FindEmployeeService } from 'src/app/shared/find-employee/find-employee.service';
import { Employee } from 'src/app/shared/refind-emp/refind-emp.service';


@Component({
  selector: 'app-sale-item',
  templateUrl: './sale-item.component.html',
  styleUrls: ['./sale-item.component.css']
})
export class SaleItemComponent implements OnInit {

  cart: Cart = new Cart();
  customer: Customer = new Customer();
  employee: Employee = new Employee();
  sale: SaleItem = new SaleItem();
  id3: any;
  id2:any;
  sub: Subscription;
  saleItems: Array<SaleItem>;  
  displayedColumns: string[] = ['itemName', 'price', 'amount', 'totalPrice', 'category', 'unit','action'];
  buyItems: Array<BuyItem>;
  buyItem: BuyItem = new BuyItem();
  constructor(
    private find: FindCustomerService,
    private router: Router,
    private route: ActivatedRoute,
    private saleSer: SaleItemService,
    private emp : FindEmployeeService
    
  ) { }

  ngOnInit() {

    this.route.params.subscribe(param => {
      this.id2 = param['id2'];
      // console.log("id2",this.id2);
  });


        this.route.params.subscribe(param => {
        this.id3 = param['id'];
        // console.log(this.id3);
        this.emp.findEmployee(this.id3).subscribe((data2) =>{
        // console.log(data2);
        } ) 
         
        

         this.find.findCustomer(this.id3).subscribe((data) => {
         this.customer = data;
       });
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
gosaveitem(save:any ,id2:string,id3:string){
    // console.log(save);
  // this.router.navigate(['/save-saleitem']).then(() => {
    
  // });
   this.router.navigate([`${save}/save-saleitem`,id2,id3]);  
   
  }
}
