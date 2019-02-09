import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NotificationService } from '../../shared/notification/notification.service';
import { FindChecksService } from '../../shared/find-checks/find-checks.service';
@Component({
  selector: 'app-find-checks',
  templateUrl: './find-checks.component.html',
  styleUrls: ['./find-checks.component.css']
})
export class FindChecksComponent implements OnInit {

  idChecks: any;
  getId: any;
  constructor(
    private router: Router,
    public notification: NotificationService,
    private find: FindChecksService
  ) { }

  ngOnInit() {

  }

  submit(){
    this.find.findChecks(this.idChecks).subscribe((resId) => {
      this.getId = resId;
      this.router.navigate([`${this.getId}/used-item-form`]);
    }, error => {
      this.notification.notFound();
      console.log(error);
    });
  }

}
