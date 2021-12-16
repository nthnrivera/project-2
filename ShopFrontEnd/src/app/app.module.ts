import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { RegisterFormComponent } from './registration-form/registration-form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { CartBadgeComponent } from './cart-badge/cart-badge.component';
import { CartViewComponent } from './cart-view/cart-view.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ProductHomeComponent } from './product-home/product-home.component';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductViewComponent } from './product-view/product-view.component';

const routes: Routes = [
 
    { path: '', pathMatch: "full", redirectTo: 'product-home' },
    { path: 'login-form', pathMatch: "full", redirectTo: 'login-form' },
    { path: 'cart-view', pathMatch: "full", redirectTo: 'cart-view'},
    { path: 'registration-form', pathMatch: "full", redirectTo: 'registration-form'},
    { path: 'logout', pathMatch: "full", redirectTo: 'login-form'}
  
 
]

@NgModule({
  declarations: [
    AppComponent,
    CartBadgeComponent,
    CartViewComponent,
    LoginFormComponent,
    NavbarComponent,
    ProductHomeComponent,
    ProductListComponent,
    ProductViewComponent,
    RegisterFormComponent
  
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
