import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ListItemsRoutingModule } from './list-items-routing.module';
import { ListItemsComponent } from './list-items.component';


@NgModule({
    declarations: [
        ListItemsComponent
    ],
    imports: [
        CommonModule,
        ListItemsRoutingModule
    ]
})
export class ListItemsModule {
}
