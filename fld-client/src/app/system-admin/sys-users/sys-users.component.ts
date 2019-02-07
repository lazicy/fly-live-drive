import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserService } from 'src/app/services/user.service';
import { NgForm } from '@angular/forms';
import { BonusPointsService } from 'src/app/services/bonus.service';

@Component({
  selector: 'app-sys-users',
  templateUrl: './sys-users.component.html',
  styleUrls: ['./sys-users.component.css']
})
export class SysUsersComponent implements OnInit {
  role: any;

  showAdd: boolean = false;
  posto: any = [5,10,15,20,25,30,35,40,45,50];
  bonusi: any = null;

  showPointExistMsg: boolean = false;

  constructor(private http: HttpClient, private userService: UserService, private bonusService: BonusPointsService) { }

  ngOnInit() {
    this.role = "AVIO_ADMIN";
    this.bonusService.getBonuses().subscribe(
      data => {
        this.bonusi = data;
      },  
      error => console.log(error)
    );
  }

  onSubmitAdmin(form: NgForm) {
    const name = form.value.name;
    const lastname = form.value.lastname;
    const username = form.value.username;
    const email = form.value.email;
    const password = form.value.password;
    const city = form.value.city;

    let user = {
      firstname: name,
      lastname: lastname,
      username: username,
      password: password,
      email: email,
      city: city
    }

    this.userService.regAdmin(user, this.role).subscribe(
      (response) => {
        swal({title: "Admin added!", text: "Check the e-mail to confirm your account.", icon: "success"});
        form.reset();
      },
      (error) => {swal ( "Error occured" ,  "Admin was not added." ,  "error" );}
    );
  }

  onSubmitBonus(form: NgForm) {
    let postoji = false;
    for(let b of this.bonusi) {
        if(b.points === form.value.points) {
          postoji = true;
          break;
        }
    }
    if(!postoji) {
      this.showPointExistMsg = false;

      let bon = {
        points: form.value.points,
        discount: form.value.discount
      }

      this.bonusService.saveBonus(bon).subscribe(
        (response) => {
          this.bonusi.push(response);
          swal({title: "Bonus added!", icon: "success", timer:1500});
          form.reset();
        },
        (error) => {swal ( "Error occured" ,  "Bonus was not added." ,  "error" );}
      );
    } else {
      this.showPointExistMsg = true;
    }
  }

  onReset(form: NgForm) {
    form.reset();
  }

  onKeydown(e) {
    if(!((e.keyCode > 95 && e.keyCode < 106)
      || (e.keyCode > 47 && e.keyCode < 58) 
      || e.keyCode == 8)) {
        return false;
    }
  }

  onAddBonus() {
    this.showAdd = !this.showAdd;
  }

  onRemoveBonus(idB) {
    swal({
      title: "Are you sure?",
      icon: "warning",
      buttons: ["Cancel", "Delete"],
      dangerMode: true,
    })
    .then((willDelete) => {
      if (willDelete) {
        this.bonusService.removeBonus(idB).subscribe(
          (result) => {
              let i = this.bonusi.findIndex(bon => bon.id === idB);
              this.bonusi.splice(i, 1);
              swal({title: "Success!", text: "Bonus deleted.", icon: "success", timer: 1500});
          }, (error) =>  {swal ( "Error occured" ,  "Bonus was not deleted." ,  "error" );}
          );
      }
    });
  }


}
