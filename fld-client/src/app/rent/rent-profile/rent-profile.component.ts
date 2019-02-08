import { Component, OnInit } from '@angular/core';
import { RentService } from 'src/app/services/rentacar.service';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { SafeStyle, DomSanitizer } from '@angular/platform-browser';
import { BranchesComponent } from '../rent-admin/branches/branches.component';
import { VehiclesComponent } from '../rent-admin/branches/vehicles/vehicles.component';
import { UserService } from 'src/app/services/user.service';
import { FastVehicleService } from 'src/app/services/fastvehicle.service';

@Component({
  selector: 'app-rent-profile',
  templateUrl: './rent-profile.component.html',
  styleUrls: ['./rent-profile.component.css']
})
export class RentProfileComponent implements OnInit {

  rent: any;
  branches: any = [];
  vehicles: any = [];
  vehicleFastList: any = [];
  pomocna: any = [];
  objekat: any;
  id: number;
  emptyVehicleFastList: boolean = false;
  emptyVehicleList: boolean = false;
  emptyBranchesList: boolean = false;
  map: boolean = false;


  isAdmin: boolean = false;

  showFormDialog: boolean = false;
  showBranches: boolean = false;
  showVehicles: boolean = false;
  showVehicleFast: boolean =  false;

  constructor(private fastService: FastVehicleService,private userService: UserService,private rentService: RentService, private route: ActivatedRoute, private router: Router, public sanitizer: DomSanitizer) {


    this.route.params.subscribe(
			(params: Params) => {
				this.id = +params['id'];
			}
    );
    
    if (this.id !== NaN && this.id !== undefined) {
			this.rentService.getRent(this.id).subscribe(
				(data) => {
					this.rent = data;
					if(this.rent.addressOnMap !== "") {
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

	this.fastService.getFastVehicles(this.id).subscribe(
		(data) => {
			this.vehicleFastList = data;
			if(this.vehicleFastList.length === 0){
				this.emptyVehicleFastList = true;
			}
		},
		(error) => {
			this.emptyVehicleFastList = true;
		}
	)

	this.userService.getUserRole().subscribe(
		(data: string) => {
			//ako ima odgovarajucu rolu onda omoguci da radi funkcije
			//u suprotnom sakrij
			let role = data;
			if(role === 'RENT_ADMIN'){
				this.isAdmin = true;
			}
		},
		(error) => {alert("PUCA")}
	)
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
  
  	onEditRent(){
		this.showFormDialog = true;
	}
	
	onCloseForm(){
		this.showFormDialog = false;
	}

  	onToggleBranches() {
		this.showBranches = !this.showBranches;
	}

	onToggleVehicles() {
		this.showVehicles = !this.showVehicles;
	}

	onToggleFast(){
		this.showVehicleFast = !this.showVehicleFast;
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

	rentSubmitted(response){
		window.location.reload();
		this.showFormDialog = false;
	}



}
