import { Component, OnInit, OnDestroy, EventEmitter, Output, Input } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-first-log',
  templateUrl: './first-log.component.html',
  styleUrls: ['./first-log.component.css']
})
export class FirstLogComponent implements OnInit {

  @Output() passSubmit = new EventEmitter();
  @Input() usr: string;

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  ngOnDestroy() {
		this.passSubmit.unsubscribe();
  }

  onSubmitForm(form: NgForm) {
    let isto = false;
    if(form.value.new === form.value.repeat) {
      isto = true;
    }

    if (isto) {
      let user = {
        firstname: "",
        lastname: "",
        username: this.usr,
        password: form.value.new,
        email: "",
        city: ""
      }

      this.userService.changePass(user).subscribe(
        (data) => {
          this.passSubmit.emit(data);
        }
      );
    }
  }

}
