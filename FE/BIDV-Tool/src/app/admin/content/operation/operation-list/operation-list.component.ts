import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Operation } from 'src/app/entity/Operation';
import { OperationService } from 'src/app/services/operation/operation.service';

@Component({
  selector: 'app-operation-list',
  templateUrl: './operation-list.component.html',
  styleUrls: ['./operation-list.component.css']
})
export class OperationListComponent implements OnInit {

  opr: Operation[];
  oprId: number;
  isShowModal: boolean = true;
  page = 1;
  pageSize = 5;
  keyword: string;
  display: string;
  constructor(private oprationService: OperationService, private router: Router) { }

  ngOnInit(): void {
    this.getAllOperation();
  }

  getAllOperation() {
    this.oprationService.getListOperation()
      .subscribe(
        data => {
          this.opr = data.operations;
        })
  }
  delete(id: number) {
    this.oprId = id;

  }
  checkDelete() {
    this.oprationService.deleteOperation(this.oprId)
      .subscribe(
        data => {
          this.getAllOperation();
        },
        error => {
          if (error.status == 500) {
            this.openModal();
          }
        })
  }
  openModal() {
    this.display = "block";
  }
  onCloseHandled() {
    this.display = "none";
  }

}
