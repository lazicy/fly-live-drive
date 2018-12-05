import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-avio-admin',
  templateUrl: './avio-admin.component.html',
  styleUrls: ['./avio-admin.component.css']
})
export class AvioAdminComponent implements OnInit {

	showFormDialog: boolean = false;
	constructor(private router: Router) { }

	ngOnInit() {
		
		console.log("onInitAvioAdmin");
	}

	onInsertAirline() {
		console.log("ping");
		this.showFormDialog = true;
		this.router.navigate(['avio/admin/new'])
	}

	onCloseForm() {
		this.showFormDialog = false;
	}

 

}
