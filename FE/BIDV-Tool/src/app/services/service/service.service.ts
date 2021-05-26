import { DatePipe } from '@angular/common';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ResOprByService } from 'src/app/entity/ResOprByService';
import { ResponseService } from 'src/app/entity/ResponseService';
import { ResServiceByApp } from 'src/app/entity/ResServiceByApp';
import { Service } from 'src/app/entity/Service';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  private srvUrl = "http://172.16.3.141:8080/service";
  private oprUrl = "http://localhost:8080/dashboard/operation?service=";
  private appUrl = "http://localhost:8080/dashboard/service?app=";
  constructor(private http: HttpClient, private datePipe: DatePipe) { }

  requestId = '' + Math.floor(Date.now() / 1000) || '';
  clientTime = this.datePipe.transform(new Date(), 'dd/MM/yyyy hh:mm:ss') || '';
  options = {
    headers: new HttpHeaders()
      .append('requestId', this.requestId)
      .append('clientTime', this.clientTime),
  };

  getListService(): Observable<ResponseService> {
    return this.http.get<ResponseService>(`${this.srvUrl}`, this.options);
  }

  getServiceByID(id: any): Observable<Service> {
    return this.http.get<Service>(`${this.srvUrl}/${id}`, this.options);
  }

  addService(srv: Service): Observable<Service> {
    return this.http.post<Service>(`${this.srvUrl}`, srv, this.options);
  }

  editService(app: Service): Observable<Service> {
    return this.http.put<Service>(`${this.srvUrl}/${app.id}`, app, this.options);
  }

  deleteService( id : any) : Observable<Service> {
    return this.http.delete<Service>(`${this.srvUrl}/${id}`, this.options)
  }
  getOperationByServiceId(id : any): Observable<ResOprByService[]>{
    return this.http.get<ResOprByService[]>(`${this.oprUrl}${id}`);
  }
  getServiceByAppId(id : any): Observable<ResServiceByApp[]>{
    return this.http.get<ResServiceByApp[]>(`${this.appUrl}${id}`);
  }
}
