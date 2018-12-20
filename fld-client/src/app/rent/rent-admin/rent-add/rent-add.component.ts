import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { RentService } from 'src/app/services/rentacar.service';

@Component({
  selector: 'app-rent-add',
  templateUrl: './rent-add.component.html',
  styleUrls: ['./rent-add.component.css']
})
export class RentAddComponent implements OnInit {

  services: any;
  show: boolean = false;

  constructor(private http: HttpClient, private service: RentService) { }

  ngOnInit() {
    this.getServices();
  }

  getServices(){
    this.service.getServices().subscribe(data => this.services = data);
  }

  toggleList(){
    this.show = !this.show;
  }

  
  onSubmitAdd(form: NgForm){
      const name = form.value.name;
      const adress = form.value.adress;
      const desc = form.value.description;

      let rent = {
        name: name,
        adress: adress,
        description: desc
      }

      this.service.saveRent(rent).subscribe(
        (success) => {
          console.log(success);
       },
       error => console.log(error)
      );
      form.reset();
  }

  deleteRent(id){
    this.service.deleteRent(id).subscribe(
			(result) => {
				// fensi for petlja
				let i = this.services.findIndex(rent => rent.id === id);
				// obrisi jednog clana na poziciji i
				this.services.splice(i, 1);
			}, (error) => console.log(error));
  }

}
