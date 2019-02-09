import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NotificationService } from '../../shared/notification/notification.service';
@Component({
  selector: 'app-find-checks',
  templateUrl: './find-checks.component.html',
  styleUrls: ['./find-checks.component.css']
})
export class FindChecksComponent implements OnInit {

  idChecks: any;
  constructor(
    private router: Router,
    public notification: NotificationService
  ) { }

  ngOnInit() {

  }

  submit(){
    console.log(this.idChecks);
  }

}
