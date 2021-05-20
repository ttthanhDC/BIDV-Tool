import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Operation } from 'src/app/entity/Operation';
import { Service } from 'src/app/entity/Service';
import { OperationService } from 'src/app/services/operation/operation.service';
import { ServiceService } from 'src/app/services/service/service.service';

@Component({
  selector: 'app-operation-edit',
  templateUrl: './operation-edit.component.html',
  styleUrls: ['./operation-edit.component.css']
})
export class OperationEditComponent implements OnInit {

  opr : Operation = new Operation();
  service : Service[];
  constructor(private operationService : OperationService, 
              private serviceService : ServiceService,
              private router : Router, 
              private route: ActivatedRoute) { }

  ngOnInit(): void {
   this.getOperationById();
   this.getAllService();
  }
  onSubmit (){
    this.operationService.editOperation(this.opr).subscribe(data => {
      this.router.navigateByUrl("/admin/operation-list")
    })
  }

  getOperationById (){
    this.route.params.subscribe(data =>{
      this.operationService.getOperationByID(data.id).subscribe(data=>{
        this.opr = data;
      })
    })
  }
  
  changeEvent(event : any){   
    this.opr.interactWithCore = event.currentTarget.checked;
  }
  checkWs(event : any){   
    this.opr.workshop = event.currentTarget.checked;
  }
  getAllService() {
    this.serviceService.getListService()
      .subscribe(
        data => {       
          this.service = data.services;
        })
  }

}
