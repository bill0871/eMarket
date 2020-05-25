import { Component, OnInit } from '@angular/core';
import { ProductsService } from '../services/products.service';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

    products: any;

    constructor(private productsService: ProductsService) {
    }

    ngOnInit(): void {
        this.products = this.getProducts();
    }

    getProducts(): any {
        return this.productsService.getProducts();
    }
}
