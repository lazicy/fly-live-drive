import { Component, OnInit } from '@angular/core';
import { RentService } from 'src/app/services/rentacar.service';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { SafeStyle, DomSanitizer } from '@angular/platform-browser';
import { BranchesComponent } from '../rent-admin/branches/branches.component';
import { VehiclesComponent } from '../rent-admin/branches/vehicles/vehicles.component';

@Component({
  selector: 'app-rent-profile',
  templateUrl: './rent-profile.component.html',
  styleUrls: ['./rent-profile.component.css']
})
export class RentProfileComponent implements OnInit {

  rent: any;
  branches: any = [];
  vehicles: any = [];
  pomocna: any = [];
  objekat: any;
  id: number;
  emptyVehicleList: boolean = false;
  emptyBranchesList: boolean = false;
  map: boolean = false;

  showBranches: boolean = false;
  showVehicles: boolean = false;

  constructor(private rentService: RentService, private route: ActivatedRoute, private router: Router, public sanitizer: DomSanitizer) {
   
    this.route.params.subscribe(
			(params: Params) => {
				this.id = +params['id'];
			}
    );
    
    if (this.id !== NaN && this.id !== undefined) {
			this.rentService.getRent(this.id).subscribe(
				(data) => {
					this.rent = data;
					if(this.rent.map === "") {
						this.map = true;
					}
				},
				(error) => {
					console.log(error);
					if (error.status === 404) {
						this.router.navigate(['rent']);
					} else {
						console.error(error);
					}
				}
			);
		}
  }

  ngOnInit() {
	this.rentService.getAllBranches(this.id).subscribe(
		(data) => {
			this.branches = data;
			if(this.branches.length === 0) {
				this.emptyBranchesList = true;
			}
		},
		(error) => {
			console.log(error);
			if (error.status === 404) {
				this.router.navigate(['rent']);
			} else {
				console.error(error);
			}
		}
	);

	this.svaVozila();
  }
  

  	onToggleBranches() {
		this.showBranches = !this.showBranches;
	}

	onToggleVehicles() {
		this.showVehicles = !this.showVehicles;
	}

	svaVozila() {
		this.rentService.getRENTVehicles(this.id).subscribe(
			(data) => {
				this.vehicles = data;
				if(this.vehicles.length === 0) {
					this.emptyVehicleList = true;
				}
			},
			(error) => {
				console.log(error);
				if (error.status === 404) {
					this.router.navigate(['rent']);
				} else {
					console.error(error);
				}
			}
		);
		
	}

}
