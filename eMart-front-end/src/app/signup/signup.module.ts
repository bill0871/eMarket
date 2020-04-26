import { NgModule } from '@angular/core';
import { SignupComponent } from "./signup.component";
import { RouterModule } from "@angular/router";
import { signupRoutes } from "./signup.routes";
import { FormsModule } from "@angular/forms";
import { CommonModule } from "@angular/common";


@NgModule({
    declarations: [
        SignupComponent
    ],
    imports: [
        FormsModule,
        RouterModule.forChild(signupRoutes),
        CommonModule
    ]
})
export class SignupModule {
}
