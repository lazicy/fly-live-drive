import { Component, OnInit, EventEmitter, Output, Input, OnDestroy } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AvioService } from 'src/app/services/avio.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sys-avio-form',
  templateUrl: './sys-avio-form.component.html',
  styleUrls: ['./sys-avio-form.component.css']
})
export class SysAvioFormComponent implements OnInit, OnDestroy {
  @Output() avioSubmit = new EventEmitter();
	destinations: any = [];

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
				swal({title: "Success!", text: "Avio company added", icon: "success", timer: 1500});
				this.ngOnDestroy();
			},
			(error) => {swal ( "Error occured" ,  "The company was not added." ,  "error" );}
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
