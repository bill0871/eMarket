import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
import { HttpClientModule } from "@angular/common/http";
import { FormsModule } from "@angular/forms";
import { SignupComponent } from "./signup/signup.component";
import { LoginComponent } from "./login/login.component";


@NgModule({
    declarations: [LoginComponent, SignupComponent],
    imports: [
        CommonModule,
        NgbModule,
        FormsModule,
        HttpClientModule,
        UserRoutingModule
    ]
})
export class UserModule {
}
