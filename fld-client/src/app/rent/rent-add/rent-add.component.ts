import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-rent-add',
  templateUrl: './rent-add.component.html',
  styleUrls: ['./rent-add.component.css']
})
export class RentAddComponent implements OnInit {

  services: any;
  show: boolean = false;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.getServices();

  }

  getServices(){
  this.http.get("http://localhost:4200/api/rent/all").subscribe(data => this.services = data);
  }

  onSubmitRent(form: NgForm){
      const name = form.value.name;
      const adress = form.value.adress;
      const desc = form.value.description;

      let rent = {
        name: name,
        adress: adress,
        description: desc
      }

      this.saveRent(rent);
      

      form.reset();
  }

  saveRent(rent){

    this.http.post("http://localhost:4200/api/rent", rent)
			.subscribe(
				(success) => {
					 console.log(success);
				},
				error => console.log(error)
			);
  
  }

  onToggleServices(){
    this.show = !this.show;
  }

}
