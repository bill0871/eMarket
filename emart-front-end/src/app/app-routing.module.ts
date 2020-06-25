import { ProductDetailComponent } from './product-detail/product-detail.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CartComponent } from './cart/cart.component';
import { LoginComponent } from './user/login/login.component';
import { BuyerComponent } from './user/signup/buyer/buyer.component';
import { SellerComponent } from './user/signup/seller/seller.component';


const routes: Routes = [
    { path: '', pathMatch: 'full', redirectTo: '/home' },
    { path: 'home', component: HomeComponent },

    { path: 'login', component: LoginComponent },
    { path: 'signup/buyer', component: BuyerComponent },
    { path: 'signup/seller', component: SellerComponent },
    {
        path: 'order',
        loadChildren: () => import('./order/order.module').then(o => o.OrderModule)
    },
    {
        path: 'inventory',
        loadChildren: () => import('./seller-mgmt/inventory/inventory.module').then(i => i.InventoryModule)
    },
    {
        path: 'item-adding',
        loadChildren: () => import('./seller-mgmt/item-adding/item-adding.module').then(ia => ia.ItemAddingModule)
    },
    {
        path: 'report',
        loadChildren: () => import('./seller-mgmt/report/report.module').then(r => r.ReportModule)
    },
    {
        path: 'list-items',
        loadChildren: () => import('./list-items/list-items-routing.module').then(l => l.ListItemsRoutingModule)
    },

    { path: 'cart', component: CartComponent },
    { path: 'product-detail/:id', component: ProductDetailComponent },


    { path: '**', component: PageNotFoundComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
