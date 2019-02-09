import { Component, OnInit } from '@angular/core';
import { SavePrice, PriceTagService } from '../../shared/priceTag/price-tag.service';
import { DialogService } from '../../shared/dialog/dialog.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-save-price',
  templateUrl: './save-price.component.html',
  styleUrls: ['./save-price.component.css']
})
export class SavePriceComponent implements OnInit {

  public API: string = "http://localhost:8080";

  savePrice : SavePrice = new SavePrice(); 
  categories : Array<any>;
  categorie2s : Array<any>;
  usedItems : Array<any>;
  employees : Array<any>;
 

  constructor(private service : PriceTagService,
  private httpClient : HttpClient,
  private dialog : DialogService,
  private router : Router
  ) { }

  ngOnInit() {
    this.service.getCategory().subscribe(data => {
      this. categories = data;
      console.log(this. categories);
    });
    this.service.getCategory().subscribe(data => {
       this.categorie2s = data;
       console.log(this.categorie2s);
     });
    this.service.UsedItem().subscribe(data => {
      this.usedItems = data;
      console.log(this.usedItems);
    });
    this.service.Employee().subscribe(data => {
      this.employees = data;
      console.log(this.employees);
    });
  }
  save(){
    console.log(this.savePrice);
    // console.log(this.savePrice.categorie2.categoryId);
    // console.log(this.savePrice.category.categoryId);
    this.httpClient.post(this.API + '/newSavePrice/'+this.savePrice.category.categoryId+'/'+this.savePrice.categorie2.categoryId,this.savePrice).subscribe((data) => {
     
      console.log(data);
      this.router.navigate(['/priceTag']).then(() => {
      });
     
      
    }, err => {
      console.log("Error Happen!!!!");
      this.dialog.foundNull();
    });
  }


}
