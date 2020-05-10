import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ItemAddingComponent } from "./item-adding.component";


const routes: Routes = [
    { path: '', component: ItemAddingComponent }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ItemAddingRoutingModule {
}
