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
  gocustomer(){
    this.router.navigate(['/customer']).then(() => {
      
    });
  }

}
