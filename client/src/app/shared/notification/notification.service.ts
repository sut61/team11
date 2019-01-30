import { Injectable } from '@angular/core';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material';
@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(
    public snackBar: MatSnackBar
  ) { }

  config: MatSnackBarConfig = {
    duration: 5000,
    horizontalPosition: 'right',
    verticalPosition: 'top'
  }

  notFound(){
    this.config['panelClass'] = ['notification','warn'];
    this.snackBar.open('ไม่พบข้อมูล !!!','', this.config);
  }
  error(){
    this.config['panelClass'] = ['notification','error'];
    this.snackBar.open('มีบางอย่างผิดพลาด, ลองใหม่อีกครั้ง !!!','', this.config);
  }
}
