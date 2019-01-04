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
  crole: any;
  usr: any;

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

  onChangeAuth(role, user) {
    this.showFormDialog = true;
    this.crole = role;
    this.usr = user;
  }

  userSubmitted(response) {
    let i = this.userList.findIndex(user => user.username === response.username);
    this.userList.splice(i, 1);
    this.userList.push(response);
    this.showFormDialog = false;
  }

  onCloseForm() {
		this.showFormDialog = false;
  }

}
