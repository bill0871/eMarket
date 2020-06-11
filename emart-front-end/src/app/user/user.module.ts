import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
import { HttpClientModule } from "@angular/common/http";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { SignupComponent } from "./signup/signup.component";
import { LoginComponent } from "./login/login.component";
import { BuyerComponent } from './signup/buyer/buyer.component';
import { SellerComponent } from './signup/seller/seller.component';


@NgModule({
    declarations: [LoginComponent, SignupComponent, BuyerComponent, SellerComponent],
    imports: [
        CommonModule,
        NgbModule,
        FormsModule,
        HttpClientModule,
        UserRoutingModule,
        ReactiveFormsModule
    ]
})
export class UserModule {
}
