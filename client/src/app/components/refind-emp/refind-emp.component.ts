import { Component, OnInit } from '@angular/core';
import { Employee } from '../../shared/models/model-class';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { RefindEmpService } from '../../shared/refind-emp/refind-emp.service';
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
    private find: RefindEmpService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
  }
  
  onClickEmp(){
    this.sub = this.find.refindEmployee(this.id).subscribe((res) => {
      // console.log(res);
      this.employee = res;
      // console.log(this.employee.eId);
      this.router.navigate([`${this.employee.eid}/RefindCart`]);
    },err => {
      console.log('Error happen!!!', err);
    });
  }
}
