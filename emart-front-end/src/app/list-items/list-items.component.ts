import { Component, OnInit } from '@angular/core';
import { ProductsService } from "../services/products.service";

@Component({
    selector: 'app-list-items',
    templateUrl: './list-items.component.html',
    styleUrls: ['./list-items.component.css']
})
export class ListItemsComponent implements OnInit {

    products;

    constructor(private productsService: ProductsService) {
    }

    ngOnInit(): void {
        this.products = this.searchProducts();
    }

    searchProducts(): any {
        return this.productsService.getProducts();
    }
}
