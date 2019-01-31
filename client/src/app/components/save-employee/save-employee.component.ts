import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-save-employee',
  templateUrl: './save-employee.component.html',
  styleUrls: ['./save-employee.component.css']
})
export class SaveEmployeeComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }
  addemployee(){
    this.router.navigate(['/employee']).then(() => {
      
    });
  }

}
