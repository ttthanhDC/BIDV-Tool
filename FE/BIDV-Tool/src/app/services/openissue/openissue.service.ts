import { DatePipe } from '@angular/common';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OpenIssue } from 'src/app/entity/OpenIssue';
import { ResponseOpenIssue } from 'src/app/entity/ResponseOppenIssue';

@Injectable({
  providedIn: 'root'
})
export class OpenissueService {

 private issueUrl = "http://192.168.1.136:4200/BIDVTool-Service/issue";
 //  private issueUrl = "http://172.16.3.141:8080/issue";
  constructor(private http: HttpClient, private datePipe: DatePipe) { }

  requestId = '' + Math.floor(Date.now() / 1000) || '';
  clientTime = this.datePipe.transform(new Date(), 'dd/MM/yyyy hh:mm:ss') || '';
  options = {
    headers: new HttpHeaders()
      .append('requestId', this.requestId)
      .append('clientTime', this.clientTime),
  };

  getListOpenIssue(): Observable<ResponseOpenIssue> {
    return this.http.get<ResponseOpenIssue>(`${this.issueUrl}`, this.options);
  }

  getOpenIssueByID(id: any): Observable<OpenIssue> {
    return this.http.get<OpenIssue>(`${this.issueUrl}/${id}`, this.options);
  }

  addOpenIssue(opr: OpenIssue): Observable<OpenIssue> {
    return this.http.post<OpenIssue>(`${this.issueUrl}`, opr, this.options);
  }

  editOpenIssue(app: OpenIssue): Observable<OpenIssue> {
    return this.http.put<OpenIssue>(`${this.issueUrl}/${app.id}`, app, this.options);
  }

  deleteOpenIssue( id : any) : Observable<OpenIssue> {
    return this.http.delete<OpenIssue>(`${this.issueUrl}/${id}`, this.options)
  }
}
