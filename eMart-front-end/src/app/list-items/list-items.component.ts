import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-list-items',
    templateUrl: './list-items.component.html',
    styleUrls: ['./list-items.component.css']
})
export class ListItemsComponent implements OnInit {

    product_list = [
        {
            id: "ABC8441189035",
            name: "Tshirt",
            price: 299.99
        },
        {
            id: "DEF6510463347",
            name: "Shoes",
            price: 299.99
        },
        {
            id: "GHI0831819467",
            name: "Handbags",
            price: 299.99
        },
        {
            id: "ABC8441189035",
            name: "Tshirt",
            price: 299.99
        },
        {
            id: "DEF6510463347",
            name: "Shoes",
            price: 299.99
        },
        {
            id: "GHI0831819467",
            name: "Handbags",
            price: 299.99
        },
        {
            id: "ABC8441189035",
            name: "Tshirt",
            price: 299.99
        },
        {
            id: "DEF6510463347",
            name: "Shoes",
            price: 299.99
        },
        {
            id: "GHI0831819467",
            name: "Handbags",
            price: 299.99
        },
        {
            id: "ABC8441189035",
            name: "Tshirt",
            price: 299.99
        },
        {
            id: "DEF6510463347",
            name: "Shoes",
            price: 299.99
        },
        {
            id: "GHI0831819467",
            name: "Handbags",
            price: 299.99
        },
        {
            id: "ABC8441189035",
            name: "Tshirt",
            price: 299.99
        },
        {
            id: "DEF6510463347",
            name: "Shoes",
            price: 299.99
        },
        {
            id: "GHI0831819467",
            name: "Handbags",
            price: 299.99
        },
        {
            id: "ABC8441189035",
            name: "Tshirt",
            price: 299.99
        },
        {
            id: "DEF6510463347",
            name: "Shoes",
            price: 299.99
        },
        {
            id: "GHI0831819467",
            name: "Handbags",
            price: 299.99
        }
    ]

    constructor() {
    }

    ngOnInit(): void {
    }

}
