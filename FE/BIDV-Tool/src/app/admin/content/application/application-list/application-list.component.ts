import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { $ } from 'protractor';
import { Application } from 'src/app/entity/Application';
import { ResponseApp } from 'src/app/entity/ResponseApp';
import { ApplicationService } from 'src/app/services/application/application.service';

@Component({
  selector: 'app-application-list',
  templateUrl: './application-list.component.html',
  styleUrls: ['./application-list.component.css']
})
export class ApplicationListComponent implements OnInit {
  app: Application[];
  appId: number;
  isShowModal: boolean = true;
  page = 1;
  pageSize = 5;

  constructor(private applicationService: ApplicationService, private router: Router) { }

  ngOnInit(): void {
    this.getAllApp();
  }

  getAllApp() {
    this.applicationService.getListApp()
      .subscribe(
        data => {
          this.app = data.applications;
        })
  }
  delete(id: number) {
    this.appId = id;
    console.log(this.appId);


  }
  checkDelete() {
    this.applicationService.deleteApplication(this.appId)
      .subscribe(
        data => {
          this.getAllApp();
        })
  }

  close() {
    this.isShowModal = false;
  }

  test() {

  }
}
