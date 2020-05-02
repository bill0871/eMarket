import { NgModule } from '@angular/core';

import { ListItemsRoutingModule } from './list-items-routing.module';
import { ListItemsComponent } from './list-items.component';
import { CommonModule } from "@angular/common";


@NgModule({
    declarations: [
        ListItemsComponent
    ],
    imports: [
        ListItemsRoutingModule,
        CommonModule
    ]
})
export class ListItemsModule {
}
