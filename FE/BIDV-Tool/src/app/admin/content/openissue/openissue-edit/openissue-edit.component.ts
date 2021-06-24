import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Application } from 'src/app/entity/Application';
import { OpenIssue } from 'src/app/entity/OpenIssue';
import { Operation } from 'src/app/entity/Operation';
import { ResOprByService } from 'src/app/entity/ResOprByService';
import { ResServiceByApp } from 'src/app/entity/ResServiceByApp';
import { User } from 'src/app/entity/User';
import { ApplicationService } from 'src/app/services/application/application.service';
import { OpenissueService } from 'src/app/services/openissue/openissue.service';
import { OperationService } from 'src/app/services/operation/operation.service';
import { ServiceService } from 'src/app/services/service/service.service';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-openissue-edit',
  templateUrl: './openissue-edit.component.html',
  styleUrls: ['./openissue-edit.component.css']
})
export class OpenissueEditComponent implements OnInit {

  issue: OpenIssue = new OpenIssue();
  user: User[];
  opr: Operation[];
  app :Application[];
  openDate: string;
  dueDate: string;
  opreration: ResOprByService[];
  service: ResServiceByApp[];
  closeDate: string;
  form: FormGroup;
  applicationId :number;
  serviceId:number;
  submitted = false;
  constructor(private openissueService: OpenissueService,
    private userService: UserService,
    private serviceService : ServiceService,
    private applicationService: ApplicationService,
    private operationService: OperationService,
              private router : Router, 
              private route: ActivatedRoute,
              private datePipe: DatePipe,
              private formBuilder: FormBuilder) { }

  ngOnInit(): void {
   this.getOpenIssueById();
   this.getAllUser();
   this.getAllOperation();
   this.getAllApplication();
   this.form = this.formBuilder.group({
    desc: ['', Validators.required],
    reporter: ['', Validators.required],
    resolution: ['', Validators.required],
    operation: ['', Validators.required],
    owner: ['', [Validators.required, Validators.maxLength(5)]],
    status: ['', Validators.required],
    open: ['', Validators.required],
    due: ['', Validators.required],
    close: ['', Validators.required]
  })
  }
  onSubmit (){
    this.openissueService.editOpenIssue(this.issue).subscribe(data => {
      this.router.navigateByUrl("/admin/openissue-list")
    })
  }

  getOpenIssueById (){
    this.route.params.subscribe(data =>{
      this.openissueService.getOpenIssueByID(data.id).subscribe(data=>{
        this.issue = data;
      })
    })
  }
  getAllApplication(){
    this.applicationService.getListApp().subscribe(
      data=>{
        this.app =data.applications;
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
  onChangeOpenDate(event: any) {
    this.openDate = event.target.value;
  }
  onChangeDueDate(event: any) {
    this.dueDate = event.target.value;
  }
  onChangeCloseDate(event: any) {
    this.closeDate = event.target.value;
  }
  getAllUser() {
    this.userService.getListUser().subscribe(data => {
      this.user = data.users;
    })
  }
  getAllOperation() {
    this.operationService.getListOperation().subscribe(data => {
      this.opr = data.operations;
    })
  }

}
