import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { UserService } from "../../user.service";
import { Seller } from "../../model/seller";

@Component({
    selector: 'app-user-signup-seller',
    templateUrl: './seller.component.html',
    styleUrls: ['./seller.component.css']
})
export class SellerComponent implements OnInit {

    registerForm: FormGroup;

    emailPattern: RegExp = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    constructor(private formBuilder: FormBuilder, private userService: UserService) {

        this.registerForm = this.formBuilder.group({
            username: [null, [Validators.required, Validators.minLength(6), Validators.maxLength(15), Validators.pattern("[0-9a-zA-z]+")]],
            password: [null, [Validators.required, Validators.minLength(6)]],
            email: [null, [Validators.required, Validators.pattern(this.emailPattern)]],
        });
    }

    ngOnInit(): void {
    }

    signup() {
        if (this.registerForm.valid) {
            let username: string = this.registerForm.get('username').value;
            let password: string = this.registerForm.get('password').value;
            let email: string = this.registerForm.get('email').value;

            let contract: Seller = {
                username: username,
                password: password,
                email: email
            }

            this.userService.registerSeller(contract).subscribe(res => {
                if (200 === res.status) {
                    console.log('Sing up successful');
                }
            })
        }
        console.log("signup");
    }
}
