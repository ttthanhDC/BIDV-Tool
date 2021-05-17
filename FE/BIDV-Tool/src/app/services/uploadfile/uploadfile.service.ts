import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UploadfileService {
  private excelUrl = "http://172.16.3.141:8080/upload";
  constructor(private http : HttpClient) { }
  // uploadFileExcel(file : File) : Observable<ExcelResponse>{
  //   const formData: FormData = new FormData();
  //   formData.append('file', file);
  //   formData.append('function', 'em dien day ne!');
  //   return this.http.post<ExcelResponse>(`${this.excelUrl}`, formData)
  // }
}
