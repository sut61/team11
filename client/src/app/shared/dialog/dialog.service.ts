import { Injectable } from '@angular/core';
import { from } from 'rxjs';
import {MatSnackBar, MatSnackBarConfig} from '@angular/material';

@Injectable({
  providedIn: 'root'
})
export class DialogService {

  constructor(public snackBar: MatSnackBar) { }

  config: MatSnackBarConfig = {
    duration: 3000,
    horizontalPosition: "center"
  }
  foundNull(){
    this.config['panelClass'] = ['notification', 'error'];
    this.snackBar.open('  ข้อมูลไม่ถูกต้อง  ','', this.config);
  }
}
