import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ResOprByService } from 'src/app/entity/ResOprByService';
import { ServiceService } from 'src/app/services/service/service.service';

@Component({
  selector: 'app-get-opr-by-service',
  templateUrl: './get-opr-by-service.component.html',
  styleUrls: ['./get-opr-by-service.component.css']
})
export class GetOprByServiceComponent implements OnInit {
  oprByService: ResOprByService[];
  page = 1;
  pageSize = 5;
  

  constructor( private serviceService: ServiceService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.getOperationByService();
  }
  getOperationByService(){
    this.route.params.subscribe(data =>{
      this.serviceService.getOperationByServiceId(data.id).subscribe(data=>{
        this.oprByService = data;
      })
    })
  }
  returnPage(){
    this.router.navigateByUrl("/admin/service-list")
  }
}
