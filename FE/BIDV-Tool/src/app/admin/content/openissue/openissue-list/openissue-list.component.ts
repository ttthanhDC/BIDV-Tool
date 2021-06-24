import { Component, NgModule, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Console } from 'console';
import { Application } from 'src/app/entity/Application';
import { OpenIssue } from 'src/app/entity/OpenIssue';
import { ResOprByService } from 'src/app/entity/ResOprByService';
import { ResServiceByApp } from 'src/app/entity/ResServiceByApp';
import { ApplicationService } from 'src/app/services/application/application.service';
import { OpenissueService } from 'src/app/services/openissue/openissue.service';
import { ServiceService } from 'src/app/services/service/service.service';

@Component({
  selector: 'app-openissue-list',
  templateUrl: './openissue-list.component.html',
  styleUrls: ['./openissue-list.component.css']
})
export class OpenissueListComponent implements OnInit {

  issue: OpenIssue = new OpenIssue();
  issues:OpenIssue[];
  issueId: number;
  app :Application[];
  opreration: ResOprByService[];
  service: ResServiceByApp[];
  isShowModal: boolean = true;
  page = 1;
  pageSize = 5;
  keyword: string;
  display: string;
  applicationId: number;
  serviceId:number;
  constructor(
    private openissueService: OpenissueService,
    private applicationService: ApplicationService,
    private serviceService : ServiceService,
     private router: Router
    ) { }
  
  ngOnInit(): void {
    this.getAllApplication();
    this.getAllOpenIssue();
    
  }

  getAllOpenIssue() {
    this.openissueService.getListOpenIssue()
      .subscribe(
        data => {          
          this.issues = data.issues;
        })
  }
  getAllApplication(){
    this.applicationService.getListApp().subscribe(
      data=>{
        this.app =data.applications;
        //this.getServiceByApplication(this.app[0].id);
      }
    )
  }
  getServiceByApplication(appId:number){
    this.serviceService.getServiceByAppId(appId).subscribe(
      data =>{
        this.service = data;
        if(this.service.length == 0){
          this.opreration = [];
        }
        //console.log(this.service);
      }
    )
  }

  getServiceByEventApplication(event: any){
    //const appId = event.target.value;
    this.applicationId = event.target.value;
    console.log("appId " + this.applicationId);
    this.getServiceByApplication(this.applicationId);
  }
   getOperationByAppIdAndServiceId(serviceId:any){
     console.log("1")
    console.log("applicationId"+this.applicationId);
    this.serviceService.getOperationByServiceId1(this.applicationId,serviceId).subscribe(
      data=>{
        this.opreration = data;
        console.log(this.opreration)
      }
    )
      }
       getOperationByAppIdAndServiceIdEvent(event: any){
        const serviceId = event.target.value;
        const appID = this.applicationId;
        console.log("getOperationByAppIdAndServiceId  - appId "+ appID);
        console.log("getOperationByAppIdAndServiceId - serviceId "+ serviceId);
        if(serviceId&&this.applicationId&&serviceId>0&&this.applicationId>0){
          this.getOperationByAppIdAndServiceId(serviceId);
        }
        else{
          this.opreration=[];
        }
      }
  delete(id: number) {
    this.issueId = id;
    
  }
  checkDelete() { 
    this.openissueService.deleteOpenIssue(this.issueId)
      .subscribe(
        data => {
          this.getAllOpenIssue();
        },
        error => {
          if (error.status == 500) {
            this.openModal();
          }
        }
        )
  }
  openModal() {
    this.display = "block";
  }
  onCloseHandled() {
    this.display = "none";
  }
}
