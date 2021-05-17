import { Component, OnInit } from '@angular/core';
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
  constructor(private applicationService : ApplicationService, private router : Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
   this.getAppById();
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
