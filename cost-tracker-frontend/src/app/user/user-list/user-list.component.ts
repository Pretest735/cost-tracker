import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User, UserDataService } from 'src/app/services/user-data.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  userList: User[] = [];
  isApiCallProcessing: boolean;
  constructor(
    private router: ActivatedRoute,
    private userService: UserDataService
  ) { }

  ngOnInit() {
    this.isApiCallProcessing = false;

    // this.userList = [
    //   {
    //     id: 1,
    //     userName: "User1",
    //     charged: 30,
    //     paid: 30,
    //     isActive: true
    //   }
    // ]
    this.getUserList();
    console.log(this.userList);
  }

  getUserList() {
    this.isApiCallProcessing = true;

    this.userService.getUserList().subscribe(
      (res => {
        if(res){
          this.userList = res;
        }
        else {
          console.log("Failed to get user list.");
        }
      }),
      (err: any) => {
        console.log(err);
      }
    )

  }

}
