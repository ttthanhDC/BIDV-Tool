import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Operation } from 'src/app/entity/Operation';
import { Service } from 'src/app/entity/Service';
import { OperationService } from 'src/app/services/operation/operation.service';
import { ServiceService } from 'src/app/services/service/service.service';

@Component({
  selector: 'app-operation-add',
  templateUrl: './operation-add.component.html',
  styleUrls: ['./operation-add.component.css']
})
export class OperationAddComponent implements OnInit {

  opr : Operation = new Operation();
  service : Service[];
  form = new FormGroup({
    name: new FormControl('',Validators.required),
  });
  constructor(private operationService : OperationService, 
              private serviceService : ServiceService,
              private router : Router) { }

  ngOnInit(): void {
    this.getAllService();
  }
  
  onSubmit(){
    this.operationService.addOperation(this.opr)
    .subscribe(
      data=> {
        this.router.navigateByUrl("/admin/operation-list");
    })
  }
  get f(){
    return this.form.controls;
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
