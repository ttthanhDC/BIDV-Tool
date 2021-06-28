import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Console, log } from 'console';
import { Application } from 'src/app/entity/Application';
import { OpenIssue } from 'src/app/entity/OpenIssue';
import { Operation } from 'src/app/entity/Operation';
import { ResOprByService } from 'src/app/entity/ResOprByService';
import { ResServiceByApp } from 'src/app/entity/ResServiceByApp';
import { Service } from 'src/app/entity/Service';
import { User } from 'src/app/entity/User';
import { ApplicationService } from 'src/app/services/application/application.service';
import { OpenissueService } from 'src/app/services/openissue/openissue.service';
import { OperationService } from 'src/app/services/operation/operation.service';
import { ServiceService } from 'src/app/services/service/service.service';
import { UserService } from 'src/app/services/user/user.service';
import { dropdownList } from 'src/app/entity/dropdownList';
import { selectedItems } from 'src/app/entity/selectedItem';
import { DashboardService } from 'src/app/services/dashboard/dashboard.service';

@Component({
  selector: 'app-openissue-add',
  templateUrl: './openissue-add.component.html',
  styleUrls: ['./openissue-add.component.css']
})
export class OpenissueAddComponent implements OnInit {

  issue: OpenIssue = new OpenIssue();
  issues:OpenIssue[];
  user: User[];
  app :Application[];
  opreration: ResOprByService[];
  service: ResServiceByApp[];
  applicationId :number;
  serviceId:number;
 // opreration:Operation[];
  openDate: Date;
  dueDate: Date;
  closeDate: Date;
  form: FormGroup;
  submitted = false;
  constructor(
    private openissueService: OpenissueService,
    private userService: UserService,
    private serviceService : ServiceService,
    private applicationService: ApplicationService,
    private router: Router,
    private formBuilder: FormBuilder) { }
    ngOnInit(): void {
    this.getAllUser();
    this.getAllApplication();
  
    this.form = this.formBuilder.group({
      desc: ['', Validators.required],
      reporter: ['', Validators.required],
      resolution: ['', Validators.required],
      operation: ['', Validators.required],
      owner: ['', [Validators.required]],
      support: ['', [Validators.required]],
      status: ['', Validators.required],
      open: ['', Validators.required],
      due: ['', Validators.required],
      close: ['', Validators.required],
      
    })

  }

  onSubmit() {
    console.log(this.issue)
    this.openissueService.addOpenIssue(this.issue)
      .subscribe(
        data => {
          this.router.navigateByUrl("/admin/openissue-list");
        })
  }
  get f() {
    return this.form.controls;
  }
  onChangeOpenDate(event: any) {
    this.openDate = event.target.value;
  }
  onChangeDueDate(event: any) {
    this.dueDate = event.target.value;
  }
  onChangeCloseDate(event: any) {
    this.closeDate = event.target.value;
  }
  // createIssue(iss:OpenIssue){
  //   this.openissueService.addOpenIssue(iss);
  // }
  getAllUser() {
    this.userService.getListUser().subscribe(data => {
      this.user = data.users;
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
  
  getServiceByApplication(appId:any){
    this.serviceService.getServiceByAppId(appId).subscribe(
      data =>{
        this.service = data;
        if(this.service.length == 0){
          this.opreration = [];
        }
      }
    )
  }

  getServiceByEventApplication(event: any){
    this.applicationId = event.target.value;
    console.log("appId " +  this.applicationId);
  
    this.getServiceByApplication( this.applicationId);
  }
  getOperationByAppIdAndServiceId(serviceId:any){
this.serviceService.getOperationByServiceId1(this.applicationId,serviceId).subscribe(
  data=>{
    this.opreration = data;
    console.log(this.opreration)
  }
)
  }
  getOperationByAppIdAndServiceIdEvent(event: any){
    const serviceId = event.target.value;
    const appId = this.applicationId;
    console.log("getOperationByAppIdAndServiceId  - appId "+ appId);
    console.log("getOperationByAppIdAndServiceId - serviceId "+ serviceId);
    if(serviceId&&appId&&serviceId>0&&appId>0){
      this.getOperationByAppIdAndServiceId(serviceId);
    }
    else{
      this.opreration=[];
    }
  }
    
 

}
