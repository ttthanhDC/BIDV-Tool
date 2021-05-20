import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { OpenIssue } from 'src/app/entity/OpenIssue';
import { Operation } from 'src/app/entity/Operation';
import { User } from 'src/app/entity/User';
import { OpenissueService } from 'src/app/services/openissue/openissue.service';
import { OperationService } from 'src/app/services/operation/operation.service';
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
  openDate: string;
  dueDate: string;
  closeDate: string;
  constructor(private openissueService: OpenissueService,
    private userService: UserService,
    private operationService: OperationService,
              private router : Router, 
              private route: ActivatedRoute,
              private datePipe: DatePipe) { }

  ngOnInit(): void {
   this.getOpenIssueById();
   this.getAllUser();
   this.getAllOperation();
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
