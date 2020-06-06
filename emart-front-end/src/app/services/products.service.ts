import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";

export interface IProduct {
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

    getProducts(): Observable<IProduct[]> {
        return this.httpClient.get<IProduct[]>('/item/getAllItems');
    }

}
