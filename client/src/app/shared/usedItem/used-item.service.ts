import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UsedItem } from '../models/model-class';
@Injectable({
  providedIn: 'root'
})
export class UsedItemService {

  public API: string = "http://localhost:8080";

  constructor(
    private http: HttpClient
  ) { }

  getStocks():Observable<any>{
    return this.http.get(this.API + '/Stocks');
  }
  getRepairmans():Observable<any>{
    return this.http.get(this.API + '/Repairmans');
  }
  insertUsedItem(checksId: any, usedItem: UsedItem){
    return this.http.post(this.API + '/' + checksId + '/newUsedItem', usedItem);
  }
}
