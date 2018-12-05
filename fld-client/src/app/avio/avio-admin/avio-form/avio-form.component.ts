import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AvioService } from 'src/app/services/avio.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-avio-form',
  templateUrl: './avio-form.component.html',
  styleUrls: ['./avio-form.component.css']
})
export class AvioFormComponent implements OnInit {
	showSuccessMessage: boolean = false;
	constructor(private avioService: AvioService, private router: Router) { }

	ngOnInit() {
	}


	onSubmitAvio(form: NgForm) {

		const name = form.value.name;
		const description = form.value.description;

		let avio = {
			name: name,
			description: description
		}

		this.avioService.saveAvio(avio).subscribe(
			(response) => {
				console.log(response);
				this.showSuccessMessage = true;
			},
			(error) => console.log(error)
		);

		form.reset();

	}

	onReset(form: NgForm) {
		form.reset();
	}

}
