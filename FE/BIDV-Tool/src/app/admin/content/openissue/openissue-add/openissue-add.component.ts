import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { OpenIssue } from 'src/app/entity/OpenIssue';
import { Operation } from 'src/app/entity/Operation';
import { User } from 'src/app/entity/User';
import { OpenissueService } from 'src/app/services/openissue/openissue.service';
import { OperationService } from 'src/app/services/operation/operation.service';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-openissue-add',
  templateUrl: './openissue-add.component.html',
  styleUrls: ['./openissue-add.component.css']
})
export class OpenissueAddComponent implements OnInit {

  issue: OpenIssue = new OpenIssue();
  user: User[];
  opr: Operation[];
  openDate: Date;
  dueDate: Date;
  closeDate: Date;
  form: FormGroup;
  submitted = false;
  constructor(private openissueService: OpenissueService,
    private userService: UserService,
    private operationService: OperationService,
    private router: Router,
    private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.getAllUser();
    this.getAllOperation();
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

  onSubmit() {
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
