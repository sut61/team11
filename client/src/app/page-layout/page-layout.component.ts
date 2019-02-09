import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../shared/login/login.service';
import { Account } from '../shared/models/model-class';
@Component({
  selector: 'app-page-layout',
  templateUrl: './page-layout.component.html',
  styleUrls: ['./page-layout.component.css']
})
export class PageLayoutComponent implements OnInit {

  acc: Account;
  constructor(
    private router: Router,
    private login: LoginService
    ) { 
      this.acc = JSON.parse(localStorage.getItem('account'));
    }

  ngOnInit() {
    this.acc = JSON.parse(localStorage.getItem('account'));
  }
  logout(){
    console.log(this.acc.accId);
    this.login.logout(this.acc.accId).subscribe(() => {
      localStorage.clear();
      this.router.navigate(['/login']);
    });
  }
  goBuyItem(){
    this.router.navigate(['/find-customer']);
  }
  goUsedItemForm(){
    this.router.navigate(['/findChecks']);
  }
  gocustomer(){
    this.router.navigate(['/customer']).then(() => {
      
    });
  }
  addemployee(){
    this.router.navigate(['/employee']).then(() => {
      
    });
  }
  addemp(){
    this.router.navigate(['/Emp']).then(() =>{
    
    });
  }
  RefindEmp(){
    this.router.navigate(['/refind-emp']).then(() =>{
    
    });
  }
  CheckEmployee(){
    this.router.navigate(['/CheckEmployee']).then(() =>{
    
    });
  }
  addempPromotion(){
    this.router.navigate(['/EmpPromotion']).then(() =>{
    
    });
  }
  gofindemployee(){
    this.router.navigate(['/find-employee']).then(() => {
      
    });
  }
  goReportP(){
    this.router.navigate(['/view-list-report']).then(() =>{})
  }

  gopromotion(){
    this.router.navigate(['/promotion']).then(() => {
      
    });
  }
}