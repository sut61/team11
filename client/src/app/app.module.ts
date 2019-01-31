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
  MatDialogModule,
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
  {path: 'RefindEmp', component: RefindEmpComponent},
  {path: ':id/RefindCart', component: RefindCartComponent},
  {path: 'save-employee', component: SaveEmployeeComponent}
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
    SaveEmployeeComponent,
    
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
    MatDialogModule,
    MatSnackBarModule 
  ],
  providers: [


  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
