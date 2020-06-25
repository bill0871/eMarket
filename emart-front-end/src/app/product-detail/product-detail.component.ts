import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product, ProductsService } from '../services/products.service';

@Component({
    selector: 'app-product-detail',
    templateUrl: './product-detail.component.html',
    styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {
    product: Product;
    errorMessage = 'error';

    constructor(private actRoute: ActivatedRoute, private productsService: ProductsService) {
        // this.productId = actRoute.snapshot.params.id;
    }

    ngOnInit(): void {
        const productId = this.actRoute.snapshot.paramMap.get('id');
        this.getProduct(Number(productId));
    }

    getProduct(id: number) {
        this.productsService.getProduct(id).subscribe({
            next: product => this.product = product,
            error: err => this.errorMessage = err
        });
    }
}
