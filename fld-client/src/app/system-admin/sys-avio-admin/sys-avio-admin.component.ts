import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AvioService } from 'src/app/services/avio.service';

@Component({
  selector: 'app-sys-avio-admin',
  templateUrl: './sys-avio-admin.component.html',
  styleUrls: ['./sys-avio-admin.component.css']
})
export class SysAvioAdminComponent implements OnInit {
  showFormDialog: boolean = false;
	showAvioList: boolean = false;
	avioList: any = [];
	emptyAvioList: boolean = true;
	constructor(private router: Router, private avioService: AvioService) { }

	ngOnInit() {

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

	onInsertAirline() {
		this.showFormDialog = true;
	}

	onCloseForm() {
		this.showFormDialog = false;
	}

	// event koji se slao sa ,emit(response), uhvacen u html-u, ovde se obradjuje
	avioSubmitted(response) {
		this.avioList.push(response);
		this.showFormDialog = false;
		this.emptyAvioList = false;
	}

	onDeleteAvio(id) {

		swal({
			title: "Are you sure?",
			icon: "warning",
			buttons: ["Cancel", "Delete"],
			dangerMode: true,
		  })
		  .then((willDelete) => {
			if (willDelete) {
				this.avioService.deleteAvio(id).subscribe(
					(result) => {
						// fensi for petlja
						let i = this.avioList.findIndex(avio => avio.id === id);
						// obrisi jednog clana na poziciji i
						this.avioList.splice(i, 1);
						swal({title: "Success!", text: "Avio company deleted.", icon: "success", timer: 1500});
						if(this.avioList.length === 0) {
							this.emptyAvioList = true;
						  }
					}, (error) => {swal ( "Error occured" ,  "The company was not deleted." ,  "error" );}
				);
			}
		  });
	}

 

}
