import { Component, OnInit, EventEmitter, Output, Input, OnDestroy } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AvioService } from 'src/app/services/avio.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-avio-form',
  templateUrl: './avio-form.component.html',
  styleUrls: ['./avio-form.component.css']
})

/* ova forma ce koristiti i za insert avio kompanije i za edit, nekako cu vec smisliti implementaciju, da li na osnovu url-a ili na osnovu @Input() [pogledajte dokumentaciju]
*/
export class AvioFormComponent implements OnInit, OnDestroy {
	
	@Output() avioSubmit = new EventEmitter();

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
				// emituje se event koji se slusa u selektoru ove komponente (child) u okviru html-a parent komponente (ovde se salje
				// response a tamo se prima $event). 
				this.avioSubmit.emit(response);
				this.ngOnDestroy();
			},
			(error) => console.log(error)
		);

		form.reset();

	}

	onReset(form: NgForm) {
		form.reset();
	}

	ngOnDestroy() {
		this.avioSubmit.unsubscribe();
	}



}
