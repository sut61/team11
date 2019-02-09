import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { PromotionService, Promotion } from 'src/app/shared/promotion/promotion.service';
import { HttpClient} from '@angular/common/http';
import { Employee } from 'src/app/shared/quotation/quotation.service';
import { RefindEmpService } from 'src/app/shared/refind-emp/refind-emp.service';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material';


@Component({
  selector: 'app-promotion',
  templateUrl: './promotion.component.html',
  styleUrls: ['./promotion.component.css']
})
export class PromotionComponent implements OnInit {
  id2: any;
  employee: Employee = new Employee();
  sub2: Subscription;

  promotion: Promotion = new Promotion();
  promotions: Array<any>;
  branches: Array<any>;
  employees: Array<any>;
  typePromotions : Array<any>;


  constructor(
    private find2: RefindEmpService,
    private router: Router,
    private route: ActivatedRoute,
    private httpClient: HttpClient,
    public snackBar: MatSnackBar,
    private service: PromotionService
) { }

  config: MatSnackBarConfig = {
    duration: 1000,
    horizontalPosition: 'right',
    verticalPosition: 'top'
  }

  ngOnInit() {
    this.service.getPromotion().subscribe(data => {
      this.promotions = data;
    });

    this.service.getEmployee().subscribe(data => {
      this.employees = data;
      console.log(this.employees)
    });

    this.service.getBranch().subscribe(data => {
      this.branches = data;
      console.log(this.branches);
    });
    this.service.getTypePromotion().subscribe(data => {
      this.typePromotions = data;
      console.log(this.typePromotions);
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

    if( this.id2 != null && this.promotion != null ){
    
    console.log(this.promotion);
    this.httpClient.post('//localhost:8080/Promotion/' + this.id2,this.promotion)

    .subscribe(
      data => {
          console.log('PUT Request is successful', data);
          this.config['panelClass'] = ['notification','er'];
          this.snackBar.open('บันทึกข้อมูลเสร็จแล้ว','', this.config);
          this.router.navigate(['/EmpPromotion']).then(() => {});
      },
      
      error => {
          // console.log('Rrror', error);
          this.config['panelClass'] = ['notification','error'];
          this.snackBar.open('ไม่สามารถบันทึกข้อมูลได้','', this.config);
          this.router.navigate(['/Promotion']).then(() => {
          });
          
      }
    );
   
    
    }else{
      console.log("คุณกรอกข้อมูลไม่ครบ");
      this.config['panelClass'] = ['notification','error'];
      this.snackBar.open('ไม่สามารถบันทึกข้อมูลได้','', this.config);
    }
}

}
