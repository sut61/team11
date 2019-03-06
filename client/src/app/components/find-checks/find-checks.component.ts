import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NotificationService } from '../../shared/notification/notification.service';
import { FindChecksService } from '../../shared/find-checks/find-checks.service';
import { Checks } from 'src/app/shared/check/check.service';
@Component({
  selector: 'app-find-checks',
  templateUrl: './find-checks.component.html',
  styleUrls: ['./find-checks.component.css']
})
export class FindChecksComponent implements OnInit {

  idChecks: any;
  check: Checks;
  constructor(
    private router: Router,
    public notification: NotificationService,
    private find: FindChecksService
  ) { }

  ngOnInit() {

  }

  submit(){
    this.find.findChecks(this.idChecks).subscribe((resId) => {
      this.check = resId;
      // this.router.navigate([`${this.check.checksId}/used-item-form`]);
      // console.log(this.check);
      if(this.check.usedItem == null){
        this.router.navigate([`${this.check.checksId}/used-item-form`]);
      }else{
        this.notification.uniqueError();
      }
    }, error => {
      this.notification.notFound();
      console.log(error);
    });
  }

}
