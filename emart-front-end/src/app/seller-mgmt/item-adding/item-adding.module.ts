import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ItemAddingRoutingModule } from './item-adding-routing.module';
import { ItemAddingComponent } from './item-adding.component';


@NgModule({
  declarations: [ItemAddingComponent],
  imports: [
    CommonModule,
    ItemAddingRoutingModule
  ]
})
export class ItemAddingModule { }
