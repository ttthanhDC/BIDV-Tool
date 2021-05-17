import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Application } from 'src/app/entity/Application';
import { ApplicationService } from 'src/app/services/application/application.service';

@Component({
  selector: 'app-application-add',
  templateUrl: './application-add.component.html',
  styleUrls: ['./application-add.component.css']
})
export class ApplicationAddComponent implements OnInit {
  app : Application = new Application();
  form = new FormGroup({
    name: new FormControl('',Validators.required),
  });
  constructor(private applicationService : ApplicationService, private router : Router) { }

  ngOnInit(): void {
  }
  
  onSubmit(){
    this.applicationService.addApplication(this.app)
    .subscribe(
      data=> {
        this.router.navigateByUrl("/admin/application-list");
    })
  }
  get f(){
    return this.form.controls;
  }
  changeEvent(event : any){   
    this.app.inScope = event.currentTarget.checked;
  }
}
