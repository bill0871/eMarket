import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
// import {NgbDropdownModule, NgbModule} from "@ng-bootstrap/ng-bootstrap";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ProductsComponent } from './products/products.component';
import { ProductDetailComponent } from './product-detail/product-detail.component';
import { NavbarComponent } from './navbar/navbar.component';
import {NgbDropdownModule} from "@ng-bootstrap/ng-bootstrap";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    HomeComponent,
    PageNotFoundComponent,
    ProductsComponent,
    ProductDetailComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbDropdownModule,
    // NgbDropdownModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
