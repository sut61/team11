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
<<<<<<< HEAD
=======
  MatDialogModule,
>>>>>>> issue-117
  MatSnackBarModule
} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { PageLayoutComponent } from './page-layout/page-layout.component';
import { CustomerComponent } from './components/customer/customer.component';
import { EmployeeComponent } from './components/employee/employee.component';  
import { FindCustomerComponent } from './components/find-customer/find-customer.component';
import { CreateCartComponent } from './components/create-cart/create-cart.component';
import { ViewListItemComponent } from './components/view-list-item/view-list-item.component';
import { EmpComponent } from './components/emp/emp.component';
import { QUOTATIONComponent } from './components/quotation/quotation.component';
import { RefindCartComponent } from './components/refind-cart/refind-cart.component';
import { RefindEmpComponent } from './components/refind-emp/refind-emp.component';
<<<<<<< HEAD
import { ViewCartItemComponent } from './components/view-cart-item/view-cart-item.component';
import { CreateReceiptComponent } from './components/create-receipt/create-receipt.component';
import { FindEmployeeComponent } from './components/find-employee/find-employee.component';
import { AddItemComponent } from './components/add-item/add-item.component';
import { FindCustomer21Component } from './components/find-customer21/find-customer21.component';
import { SaleItemComponent } from './components/sale-item/sale-item.component';
=======
>>>>>>> issue-117


import { SaveEmployeeComponent } from './components/save-employee/save-employee.component';

const routes: Routes = [
  {path: '', redirectTo: '/customer', pathMatch: 'full'},
  {path: 'customer', component: CustomerComponent},
  {path: 'employee', component: EmployeeComponent},
  {path: 'find-customer', component: FindCustomerComponent},
  {path: ':id/createCart', component: CreateCartComponent},
  {path: ':id/view-list', component: ViewListItemComponent},
  {path: 'Emp', component: EmpComponent},
  {path: ':id/QUOTATION', component: QUOTATIONComponent},
<<<<<<< HEAD
  {path: 'refind-emp', component: RefindEmpComponent},
  {path: ':id/RefindCart', component: RefindCartComponent},
  {path: ':id/view-cart-item', component: ViewCartItemComponent},
  {path: ':id/create-receipt', component: CreateReceiptComponent},
  {path: 'find-employee', component: FindEmployeeComponent},
  {path: ':id/add-item', component: AddItemComponent},
  {path: ':id/findCustomer', component: FindCustomer21Component},
  {path: ':id/SaleItem', component: SaleItemComponent}
=======
  {path: 'RefindEmp', component: RefindEmpComponent},
  {path: ':id/RefindCart', component: RefindCartComponent},
  {path: 'save-employee', component: SaveEmployeeComponent}
>>>>>>> issue-117
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
    RefindCartComponent,
    RefindEmpComponent,
<<<<<<< HEAD
    ViewCartItemComponent,
    CreateReceiptComponent,
    FindEmployeeComponent,
    AddItemComponent,
    FindCustomer21Component,
    SaleItemComponent
=======
    SaveEmployeeComponent,
    
>>>>>>> issue-117
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
<<<<<<< HEAD
    MatSnackBarModule
=======
    MatDialogModule,
    MatSnackBarModule 
>>>>>>> issue-117
  ],
  providers: [


  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
