import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { EmpService } from '../../shared/emp/emp.service';
import { QuotationService, Quotation } from 'src/app/shared/quotation/quotation.service';
import { HttpClient} from '@angular/common/http';
import { Employee } from 'src/app/shared/models/model-class';
import { RefindEmpService } from 'src/app/shared/refind-emp/refind-emp.service';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material';


@Component({
  selector: 'app-quotation',
  templateUrl: './quotation.component.html',
  styleUrls: ['./quotation.component.css']
})
export class QUOTATIONComponent implements OnInit {
  id2: any;
  employee: Employee = new Employee();
  sub2: Subscription;

  quotation: Quotation = new Quotation();
  quotations: Array<any>;
  category: Array<any>;
  customers: Array<any>;
  employees: Array<any>;
  date: Date;
  // date : new Date();
  constructor(
    private find2: RefindEmpService,
    private router: Router,
    private route: ActivatedRoute,
    private httpClient: HttpClient,
    public snackBar: MatSnackBar,
    private service: QuotationService
  ) { 
    
    this.date = new Date();
  }

  config: MatSnackBarConfig = {
    duration: 5000,
    horizontalPosition: 'right',
    verticalPosition: 'top'
  }

  ngOnInit() {
    this.service.getQuotation().subscribe(data => {
      this.quotations = data;
    });
    this.service.getEmployee().subscribe(data => {
      this.employees = data;
      console.log(this.employees);
    });
    this.service.getCategory().subscribe(data => {
        this.category = data;
        console.log(this.category);
        // console.log(this.buyItems.ca)
    });
    this.service.getCustomer().subscribe(data => {
      this.customers = data;
      console.log(this.customers);
    });

    this.sub2 = this.route.params.subscribe(param => {
      this.id2 = param['id'];
      // console.log(this.id);
      this.find2.reFindEmployee(this.id2).subscribe((data) => {
        this.employee = data;
      });
    }, err => {
      console.log(err + "Errororororor");
    });


  }

  save(){
    if( this.id2 != null && this.quotation.customer.customerId != null 
      && this.quotation.category.categoryId != null && this.quotation.detail != null
      && this.quotation.price){
    
    // console.log(this.quotation.employee.eid);
    this.httpClient.post('//localhost:8080/Quotation/' + this.id2 + '/'+ this.quotation.customer.customerId + '/' +
     this.quotation.category.categoryId+ '/' + this.quotation.detail+ '/'
      +this.quotation.price,this.quotation)
      .subscribe(
        data => {
            console.log('PUT Request is successful', data);
            this.config['panelClass'] = ['notification','er'];
            this.snackBar.open('บันทึกข้อมูลเสร็จแล้ว','', this.config);
            this.router.navigate(['/Emp']).then(() =>{});
        },
        
        error => {
            // console.log('Rrror', error);
            this.config['panelClass'] = ['notification','error'];
            this.snackBar.open('ไม่สามารถบันทึกข้อมูลได้','', this.config);
            this.router.navigate(['/QUOTATION']).then(() =>{});
            
        }
      );
      // this.router.navigate(['/Emp']).then(() => {
      // });
      
      }else{
        console.log("คุณกรอกข้อมูลไม่ครบ");
        this.config['panelClass'] = ['notification','error'];
        this.snackBar.open('ไม่สามารถบันทึกข้อมูลได้','', this.config);
      }
  }

}
