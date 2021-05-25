import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppByService } from 'src/app/entity/AppByService';
import { DashboardResponse } from 'src/app/entity/DashBoardResponse';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  private issueUrl = "http://172.16.3.141:8080/dashboard/app";
  private appByService = "http://172.16.3.141:8080/dashboard/app?query=service";
  private oprByStatus = "http://172.16.3.141:8080/dashboard/operation?query=status";
  private serviceByApp = "http://172.16.3.141:8080//dashboard/service?query=app";
  private serviceByStatus = "http://172.16.3.141:8080/dashboard/service?query=status";

  constructor(private http: HttpClient) { }

  getTotalApp(): Observable<DashboardResponse[]> {
    return this.http.get<DashboardResponse[]>(`${this.issueUrl}`);
  }

  getAppByService(): Observable<AppByService[]>{
    return this.http.get<AppByService[]>(`${this.appByService}`);
  }
  getOperationByStatus(): Observable<DashboardResponse[]> {
    return this.http.get<DashboardResponse[]>(`${this.oprByStatus}`);
  }
  getServiceByApp(): Observable<DashboardResponse[]> {
    return this.http.get<DashboardResponse[]>(`${this.serviceByApp}`);
  }
  getServiceByStatus(): Observable<DashboardResponse[]> {
    return this.http.get<DashboardResponse[]>(`${this.serviceByStatus}`);
  }
}
