import { Component, OnInit } from '@angular/core';
import { CheckService, Checks } from 'src/app/shared/check/check.service';
import { CheckEmployeeService,Employee } from 'src/app/shared/checkEmployee/check-employee.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { HttpClient} from '@angular/common/http';
@Component({
  selector: 'app-check',
  templateUrl: './check.component.html',
  styleUrls: ['./check.component.css']
})
export class CheckComponent implements OnInit {

  checks: Checks = new Checks();
  id2: any;
  employee: Employee = new Employee();
  sub2: Subscription;
  date: Date;
  BuyItems: Array<any>;
  Categorizes: Array<any>;
  Check1s: Array<any>;
  constructor(private service:CheckService,
    private find2: CheckEmployeeService,
    // private route: Router,
    private httpClient: HttpClient,
    private route: ActivatedRoute,
     ) {
      this.date = new Date();
      }

  ngOnInit() {
    this.service.getBuyItems().subscribe(data => {
      this.BuyItems = data;
      console.log(this.BuyItems);
    });
    this.service.getCategorize().subscribe(data => {
      this.Categorizes = data;
    });
    this.service.getChecks().subscribe(data => {
        this.Check1s = data;
        console.log(this.Check1s);
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

}
