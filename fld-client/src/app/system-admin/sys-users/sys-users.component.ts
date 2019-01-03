import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-sys-users',
  templateUrl: './sys-users.component.html',
  styleUrls: ['./sys-users.component.css']
})
export class SysUsersComponent implements OnInit {

  showFormDialog: boolean = false;
  userList: any;
  emptyUserList: any;

  constructor(private http: HttpClient, private userService: UserService) { }

  ngOnInit() {
    this.userService.getUsers()
    .subscribe(
      (data) => {
        this.userList = data;
        if(this.userList.length === 0) {
          this.emptyUserList = true;
        }
      },
      (error) => alert("Error: " + error)
    );
  }

  onChangeAuth(username) {
    this.showFormDialog = true;
  }

  onCloseForm() {
		this.showFormDialog = false;
  }

}
