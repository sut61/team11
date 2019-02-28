import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Receipt } from '../view-cart-item/view-cart-item.service';
import { Cart } from '../refind-cart/refind-cart.service';
import { MatSnackBar, MatSnackBarConfig } from '@angular/material';

@Injectable({
  providedIn: 'root'
})
export class CreateReceiptService {
  public API: string = "//localhost:8080";
  constructor(    
    private http: HttpClient,
    public snackBar: MatSnackBar

  ) { }

  config: MatSnackBarConfig = {
    duration: 5000,
    horizontalPosition: 'right',
    verticalPosition: 'top'
  }

  notificationError(){
    this.config['panelClass'] = ['notification','error'];
    this.snackBar.open('ข้อมูลผิดพลาด, โปรดตรวจสอบข้อมูล','', this.config);
  }
  notificationSuccess(){
    this.config['panelClass'] = ['notification','success'];
    this.snackBar.open('บันทึกข้อมูลสำเร็จ','', this.config);
  }

  reUpdate(cartId: any,cart: Cart){
    console.log(cart);
    return this.http.put(this.API + '/reUpdate/' + cart.cartId, cart);
  }

  create(netPrice: any, eid: any, bid: any, cartId: any, receipt: Receipt){
    console.log(receipt);
    return this.http.post(this.API + '/newReceipt/' + receipt.netPrice + '/' + eid + '/' + bid + '/' + cartId, receipt);
  }
}
