import { NgModule } from '@angular/core';
import { SignupComponent } from "./signup.component";
import { FormsModule } from "@angular/forms";
import { CommonModule } from "@angular/common";


@NgModule({
    declarations: [
        SignupComponent
    ],
    imports: [
        FormsModule,
        CommonModule
    ]
})
export class SignupModule {
}
