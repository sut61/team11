import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PriceTagService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type' : 'application/json'
    })
  };

  public APT = '//localhost:8080';

  constructor(private http: HttpClient) { }
  getCategory(): Observable<any> {
    return this.http.get(this.APT + '/getCategories');
     
  }

  UsedItem(): Observable<any> {
    return this.http.get(this.APT + '/UsedItem');
   
  }

  Employee(): Observable<any> {
    return this.http.get(this.APT + '/Employee');
   
  }
  SavePrice(): Observable<any> {
    return this.http.get(this.APT + '/SavePrice');
  }

}
export class Category {
categoryId:any;
categoryName:any;
}
export class UsedItem {
usedItemId : any;
price : any;
details : any;
checks : any;

}
export class Employee {
eId : any;
eName : any;
}
export class SavePrice {
savePriceId : any;
category : Category;
priceOne : any;
categorie2 : Category;
priceTwo : any;
usedItem : UsedItem;
employee : Employee;


}
