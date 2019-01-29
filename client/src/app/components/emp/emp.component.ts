import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { Employee } from 'src/app/shared/quotation/quotation.service';
import { EmpService } from 'src/app/shared/emp/emp.service';

@Component({
  selector: 'app-emp',
  templateUrl: './emp.component.html',
  styleUrls: ['./emp.component.css']
})
export class EmpComponent implements OnInit {
  id: any;
  employee: Employee = new Employee();
  sub: Subscription;

  constructor(
    private find: EmpService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
  }
  
  onClickEmp(){
    this.sub = this.find.reFindEmployee(this.id).subscribe((res) => {
      // console.log(res);
      this.employee = res;
      console.log(this.employee.eid);
      this.router.navigate([`${this.employee.eid}/QUOTATION`]);
    },err => {
      console.log('Error happen!!!', err);
    });
  }
}
