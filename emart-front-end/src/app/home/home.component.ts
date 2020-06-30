import { Component, OnInit } from '@angular/core';
import { Product, ProductsService } from '../services/products.service';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

    products: Product[];

    constructor(private productsService: ProductsService) {
    }

    ngOnInit(): void {
        this.getProducts();
    }

    getProducts(): void {
        this.productsService.getProducts().subscribe(data => {
            const res: any = data;
            this.products = res.data;
        });
    }
}
