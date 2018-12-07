import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AvioService } from 'src/app/services/avio.service';

@Component({
  selector: 'app-avio-admin',
  templateUrl: './avio-admin.component.html',
  styleUrls: ['./avio-admin.component.css']
})
export class AvioAdminComponent implements OnInit {
	showFormDialog: boolean = false;
	showAvioList: boolean = false;
	avioList: any = [];
	emptyAvioList: boolean = true;
	constructor(private router: Router, private avioService: AvioService) { }

	ngOnInit() {
		
		console.log("onInitAvioAdmin");
	}

	onInsertAirline() {
		console.log("ping");
		this.showFormDialog = true;
	}

	onCloseForm() {
		this.showFormDialog = false;
	}

	// event koji se slao sa ,emit(response), uhvacen u html-u, ovde se obradjuje
	avioSubmitted(response) {
		this.avioList.push(response);
		this.showFormDialog = false;
	}

	onShowAirlines() {
		this.showAvioList = !this.showAvioList;

		// ili prazna ili null
		if (this.avioList.length === 0 || !this.avioList) {
			this.avioService.getAvios()
			.subscribe(
				(data) => { 
					this.avioList = data;
					if (this.avioList.length === 0) {
						this.emptyAvioList = true;
					} else {
						this.emptyAvioList = false;
					}
				},
				(error) => console.error(error)
			);
		}

	}

	onDeleteAvio(id) {
		// nakon upucenog delete requesta, nema potrebe da se ponovo dobavlja lista sa servera, vec se samo taj objekat izbaci iz liste sa klijenta
		this.avioService.deleteAvio(id).subscribe(
			(result) => {
				// fensi for petlja
				let i = this.avioList.findIndex(avio => avio.id === id);
				// obrisi jednog clana na poziciji i
				this.avioList.splice(i, 1);

			}, (error) => console.log(error)
		);
	}

 

}
