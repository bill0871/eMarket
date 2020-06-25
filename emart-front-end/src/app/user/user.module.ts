import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { BuyerComponent } from './signup/buyer/buyer.component';
import { SellerComponent } from './signup/seller/seller.component';
import { RouterModule } from '@angular/router';


@NgModule({
    declarations: [LoginComponent, BuyerComponent, SellerComponent],
    imports: [
        CommonModule,
        NgbModule,
        FormsModule,
        HttpClientModule,
        ReactiveFormsModule,
        RouterModule
    ]
})
export class UserModule {
}
