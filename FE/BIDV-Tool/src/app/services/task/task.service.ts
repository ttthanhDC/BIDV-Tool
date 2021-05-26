import { DatePipe } from '@angular/common';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ResponseTask } from 'src/app/entity/ResponseTask';
import { Task } from 'src/app/entity/Task';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private taskUrl = "http://172.16.3.141:8080/task";
  constructor(private http: HttpClient, private datePipe: DatePipe) { }

  requestId = '' + Math.floor(Date.now() / 1000) || '';
  clientTime = this.datePipe.transform(new Date(), 'dd/MM/yyyy hh:mm:ss') || '';
  options = {
    headers: new HttpHeaders()
      .append('requestId', this.requestId)
      .append('clientTime', this.clientTime),
  };

  getListTask(): Observable<ResponseTask> {
    return this.http.get<ResponseTask>(`${this.taskUrl}`, this.options);
  }

  getTaskByID(id: any): Observable<Task> {
    return this.http.get<Task>(`${this.taskUrl}/${id}`, this.options);
  }

  addTask(task: Task): Observable<Task> {
    return this.http.post<Task>(`${this.taskUrl}`, task, this.options);
  }

  editTask(task: Task): Observable<Task> {
    return this.http.put<Task>(`${this.taskUrl}/${task.id}`, task, this.options);
  }

  deleteTask( id : any) : Observable<Task> {
    return this.http.delete<Task>(`${this.taskUrl}/${id}`, this.options)
  }
}
