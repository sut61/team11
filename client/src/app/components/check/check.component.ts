import { Component, OnInit } from '@angular/core';
import { CheckService, Checks } from 'src/app/shared/check/check.service';
import { CheckEmployeeService,Employee } from 'src/app/shared/checkEmployee/check-employee.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { HttpClient} from '@angular/common/http';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material';
@Component({
  selector: 'app-check',
  templateUrl: './check.component.html',
  styleUrls: ['./check.component.css']
})
export class CheckComponent implements OnInit {

  check: Checks = new Checks();
  id2: any;
  employee: Employee = new Employee();
  sub2: Subscription;
  date: Date;
  buyItems: Array<any>;
  categorizes: Array<any>;
  check1s: Array<any>;
  evaluate:any;
  constructor(private service:CheckService,
    private find2: CheckEmployeeService,
    // private route: Router,
    private httpClient: HttpClient,
    private route: ActivatedRoute,
    public snackBar: MatSnackBar
     ) {
      this.date = new Date();
      }
      config: MatSnackBarConfig = {
        duration: 1000,
        horizontalPosition: 'right',
        verticalPosition: 'top'
      }

  ngOnInit() {
    this.service.getBuyItems().subscribe(data => {
      this.buyItems = data;
      console.log(this.buyItems);
    });
    this.service.getCategorize().subscribe(data => {
      this.categorizes = data;
    });
    this.service.getChecks().subscribe(data => {
        this.check1s = data;
        console.log(this.check1s);
      });
  this.sub2 = this.route.params.subscribe(param => {
    this.id2 = param['id'];
    // console.log(this.id);
    this.find2.checkEmployee(this.id2).subscribe((data) => {
      this.employee = data;
    });
  }, err => {
    console.log(err + "Errororororor");
  });
}

save() {
    this.evaluate = this.check.evaluate;
    console.log(this.evaluate);
      this.checkerror()
      this.httpClient.post('//localhost:8080/Checks/' + this.id2 + '/' + this.check.buyItem.buyItemId +'/'+ this.check.evaluate + '/'
       + this.check.weight + '/' + this.check.categorize.categorizeId,
      this.check)
      .subscribe(
          data => {
              console.log('PUT Request is successful', data);
          },
          error => {
              console.log('Rrror', error);
              this.config['panelClass'] = ['notification','error'];
              this.snackBar.open('ไม่สามารถบันทึกข้อมูลได้','', this.config);
          }
        );
        // this.router.navigate(['/customer']).then(() => {
        // });
        
        // }else{
        //   console.log("คุณกรอกข้อมูลไม่ครบ");
        // }
    }
  
    checkerror(){
      this.config['panelClass'] = ['notification','error'];
      this.snackBar.open('บันทึกข้อมูลเสร็จแล้ว','', this.config);
    }

}
