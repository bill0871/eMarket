import { LoginComponent } from "./login.component";
import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";

const loginRoutes: Routes = [
    { path: '', component: LoginComponent }
]

@NgModule({
    imports: [RouterModule.forChild(loginRoutes)]
})
export class LoginRoutingModule {
}