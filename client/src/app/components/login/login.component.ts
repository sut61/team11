import { Component, OnInit } from '@angular/core';
import { Account } from '../../shared/models/model-class';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LoginService } from '../../shared/login/login.service';
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
    private router: Router,
    private fb: FormBuilder,
    private _login: LoginService
  ) {}

  ngOnInit() {
    this.createFormLogin();
  }

  submit(){
    this.account = this.formLogin.value;
    this._login.submit(this.account.username, this.account.password).subscribe((res) => {
      console.log(res);
      this.rec = res;
      this._login.login(this.rec.accId).subscribe((login) => {
        localStorage.setItem('account',JSON.stringify(login));
        this.router.navigate(['/customer']);
        console.log(login);
      }, err => {
        console.log(err + 'IN');
      });
    }, er => {
      console.log(er + 'OUT');
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

  login(){

  }

}
