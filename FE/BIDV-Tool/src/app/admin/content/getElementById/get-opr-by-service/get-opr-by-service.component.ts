import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ResOprByService } from 'src/app/entity/ResOprByService';
import { ServiceService } from 'src/app/services/service/service.service';
import { Location } from '@angular/common';
import { Console } from 'console';

@Component({
  selector: 'app-get-opr-by-service',
  templateUrl: './get-opr-by-service.component.html',
  styleUrls: ['./get-opr-by-service.component.css']
})
export class GetOprByServiceComponent implements OnInit {
  oprByService: ResOprByService[];
  page = 1;
  pageSize = 5;
  keyword: string;

  constructor(private serviceService: ServiceService, private location: Location, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.getOperationByService();
  }
  getOperationByService() {
    this.route.queryParams.subscribe(data => {
     let applicationId = data['applicationId'];
     let serviceId = data['serviceId'];
     console.log(applicationId+serviceId);
      this.serviceService.getOperationByServiceId1(applicationId,serviceId).subscribe(data => {
        this.oprByService = data;
      })
      console.log(this.oprByService)
      
    })
  }
  returnPage() {
    // this.router.navigateByUrl("/admin/service-list")
    this.location.back();
  }
}
