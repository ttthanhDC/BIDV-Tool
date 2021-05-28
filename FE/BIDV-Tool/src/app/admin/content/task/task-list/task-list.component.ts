import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Task } from 'src/app/entity/Task';
import { TaskService } from 'src/app/services/task/task.service';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {

  task: Task[];
  taskId: number;
  isShowModal: boolean = true;
  page = 1;
  pageSize = 5;
  keyword: string;
  display: string;
  constructor(private taskService: TaskService, private router: Router) { }

  ngOnInit(): void {
    this.getAllTask();
  }

  getAllTask() {
    this.taskService.getListTask()
      .subscribe(
        data => {
          this.task = data.listTask;
        })
  }
  delete(id: number) {
    this.taskId = id;

  }
  checkDelete() {
    this.taskService.deleteTask(this.taskId)
      .subscribe(
        data => {
          this.getAllTask();
        },
        error => {
          if (error.status == 500) {
            this.openModal();
          }
        })
  }
  openModal() {
    this.display = "block";
  }
  onCloseHandled() {
    this.display = "none";
  }

}
