import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Operation } from 'src/app/entity/Operation';
import { Task } from 'src/app/entity/Task';
import { User } from 'src/app/entity/User';
import { OperationService } from 'src/app/services/operation/operation.service';
import { TaskService } from 'src/app/services/task/task.service';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-task-add',
  templateUrl: './task-add.component.html',
  styleUrls: ['./task-add.component.css']
})
export class TaskAddComponent implements OnInit {

  task: Task = new Task();
  user: User[];
  opr: Operation[];
  openDate: Date;
  dueDate: Date;
  closeDate: Date;
  form: FormGroup;
  submitted = false;
  constructor(private taslService: TaskService,
    private userService: UserService,
    private operationService: OperationService,
    private router: Router,
    private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.getAllUser();
    this.getAllOperation();
    this.form = this.formBuilder.group({
      desc: ['', Validators.required],
      assign: ['', Validators.required],
      operation: ['', Validators.required],
      status: ['', Validators.required],
      mapping: ['', Validators.required],
      open: ['', Validators.required],
      due: ['', Validators.required],
      close: ['', Validators.required]
    })
  }

  onSubmit() {
    this.taslService.addTask(this.task)
      .subscribe(
        data => {
          this.router.navigateByUrl("/admin/task-list");
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
