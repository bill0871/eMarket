import { SignupComponent } from "./signup.component";
import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";


const signupRoutes = [
    { path: '', component: SignupComponent }
]

@NgModule({
    imports: [
        RouterModule.forChild(signupRoutes)
    ]
})
export class SignupRoutingModule {
}