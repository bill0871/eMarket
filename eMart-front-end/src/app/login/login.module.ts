import { NgModule } from '@angular/core';
import { LoginComponent } from "./login.component";
import { RouterModule } from "@angular/router";
import { loginRoutes } from "./login.routes";


@NgModule({
    declarations: [
        LoginComponent
    ],
    imports: [
        RouterModule.forChild(loginRoutes)
    ]
})
export class LoginModule {
}
