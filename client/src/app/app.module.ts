import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { 
  MatButtonModule,
  MatCardModule,
  MatInputModule,
  MatListModule,
  MatToolbarModule,
  MatFormFieldModule,
  MatSelectModule,
  MatTableModule,
  MatRadioModule,
  MatCheckboxModule,
  MatIconModule,
  MatSidenavModule,
  MatDatepickerModule,
  MatNativeDateModule,
  MatSnackBarModule
} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { PageLayoutComponent } from './page-layout/page-layout.component';
import { CustomerComponent } from './components/customer/customer.component';
import { EmployeeComponent } from './components/employee/employee.component'; 
import { EmpPromotionComponent } from './components/empPromotion/empPromotion.component'; 
import { FindCustomerComponent } from './components/find-customer/find-customer.component';
import { CreateCartComponent } from './components/create-cart/create-cart.component';
import { ViewListItemComponent } from './components/view-list-item/view-list-item.component';
import { EmpComponent } from './components/emp/emp.component';
import { QUOTATIONComponent } from './components/quotation/quotation.component';
import { RefindCartComponent } from './components/refind-cart/refind-cart.component';
import { RefindEmpComponent } from './components/refind-emp/refind-emp.component';
import { ViewCartItemComponent } from './components/view-cart-item/view-cart-item.component';
import { CreateReceiptComponent } from './components/create-receipt/create-receipt.component';
import { FindEmployeeComponent } from './components/find-employee/find-employee.component';
import { AddItemComponent } from './components/add-item/add-item.component';
import { FindCustomer21Component } from './components/find-customer21/find-customer21.component';
import { SaleItemComponent } from './components/sale-item/sale-item.component';
import { PromotionComponent } from './components/promotion/promotion.component';

import { SaveEmployeeComponent } from './components/save-employee/save-employee.component';
import { SaveSaleitemComponent } from './components/save-saleitem/save-saleitem.component';
import { CheckEmployeeComponent } from './components/check-employee/check-employee.component';
import { CheckComponent } from './components/check/check.component';
import { UsedItemFormComponent } from './components/used-item-form/used-item-form.component';

import { RpfindEmpComponent } from './components/rpfind-emp/rpfind-emp.component';
import { CreateRpComponent } from './components/create-rp/create-rp.component';
import { ViewListReportComponent } from './components/view-list-report/view-list-report.component';
import { FindChecksComponent } from './components/find-checks/find-checks.component';
import { LoginComponent } from './components/login/login.component';
import { LoginGuard } from './shared/login/login.guard';
import { PriceTagComponent } from './components/price-tag/price-tag.component';
import { SavePriceComponent } from './components/save-price/save-price.component';

const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'customer', component: CustomerComponent, canActivate: [LoginGuard]},
  {path: 'employee', component: EmployeeComponent, canActivate: [LoginGuard]},
  {path: 'empPromotion', component: EmpPromotionComponent, canActivate: [LoginGuard]},
  {path: 'find-customer', component: FindCustomerComponent, canActivate: [LoginGuard]},
  {path: ':id/createCart', component: CreateCartComponent, canActivate: [LoginGuard]},
  {path: ':id/view-list', component: ViewListItemComponent, canActivate: [LoginGuard]},
  {path: 'Emp', component: EmpComponent, canActivate: [LoginGuard]},
  {path: 'EmpPromotion', component: EmpPromotionComponent, canActivate: [LoginGuard]},
  {path: ':id/QUOTATION', component: QUOTATIONComponent, canActivate: [LoginGuard]},
  {path: ':id/Promotion', component: PromotionComponent, canActivate: [LoginGuard]},
  {path: 'refind-emp', component: RefindEmpComponent, canActivate: [LoginGuard]},
  {path: ':id/RefindCart', component: RefindCartComponent, canActivate: [LoginGuard]},
  {path: ':id/:id2/view-cart-item', component: ViewCartItemComponent, canActivate: [LoginGuard]},
  {path: ':id/:id2/:id3/:id4/create-receipt', component: CreateReceiptComponent, canActivate: [LoginGuard]},
  {path: 'find-employee', component: FindEmployeeComponent, canActivate: [LoginGuard]},
  {path: ':id/add-item', component: AddItemComponent, canActivate: [LoginGuard]},
  {path: ':id/findCustomer', component: FindCustomer21Component, canActivate: [LoginGuard]},
  {path: ':id/SaleItem/:id2', component: SaleItemComponent, canActivate: [LoginGuard]},
  {path: 'RefindEmp', component: RefindEmpComponent, canActivate: [LoginGuard]},
  {path: ':id/RefindCart', component: RefindCartComponent, canActivate: [LoginGuard]},
  {path: 'save-employee', component: SaveEmployeeComponent, canActivate: [LoginGuard]},
  {path: ':id/save-saleitem/:id2/:id3', component: SaveSaleitemComponent, canActivate: [LoginGuard]},
  {path: 'CheckEmployee', component: CheckEmployeeComponent, canActivate: [LoginGuard]},
  {path: ':id/Check', component: CheckComponent, canActivate: [LoginGuard]},
  {path: ':id/used-item-form', component: UsedItemFormComponent, canActivate: [LoginGuard]},
  {path: 'rpfindEmp', component: RpfindEmpComponent, canActivate: [LoginGuard]},
  {path: ':id/create-rp', component: CreateRpComponent, canActivate: [LoginGuard]},
  {path: 'view-list-report', component: ViewListReportComponent, canActivate: [LoginGuard]},
  {path: 'promotion', component: PromotionComponent, canActivate: [LoginGuard]},
  {path: 'findChecks', component: FindChecksComponent, canActivate: [LoginGuard]},
  {path: 'login', component: LoginComponent},
  {path: 'priceTag', component:PriceTagComponent},
  {path: 'saveprice', component:SavePriceComponent}
  
];

@NgModule({
  declarations: [
    AppComponent,
    PageLayoutComponent,
    CustomerComponent,
    EmployeeComponent,
    FindCustomerComponent,
    CreateCartComponent,
    ViewListItemComponent,
    QUOTATIONComponent,
    EmpComponent,
    EmpPromotionComponent,
    RefindCartComponent,
    RefindEmpComponent,
    ViewCartItemComponent,
    CreateReceiptComponent,
    FindEmployeeComponent,
    AddItemComponent,
    FindCustomer21Component,
    SaleItemComponent,
    SaveEmployeeComponent,
    SaveSaleitemComponent,
    CheckEmployeeComponent,
    CheckComponent,
    UsedItemFormComponent,
    RpfindEmpComponent,
    CreateRpComponent,
    ViewListReportComponent,
    FindChecksComponent,
    PromotionComponent,
    LoginComponent,
    PriceTagComponent,
    SavePriceComponent
    
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatSelectModule,
    MatTableModule,
    MatRadioModule,
    MatCheckboxModule,
    MatIconModule,
    MatSidenavModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSnackBarModule,
    MatSnackBarModule 
  ],
  providers: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
