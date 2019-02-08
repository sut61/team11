import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
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
  insertUsedItem(stockId: any, usedItem: any){
    return this.http.post(this.API + '/' + stockId + '/newUsedItem', usedItem);
  }
}
