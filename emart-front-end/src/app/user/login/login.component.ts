import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";

interface Alert {
    type: string;
    message: string;
}

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    alerts: Alert[];

    constructor(private router: Router) {
    }

    ngOnInit(): void {
    }

    onSubmit(value: any) {
        if (this.validateInput(value)) {
            // this.userService.postSignIn(value).subscribe(
            //     data => {
            //         console.log(JSON.stringify(data));
            //         const info: any = data;
            //         if (200 === info.code) {
            //             console.log('登录成功，调转详情页');
            //             sessionStorage.setItem('token', info.result.token)
            //             this.router.navigate(['/home']);
            //         } else {
            //             console.log('登录失败，弹出MSG');
            //             this.alerts.push({ type: 'danger', message: 'username or password error!' });
            //         }
            //     }
            // );
        }
    }

    close(alert: Alert): void {
        this.alerts.splice(this.alerts.indexOf(alert), 1);
    }

    clearAlerts(): void {
        this.alerts = [];
    }

    private validateInput(value: any): boolean {
        this.clearAlerts();
        let result = true
        if (!value.username) {
            this.alerts.push({ type: 'danger', message: 'username required!' });
            result = false;
        }

        if (!value.password) {
            this.alerts.push({ type: 'danger', message: 'password required!' });
            result = false;
        }

        if (value.password.length < 6) {
            this.alerts.push({ type: 'danger', message: 'password length must be greater than 6!' });
            result = false;
        }
        return result;
    }
}
