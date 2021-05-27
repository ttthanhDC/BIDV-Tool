import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Service } from 'src/app/entity/Service';
import { ServiceService } from 'src/app/services/service/service.service';

@Component({
  selector: 'app-service-list',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.css']
})
export class ServiceListComponent implements OnInit {

  srv: Service[];
  srvId: number;
  serviceId: number;
  isShowModal: boolean = true;
  page = 1;
  pageSize = 5;
  keyword: string;
  display: string;
  constructor(private serviceService: ServiceService, private router: Router) { }

  ngOnInit(): void {
    this.getAllService();
  }

  getAllService() {
    this.serviceService.getListService()
      .subscribe(
        data => {
          this.srv = data.services;
        })
  }
  delete(id: number) {
    this.srvId = id;
  }
  checkDelete() {
    this.serviceService.deleteService(this.srvId)
      .subscribe(
        data => {
          this.getAllService();
        },
        error => {
          if (error.status == 500) {
            this.openModal();
          }
        }
      )
  }
  getServiceId(id: number) {
    this.serviceId = id;
  }
  openModal() {
    this.display = "block";
  }
  onCloseHandled() {
    this.display = "none";
  }

}
