import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from "@angular/forms";

@Component({
    selector: 'app-signup',
    templateUrl: './signup.component.html',
    styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

    role: string;
    registerForm: FormGroup;

    constructor(private fb: FormBuilder) {

        this.registerForm = this.fb.group({
            username: ['', [Validators.required, Validators.minLength(6)]],
            // mobile: ['',this.mobileValidator],
            passwordGroup: this.fb.group({
                password: ['', Validators.minLength(6)],
                pconfirm: ['']
            }, { validator: this.equalValidator })
        });
    }

    equalValidator(group: FormGroup): any {

        const password = group.get('password') as FormControl;
        const pconfirm = group.get('pconfirm') as FormControl;

        let isEqual: boolean = (password.value === pconfirm.value);
        return isEqual ? null : { equal: { info: 'Inconsistent password!' } };
    }

    ngOnInit(): void {
        this.role = "buyer";
    }

    signup() {
        alert("signup")
    }
}
