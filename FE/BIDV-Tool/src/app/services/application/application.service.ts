import { DatePipe } from '@angular/common';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Application } from 'src/app/entity/Application';
import { ResponseApp } from 'src/app/entity/ResponseApp';

@Injectable({
  providedIn: 'root'
})
export class ApplicationService {

   private appAdd = "http://192.168.1.136:4200/BIDVTool-Service/application";
//  private appAdd = "http://172.16.3.141:8080/application";
  constructor(private http: HttpClient, private datePipe: DatePipe) { }

  requestId = '' + Math.floor(Date.now() / 1000) || '';
  clientTime = this.datePipe.transform(new Date(), 'dd/MM/yyyy hh:mm:ss') || '';
  options = {
    headers: new HttpHeaders()
      .append('requestId', this.requestId)
      .append('clientTime', this.clientTime),
  };

  getListApp(): Observable<ResponseApp> {
    return this.http.get<ResponseApp>(`${this.appAdd}`, this.options);
  }

  getAppByID(id: any): Observable<Application> {
    return this.http.get<Application>(`${this.appAdd}/${id}`, this.options);
  }

  addApplication(app: Application): Observable<Application> {
    return this.http.post<Application>(`${this.appAdd}`, app, this.options);
  }

  editApplication(app: Application): Observable<Application> {
    return this.http.put<Application>(`${this.appAdd}/${app.id}`, app, this.options);
  }

  deleteApplication( id : any) : Observable<Application> {
    return this.http.delete<Application>(`${this.appAdd}/${id}`, this.options)
  }

}
