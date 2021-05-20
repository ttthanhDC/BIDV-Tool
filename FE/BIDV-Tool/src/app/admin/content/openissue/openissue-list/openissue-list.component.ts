import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OpenIssue } from 'src/app/entity/OpenIssue';
import { OpenissueService } from 'src/app/services/openissue/openissue.service';

@Component({
  selector: 'app-openissue-list',
  templateUrl: './openissue-list.component.html',
  styleUrls: ['./openissue-list.component.css']
})
export class OpenissueListComponent implements OnInit {

  issue: OpenIssue[];
  issueId: number;
  isShowModal: boolean = true;
  page = 1;
  pageSize = 5;
  
  constructor(private openissueService: OpenissueService, private router: Router) { }

  ngOnInit(): void {
    this.getAllOpenIssue();
  }

  getAllOpenIssue() {
    this.openissueService.getListOpenIssue()
      .subscribe(
        data => {          
          this.issue = data.issues;
          this.issue.forEach(element => {
            console.log(element.openDate);
            
          });
        })
  }
  delete(id: number) {
    this.issueId = id;
    
  }
  checkDelete() { 
    this.openissueService.deleteOpenIssue(this.issueId)
      .subscribe(
        data => {
          this.getAllOpenIssue();
        })
  }

}
