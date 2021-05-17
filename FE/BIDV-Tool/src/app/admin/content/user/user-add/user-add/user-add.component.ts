import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/entity/User';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-user-add',
  templateUrl: './user-add.component.html',
  styleUrls: ['./user-add.component.css']
})
export class UserAddComponent implements OnInit {
  user : User = new User();
  date = new Date();
  constructor(private userService : UserService, private router : Router, private datePipe: DatePipe) { 
    
  }

  ngOnInit(): void {
  }
  onSubmit(){
    this.userService.addUser(this.user).subscribe(data=> {
      // this.router.navigateByUrl("/admin/user-list")
      // alert("Thêm thành công");
      console.log("success");
      
    })
  }
}
