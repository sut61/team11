import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { CheckEmployeeService,Employee } from 'src/app/shared/checkEmployee/check-employee.service';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material';


@Component({
  selector: 'app-check-employee',
  templateUrl: './check-employee.component.html',
  styleUrls: ['./check-employee.component.css']
})
export class CheckEmployeeComponent implements OnInit {

  id: any;
  employee: Employee = new Employee();
  sub: Subscription;
  employees: Array<any>;
  constructor(
    
    private find: CheckEmployeeService,
    private router: Router,
    private route: ActivatedRoute,
    public snackBar: MatSnackBar
  ) { }
  config: MatSnackBarConfig = {
    duration: 5000,
    horizontalPosition: 'right',
    verticalPosition: 'top'
  }

  ngOnInit() {

  }
  
  onClick(){
      this.find.checkEmployee(this.id).subscribe((res) => {
        // console.log(res);
        this.employee = res;
        // console.log(this.employee.eId);
        this.router.navigate([`${this.employee.eid}/Check`]);

    },err => {
      this.config['panelClass'] = ['notification','error'];
      this.snackBar.open('ไม่สามารถบันทึกข้อมูลได้','', this.config);
      console.log(err);
    });
    // this.config['panelClass'] = ['notification','error'];
    // this.snackBar.open('ไม่สามารถบันทึกข้อมูลได้','', this.config);
  }

}
