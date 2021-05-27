import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
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

  opr: Operation = new Operation();
  service: Service[];
  form: FormGroup;
  submitted = false;
  constructor(private operationService: OperationService,
    private serviceService: ServiceService,
    private router: Router,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.getOperationById();
    this.getAllService();
    this.form = this.formBuilder.group({
      serviceName: ['', Validators.required],
      applicationId: ['', Validators.required],
      operationName: ['', Validators.required],
      status: ['', Validators.required],
      ssdSOA: ['', Validators.required],
      ssdLegacy: ['', Validators.required]
    })
  }
  onSubmit() {
    this.operationService.editOperation(this.opr).subscribe(data => {
      this.router.navigateByUrl("/admin/operation-list")
    })
  }

  getOperationById() {
    this.route.params.subscribe(data => {
      this.operationService.getOperationByID(data.id).subscribe(data => {
        this.opr = data;
      })
    })
  }

  changeEvent(event: any) {
    this.opr.interactWithCore = event.currentTarget.checked;
  }
  checkWs(event: any) {
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
