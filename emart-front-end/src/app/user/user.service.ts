import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Buyer } from "./model/buyer";
import { Seller } from "./model/seller";

@Injectable({
    providedIn: 'root'
})
export class UserService {


    constructor(private httpClient: HttpClient) {
    }

    registerBuyer(buyer: Buyer) {
        return this.httpClient.post('/user/signup/buyer', buyer, {
            headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
            observe: 'response'
        });
    }

    registerSeller(seller: Seller) {
        return this.httpClient.post('/user/signup/seller', seller, {
            headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
            observe: 'response'
        });
    }


    login(user) {
        return this.httpClient.post('/user/login/buyer', JSON.stringify(user), {
            headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
            observe: 'response'
        });
    }
}
