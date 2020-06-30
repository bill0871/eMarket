import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

export interface Product {
    id: number;
    sellerId: number;
    categoryId: number;
    subcategoryId: number;
    name: string;
    price: number;
    description: string;
    stockNumber: number;
    remarks: string;
}

@Injectable({
    providedIn: 'root'
})
export class ProductsService {

    constructor(private httpClient: HttpClient) {
    }

    getProducts() {
        return this.httpClient.get('/item/getAllItems');
    }

    getProduct(id: number): Observable<Product> {
        return this.getProducts()
        .pipe(
            map((products: Product[]) => products.find(p => p.id === id))
        );
    }

}
