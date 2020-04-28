import { RouterModule, Routes } from "@angular/router";
import { OrderComponent } from "./order.component";
import { NgModule } from "@angular/core";


const orderRoutes: Routes = [
    { path: '', component: OrderComponent }
]

@NgModule({
    imports: [
        RouterModule.forChild(orderRoutes)
    ]
})
export class orderRoutingModule {
}