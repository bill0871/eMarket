import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from "rxjs";

export interface IProduct {
  id: string;
  name: string;
  price: number;
}

@Injectable({
    providedIn: 'root'
})
export class ProductsService {

    products = [
        {
            id: 'ABC8441189035',
            name: 'Tshirt',
            price: 299.99
        },
        {
            id: 'DEF6510463347',
            name: 'Shoes',
            price: 299.99
        },
        {
            id: 'GHI0831819467',
            name: 'Handbags',
            price: 299.99
        },
        {
            id: 'ABC8441189035',
            name: 'Tshirt',
            price: 299.99
        },
        {
            id: 'DEF6510463347',
            name: 'Shoes',
            price: 299.99
        },
        {
            id: 'ABC8441189035',
            name: 'Tshirt',
            price: 299.99
        },
        {
            id: 'DEF6510463347',
            name: 'Shoes',
            price: 299.99
        },
        {
            id: 'GHI0831819467',
            name: 'Handbags',
            price: 299.99
        },
        {
            id: 'ABC8441189035',
            name: 'Tshirt',
            price: 299.99
        },
        {
            id: 'DEF6510463347',
            name: 'Shoes',
            price: 299.99
        }
    ];


    constructor(private http: HttpClient) {}

    getProducts() {
      return this.http.get('https://www.baidu.com/');
    }
}
