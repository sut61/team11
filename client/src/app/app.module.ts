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

const routes: Routes = [
  {path: '', redirectTo: '/customer', pathMatch: 'full'},
  {path: 'customer', component: CustomerComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    PageLayoutComponent,

    
    CustomerComponent
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
