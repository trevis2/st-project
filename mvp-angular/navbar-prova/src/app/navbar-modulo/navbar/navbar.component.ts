import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.less']
})
export class NavbarComponent implements OnInit {
  ngOnInit(): void {
    for (var i = 0; i < 5; i++) {
      console.log("i: " + i);
      setTimeout(function () {
        console.log("i-timeout: " + i);
      }, 1000);
    }
  }

}
