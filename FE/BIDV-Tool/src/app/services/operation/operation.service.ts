import { DatePipe } from '@angular/common';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Operation } from 'src/app/entity/Operation';
import { ResponseOperation } from 'src/app/entity/ResponseOperation';

@Injectable({
  providedIn: 'root'
})
export class OperationService {

  private oprUrl = "http://172.16.3.141:8080/operation";
  constructor(private http: HttpClient, private datePipe: DatePipe) { }

  requestId = '' + Math.floor(Date.now() / 1000) || '';
  clientTime = this.datePipe.transform(new Date(), 'dd/MM/yyyy hh:mm:ss') || '';
  options = {
    headers: new HttpHeaders()
      .append('requestId', this.requestId)
      .append('clientTime', this.clientTime),
  };

  getListOperation(): Observable<ResponseOperation> {
    return this.http.get<ResponseOperation>(`${this.oprUrl}`, this.options);
  }

  getOperationByID(id: any): Observable<Operation> {
    return this.http.get<Operation>(`${this.oprUrl}/${id}`, this.options);
  }

  addOperation(opr: Operation): Observable<Operation> {
    return this.http.post<Operation>(`${this.oprUrl}`, opr, this.options);
  }

  editOperation(app: Operation): Observable<Operation> {
    return this.http.put<Operation>(`${this.oprUrl}/${app.id}`, app, this.options);
  }

  deleteOperation( id : any) : Observable<Operation> {
    return this.http.delete<Operation>(`${this.oprUrl}/${id}`, this.options)
  }
}
