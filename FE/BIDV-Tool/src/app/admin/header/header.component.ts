import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private location: Location) { }

  ngOnInit(): void {
  }
  returnPage() {
    // this.router.navigateByUrl("/admin/service-list")
    this.location.back();
  }

}
