import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BuyItem, SaleItem } from '../models/model-class';

@Injectable({
  providedIn: 'root'
})
export class SaveSaleitemService {
  public API: string = "http://localhost:8080";
  constructor(
    private http: HttpClient
  ) { }

  SaveSaleItem(id2:any,id3:any,buyItemId: any,save:SaleItem){
    return this.http.post(this.API + '/' + id3 +'/' + id2 +'/' + buyItemId + '/saleItem', save);
  }

  findBuyItem(id: any){
    return this.http.get(this.API + '/find/' + id);
  }
}
