import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ResServiceByApp } from 'src/app/entity/ResServiceByApp';
import { ServiceService } from 'src/app/services/service/service.service';

@Component({
  selector: 'app-get-service-by-app',
  templateUrl: './get-service-by-app.component.html',
  styleUrls: ['./get-service-by-app.component.css']
})
export class GetServiceByAppComponent implements OnInit {
  srvByApp: ResServiceByApp[];
  page = 1;
  pageSize = 5;
  keyword: string;

  constructor( private serviceService: ServiceService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.getOperationByService();
  }
  getOperationByService(){
    this.route.params.subscribe(data =>{
      this.serviceService.getServiceByAppId(data.id).subscribe(data=>{
        this.srvByApp = data;
      })
    })
  }
  returnPage(){
    this.router.navigateByUrl("/admin/application-list")
  }

}
