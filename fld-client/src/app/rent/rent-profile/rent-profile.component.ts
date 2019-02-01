import { Component, OnInit } from '@angular/core';
import { RentService } from 'src/app/services/rentacar.service';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { SafeStyle, DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-rent-profile',
  templateUrl: './rent-profile.component.html',
  styleUrls: ['./rent-profile.component.css']
})
export class RentProfileComponent implements OnInit {

  rent: any;
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
  }

  onToggleBranches() {
		this.showBranches = !this.showBranches;
	}

}
