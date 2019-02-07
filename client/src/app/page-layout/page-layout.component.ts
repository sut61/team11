import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-page-layout',
  templateUrl: './page-layout.component.html',
  styleUrls: ['./page-layout.component.css']
})
export class PageLayoutComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }
  goBuyItem(){
    this.router.navigate(['/find-customer']);
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
  gofindemployee(){
    this.router.navigate(['/find-employee']).then(() => {
      
    });
  }
}