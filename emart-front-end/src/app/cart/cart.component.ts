import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-cart',
    templateUrl: './cart.component.html',
    styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

    orders = [
        {
            name: "aaa"
        },
        {
            name: "aaa"
        },
        {
            name: "aaa"
        },
        {
            name: "aaa"
        },
        {
            name: "aaa"
        },
        {
            name: "aaa"
        }
    ];

    constructor() {
    }

    ngOnInit(): void {
    }

}
