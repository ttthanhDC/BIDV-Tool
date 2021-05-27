import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Operation } from 'src/app/entity/Operation';
import { Task } from 'src/app/entity/Task';
import { User } from 'src/app/entity/User';
import { OperationService } from 'src/app/services/operation/operation.service';
import { TaskService } from 'src/app/services/task/task.service';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-task-edit',
  templateUrl: './task-edit.component.html',
  styleUrls: ['./task-edit.component.css']
})
export class TaskEditComponent implements OnInit {


  task: Task = new Task();
  user: User[];
  opr: Operation[];
  openDate: string;
  dueDate: string;
  closeDate: string;
  form: FormGroup;
  submitted = false;
  constructor(private taskService: TaskService,
    private userService: UserService,
    private operationService: OperationService,
    private router: Router,
    private route: ActivatedRoute,
    private datePipe: DatePipe,
    private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.getTaskById();
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
    this.taskService.editTask(this.task).subscribe(data => {
      this.router.navigateByUrl("/admin/task-list")
    })
  }

  getTaskById() {
    this.route.params.subscribe(data => {
      this.taskService.getTaskByID(data.id).subscribe(data => {
        this.task = data;
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
