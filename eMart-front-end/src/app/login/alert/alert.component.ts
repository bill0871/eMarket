import {Component} from '@angular/core';

interface Alert {
  type: string;
}

@Component({
  selector: 'app-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.css']
})
export class AlertComponent {

  alert: Alert;

  constructor() {
    this.alert = {
      type: "danger"
    }
  }

  close() {
    this.alert = null;
  }
}
