import { Component, OnInit } from '@angular/core';
import { Account } from '../../shared/models/model-class';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  account: Account = new Account();
  formLogin: FormGroup;
  constructor(
    private router: Router,
    private fb: FormBuilder
  ) { }

  ngOnInit() {
    this.createFormLogin();
  }

  login(){
    this.account = this.formLogin.value;
    console.log(this.account);
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
