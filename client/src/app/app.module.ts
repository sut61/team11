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
  MatSidenavModule
} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { PageLayoutComponent } from './page-layout/page-layout.component';
import { CustomerComponent } from './components/customer/customer.component';
<<<<<<< HEAD
import { FindCustomerComponent } from './components/find-customer/find-customer.component';
=======
import { EmployeeComponent } from './components/employee/employee.component';  
>>>>>>> ทำ employee UI - close #89

const routes: Routes = [
  {path: '', redirectTo: '/customer', pathMatch: 'full'},
  {path: 'customer', component: CustomerComponent},
<<<<<<< HEAD
  {path: 'find-customer', component: FindCustomerComponent}
=======
  {path: 'employee', component: EmployeeComponent}  
>>>>>>> ทำ employee UI - close #89
];

@NgModule({
  declarations: [
    AppComponent,
    PageLayoutComponent,

    
    CustomerComponent,

    
<<<<<<< HEAD
    FindCustomerComponent
=======
    EmployeeComponent
>>>>>>> ทำ employee UI - close #89
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
    MatSidenavModule
  ],
  providers: [


  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
