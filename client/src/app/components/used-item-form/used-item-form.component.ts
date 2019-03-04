import { Component, OnInit } from '@angular/core';
import { Stock, Repairman, UsedItem } from '../../shared/models/model-class';
import { Router, ActivatedRoute } from '@angular/router';
import { UsedItemService } from '../../shared/usedItem/used-item.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NotificationService } from '../../shared/notification/notification.service';
import { Checks } from 'src/app/shared/check/check.service';
import { FindChecksService} from '../../shared/find-checks/find-checks.service';
@Component({
  selector: 'app-used-item-form',
  templateUrl: './used-item-form.component.html',
  styleUrls: ['./used-item-form.component.css']
})
export class UsedItemFormComponent implements OnInit {
  usedItem: UsedItem = new UsedItem();
  checks: Checks = new Checks();
  idChecks: any;
  repairmans: Array<Repairman>;
  stocks: Array<Stock>;
  form: FormGroup;

  constructor(
    private usedService: UsedItemService,
    private router: Router,
    private notification: NotificationService,
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private findCheck: FindChecksService
  ) { }

  ngOnInit() {
    this.createFormUsed();
    this.route.params.subscribe(param => {
      this.idChecks = param['id'];
      this.findCheck.findChecks(this.idChecks).subscribe((res) => {
        this.checks = res;
        console.log(this.checks.checksId);
      });
    }, err => {
      console.log(err);
      this.router.navigate(['/findChecks']);
    });
    this.usedService.getStocks().subscribe((stock) => {
      this.stocks = stock;
    });
    this.usedService.getRepairmans().subscribe((rep) => {
      this.repairmans = rep;
    });
  }
  submit(){
    this.usedItem = Object.assign({}, this.form.value);
    this.usedService.insertUsedItem(this.checks.checksId, this.usedItem).subscribe((res) => {
      this.notification.saveSuccess();
      this.form.reset();
    },error => {
      // console.log(error);
      let str = error.error.message;
      let sError = str.split(";", 1);
      if(sError == "could not execute statement"){
        this.notification.uniqueError();
      }else{
        this.notification.error();
        this.form.reset();
      }
    });
  }

  createFormUsed(){
    this.form = this.fb.group({
      price: ['', Validators.required],
      stock: ['', Validators.required],
      repairman: ['', Validators.required],
      details: ['', Validators.compose([
        Validators.required,
        Validators.minLength(10),
        Validators.maxLength(50)
      ])]
    });
  }
}
