import { Component, OnInit } from '@angular/core';
import { Account } from '../../shared/models/model-class';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LoginService } from '../../shared/login/login.service';
import { NotificationService } from 'src/app/shared/notification/notification.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  account: Account = new Account();
  rec: Account;
  formLogin: FormGroup;
  constructor(
    private notification: NotificationService,
    private fb: FormBuilder,
    private _login: LoginService
  ) {}

  ngOnInit() {
    this.createFormLogin();
  }

  submit(){
    this.account = this.formLogin.value;
    this._login.submit(this.account.username, this.account.password).subscribe((res) => {
      this.rec = res;
      this._login.login(this.rec.accId);
    }, er => {
      this.notification.error();
    });
  }

  createFormLogin(){
    this.formLogin = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.compose([
        Validators.required,
        Validators.minLength(6)
      ])]
    });
  }

}
