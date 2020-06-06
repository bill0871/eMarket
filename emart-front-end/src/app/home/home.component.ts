import { Component, OnInit } from '@angular/core';
import { IProduct, ProductsService } from '../services/products.service';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

    products: IProduct[];

    constructor(private productsService: ProductsService) {
    }

    ngOnInit(): void {
        this.getProducts();
    }

    getProducts(): void {
        this.productsService.getProducts().subscribe(res => this.products = res);
    }
}
