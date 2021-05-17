import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UploadfileService } from 'src/app/services/uploadfile/uploadfile.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  file : File;
  formf = new FormGroup({
    file: new FormControl('', [Validators.required])
  });
  // response : ExcelResponse = new ExcelResponse();
  constructor(private uploadFileService : UploadfileService) {
   }
  
  ngOnInit(): void {
  }
  get f() { return this.formf.controls; }
  submitForm(){
    // this.uploadFileService.uploadFileExcel(this.file).subscribe(data =>{
    //   this.response = data;
    //   console.log('success 11');
      
    // })
  }
  changeFile(event : any){
    this.file = event.target.files[0];
  }
}
