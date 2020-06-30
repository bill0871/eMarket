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

    constructor(private actRoute: ActivatedRoute, private productsService: ProductsService) {
    }

    ngOnInit(): void {
        const productId = this.actRoute.snapshot.paramMap.get('id');
        this.getProduct(+productId);
    }

    getProduct(id: number) {
        this.productsService.getProducts().subscribe(res => {
            const data: any = res;
            this.product = data.data.find(o => id === o.id);
        });
    }
}
