import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { RefindEmpService, Employee } from '../../shared/refind-emp/refind-emp.service';
@Component({
  selector: 'app-refind-emp',
  templateUrl: './refind-emp.component.html',
  styleUrls: ['./refind-emp.component.css']
})
export class RefindEmpComponent implements OnInit {
  id: any;
  employee: Employee = new Employee();
  sub: Subscription;

  constructor(
    private service: RefindEmpService,
    private router: Router,
    private route: ActivatedRoute,
  ) { }

  ngOnInit() {

  }

  
  onClickEmp(){
    this.sub = this.service.reFindEmployee(this.id).subscribe((res) => {
      console.log(res);
      this.employee = res;
      console.log(this.employee.eid);
      this.router.navigate([`${this.employee.eid}/refind-cart`]);
    },err => {
      console.log('Error happen!!!', err);
    });
  }
}
