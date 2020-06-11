import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Buyer } from "./model/buyer";

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
}
