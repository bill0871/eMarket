import { NgModule } from '@angular/core';
import { OrderRoutingModule } from "./order-routing.module";
import { OrderComponent } from "./order.component";
import { CommonModule } from "@angular/common";


@NgModule({
    declarations: [
        OrderComponent
    ],
    imports: [
        OrderRoutingModule,
        CommonModule
    ]
})
export class OrderModule {
}
