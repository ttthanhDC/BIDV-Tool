import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Service } from 'src/app/entity/Service';
import { ServiceService } from 'src/app/services/service/service.service';

@Component({
  selector: 'app-service-add',
  templateUrl: './service-add.component.html',
  styleUrls: ['./service-add.component.css']
})
export class ServiceAddComponent implements OnInit {

  srv: Service = new Service();
  form: FormGroup;
  submitted = false;

  constructor(private serviceService: ServiceService, private router: Router, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      name: ['', Validators.required],
      status: ['', Validators.required]
    })
  }

  onSubmit() {
    this.submitted = true;
    this.serviceService.addService(this.srv)
      .subscribe(
        data => {
          this.router.navigateByUrl("/admin/service-list");
        })
  }
  get f() {
    return this.form.controls;
  }

}
