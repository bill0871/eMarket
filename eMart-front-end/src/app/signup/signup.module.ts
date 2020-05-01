import { NgModule } from '@angular/core';
import { SignupComponent } from "./signup.component";
import { FormsModule } from "@angular/forms";
import { CommonModule } from "@angular/common";
import { SignupRoutingModule } from "./signup.routing.module";


@NgModule({
    declarations: [
        SignupComponent
    ],
    imports: [
        FormsModule,
        CommonModule,
        SignupRoutingModule
    ]
})
export class SignupModule {
}
