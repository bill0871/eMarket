import { Component, DoCheck, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'app-navbar',
    templateUrl: './navbar.component.html',
    styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit, DoCheck {
    isSignin: boolean;
    username: string;

    constructor(private route: Router) {
    }

    ngOnInit(): void {
        this.checkLogin();
    }

    ngDoCheck() {
        this.checkLogin();
    }

    signOut() {
        sessionStorage.clear();
        this.route.navigate(['/home']);
    }

    private checkLogin() {
        const session = sessionStorage.getItem('login');
        if (sessionStorage.getItem('username') != null) {
            this.username = sessionStorage.getItem('username');
        } else {
            this.username = 'User';
        }
        this.isSignin = (session && session === '1');
    }
}
