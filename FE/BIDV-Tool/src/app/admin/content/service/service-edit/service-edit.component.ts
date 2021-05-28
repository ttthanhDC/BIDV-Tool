import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Service } from 'src/app/entity/Service';
import { ServiceService } from 'src/app/services/service/service.service';

@Component({
  selector: 'app-service-edit',
  templateUrl: './service-edit.component.html',
  styleUrls: ['./service-edit.component.css']
})
export class ServiceEditComponent implements OnInit {

  srv : Service = new Service();
  form: FormGroup;
  submitted = false;
  constructor(private serviceService : ServiceService, private router : Router, private route: ActivatedRoute, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      name: ['', Validators.required],
      status: ['', Validators.required]
    })
   this.getServiceById();
  }
  onSubmit (){
    this.serviceService.editService(this.srv).subscribe(data => {
      this.router.navigateByUrl("/admin/service-list")
    })
  }

  getServiceById (){
    this.route.params.subscribe(data =>{
      this.serviceService.getServiceByID(data.id).subscribe(data=>{
        this.srv = data;
      })
    })
  }
  get f() {
    return this.form.controls;
  }

}
