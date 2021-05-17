import { DatePipe } from '@angular/common';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/entity/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userApi = "http://172.16.3.141:8080/user";
  constructor(private http: HttpClient, private datePipe: DatePipe) { }

  requestId = '' + Math.floor(Date.now() / 1000) || '';
  clientTime = this.datePipe.transform(new Date(), 'dd/MM/yyyy hh:mm:ss') || '';
  options = {
    headers: new HttpHeaders()
      .append('requestId', this.requestId)
      .append('clientTime', this.clientTime),
  };

  addUser(user: User) {
    return this.http.post(`${this.userApi}`, user, this.options);
  }
}
