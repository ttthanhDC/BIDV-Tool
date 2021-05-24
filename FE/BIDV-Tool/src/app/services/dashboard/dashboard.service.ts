import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DashboardResponse } from 'src/app/entity/DashBoardResponse';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  private issueUrl = "http://172.16.3.141:8080/dashboard/app";
  constructor(private http: HttpClient) { }

  getTotalApp(): Observable<DashboardResponse[]> {
    return this.http.get<DashboardResponse[]>(`${this.issueUrl}`);
  }

}
