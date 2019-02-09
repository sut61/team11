import { Component, OnInit } from '@angular/core';
import { PriceTagService, SavePrice } from '../../shared/priceTag/price-tag.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-price-tag',
  templateUrl: './price-tag.component.html',
  styleUrls: ['./price-tag.component.css']
})
export class PriceTagComponent implements OnInit {

  
  priceTagId : any;
  saveprices : Array<SavePrice>
  categories : Array<any>;
  usedItems : Array<any>;
  employees : Array<any>;

  //displayedColumns: string[] = ['priceTagId','','categoryOne','priceOne','categoryTwo','priceTwo','usedItemId','employeeId'];
  
  constructor(private router: Router,
    private service : PriceTagService) { }

  ngOnInit() {
    // this.showPriceTag();
    this.service.SavePrice().subscribe(data => {
      this. saveprices = data;
      console.log(this. saveprices);
    });
    
  }
  saveprice(){
    this.router.navigate(['/saveprice']).then(() =>{

    });
  }

}
