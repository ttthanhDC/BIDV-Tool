import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Service } from 'src/app/entity/Service';
import { ServiceService } from 'src/app/services/service/service.service';

@Component({
  selector: 'app-service-add',
  templateUrl: './service-add.component.html',
  styleUrls: ['./service-add.component.css']
})
export class ServiceAddComponent implements OnInit {

  srv : Service = new Service();
  form = new FormGroup({
    name: new FormControl('',Validators.required),
  });
  constructor(private serviceService : ServiceService, private router : Router) { }

  ngOnInit(): void {
  }
  
  onSubmit(){
    this.serviceService.addService(this.srv)
    .subscribe(
      data=> {
        this.router.navigateByUrl("/admin/service-list");
    })
  }
  get f(){
    return this.form.controls;
  }

}
