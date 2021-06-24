import { DatePipe } from '@angular/common';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { stringify } from '@angular/compiler/src/util';
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

  private srvUrl = "http://192.168.1.136:4200/BIDVTool-Service/service";
  private oprUrl = "http://192.168.1.136:4200/BIDVTool-Service/dashboard/operation?service=";
  private oprUrl1 = "http://192.168.1.136:4200/BIDVTool-Service/dashboard/operation";
  private appUrl = "http://192.168.1.136:4200/BIDVTool-Service/dashboard/service?app=";
  

  // private srvUrl = "http://172.16.3.141:8080/service";
  // private oprUrl = "http://172.16.3.141:8080/dashboard/operation?service=";
  // private appUrl = "http://172.16.3.141:8080/dashboard/service?app=";
  constructor(private http: HttpClient, private datePipe: DatePipe) { }

  requestId = '' + Math.floor(Date.now() / 1000) || '';
  clientTime = this.datePipe.transform(new Date(), 'dd/MM/yyyy hh:mm:ss') || '';
  options = {
    headers: new HttpHeaders()
      .append('requestId', this.requestId)
      .append('clientTime', this.clientTime),
  };
 
   httpOptions = {
    headers: { 'Content-Type': 'multipart/form-data' }, 
     formData : new FormData()
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
  getOperationByServiceId1(applicationId: any,serviceId:any): Observable<ResOprByService[]> {
    console.log("nhay")
    let params = new HttpParams();
    params = params.append('appId', applicationId);
    params = params.append('serviceId', serviceId);
  
    return this.http.get<ResOprByService[]>(`${this.oprUrl1}`,{params:params})
  }
  getServiceByAppId(id : any): Observable<ResServiceByApp[]>{
    return this.http.get<ResServiceByApp[]>(`${this.appUrl}${id}`);
  }
}
