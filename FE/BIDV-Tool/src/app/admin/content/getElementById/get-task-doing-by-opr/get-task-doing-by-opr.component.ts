import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TaskDoing } from 'src/app/entity/TaskDoing';
import { OperationService } from 'src/app/services/operation/operation.service';

@Component({
  selector: 'app-get-task-doing-by-opr',
  templateUrl: './get-task-doing-by-opr.component.html',
  styleUrls: ['./get-task-doing-by-opr.component.css']
})
export class GetTaskDoingByOprComponent implements OnInit {

  constructor(private operationService: OperationService, private router: Router, private route: ActivatedRoute) { }
  keyword: string;
  task: TaskDoing[];
  ngOnInit(): void {
    this.getTask();
  }
  getTask(){
    this.route.params.subscribe(data =>{
      this.operationService.getTaskByOprId(data.id).subscribe(data=>{
        this.task = data;
      })
    })
  }
}
