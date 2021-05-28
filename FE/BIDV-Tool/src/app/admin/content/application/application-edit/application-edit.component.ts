import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Application } from 'src/app/entity/Application';
import { ApplicationService } from 'src/app/services/application/application.service';

@Component({
  selector: 'app-application-edit',
  templateUrl: './application-edit.component.html',
  styleUrls: ['./application-edit.component.css']
})
export class ApplicationEditComponent implements OnInit {
  app : Application = new Application();
  form: FormGroup;
  submitted = false;
  constructor(private applicationService : ApplicationService, private router : Router, private route: ActivatedRoute, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
   this.getAppById();
   this.form = this.formBuilder.group({
    txtAppCode: ['', Validators.required],
    txtBidvAppCode: ['', Validators.required],
    txtAppName: ['', Validators.required],
    txtAppAbb: ['', Validators.required]
  })
  }
  onSubmit (){
    this.applicationService.editApplication(this.app).subscribe(data => {
      this.router.navigateByUrl("/admin/application-list")
      console.log("success");
    })
  }

  getAppById (){
    this.route.params.subscribe(data =>{
      this.applicationService.getAppByID(data.id).subscribe(data=>{
        this.app = data;
      })
    })
  }
  
  changeEvent(event : any){   
    this.app.inScope = event.currentTarget.checked;
  }
}
