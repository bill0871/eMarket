import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../../user.service';
import { Buyer } from '../../model/buyer';

interface Alert {
    type: string;
    message: string;
}


@Component({
    selector: 'app-user-signup-buyer',
    templateUrl: './buyer.component.html',
    styleUrls: ['./buyer.component.css']
})
export class BuyerComponent implements OnInit {
    alerts: Alert[];
    registerForm: FormGroup;
    emailPattern: RegExp = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    constructor(private formBuilder: FormBuilder, private userService: UserService) {

        this.registerForm = this.formBuilder.group({
            username: [null, [Validators.required, Validators.minLength(6), Validators.maxLength(15), Validators.pattern('[0-9a-zA-z]+')]],
            password: [null, [Validators.required, Validators.minLength(6)]],
            email: [null, [Validators.required, Validators.pattern(this.emailPattern)]],
            mobile: [null, [Validators.required, Validators.pattern(/^[0-9]+$/)]],
        });
    }

    ngOnInit(): void {
    }

    signup() {
        if (this.registerForm.valid) {
            const username: string = this.registerForm.get('username').value;
            const password: string = this.registerForm.get('password').value;
            const email: string = this.registerForm.get('email').value;
            const mobile: string = this.registerForm.get('mobile').value;

            const contract: Buyer = {
                email,
                mobile,
                password,
                username
            };

            this.userService.registerBuyer(contract).subscribe(data => {

                const res: any = data;
                if (200 === res.status && 200001 === res.body.code) {
                    console.log('Sing up successful');
                }

                if (200 === res.status && 500005 === res.body.code) {
                    this.showError();
                }
            });
        }
    }

    private showError() {
        this.clearAlerts();
        this.alerts.push({ type: 'danger', message: 'username already exist!' });
    }

    close(alert: Alert): void {
        this.alerts.splice(this.alerts.indexOf(alert), 1);
    }

    private clearAlerts(): void {
        this.alerts = [];
    }
}
