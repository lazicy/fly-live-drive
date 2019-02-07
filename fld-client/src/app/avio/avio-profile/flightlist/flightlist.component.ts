import { Component, OnInit, Input } from '@angular/core';
import { AvioService } from 'src/app/services/avio.service';
import { FlightService } from 'src/app/services/flight.service';
import { UtilService } from 'src/app/services/util.service';

@Component({
  selector: 'app-flightlist',
  templateUrl: './flightlist.component.html',
  styleUrls: ['./flightlist.component.css']
})

export class FlightlistComponent implements OnInit {
	flights: any = [];
	@Input() avioId: number;
	@Input() flightList: any = []

	searchList: boolean = false;
	whichOnes = false;

	constructor(private avioService: AvioService, private flightSerice: FlightService, private utilService: UtilService) { }

	ngOnInit() {

		if (this.avioId != -1) {
			this.fetchFlights();
		} else {
			this.flights = this.flightList;
			console.log(this.flightList);
			this.formatDateAndTime();
			this.searchList = true;

		}

	}

	fetchFlights() {
		this.avioService.getAviosFlights(this.avioId).subscribe(
			(data) => {
				this.flights = data;
				this.formatDateAndTime();
			},
			(error) => console.log(error)
		);
	}
	
	formatDateAndTime() {

		for (let f of this.flights) {
			f.totalDurationMins = f.totalDuration % 60;
			f.totalDurationHours = Math.floor(f.totalDuration/60);
			f.totalDurationDays = Math.floor(f.totalDurationHours/24);
			f.totalDurationHours -= f.totalDurationDays * 24;

			let fd = new Date(f.departureDate);
			let fl = new Date(f.landingDate);

			f.departureDate = this.utilService.monthsFull[fd.getMonth()] + " " + fd.getDate() + ", " + fd.getFullYear();
			f.landingDate = this.utilService.monthsFull[fl.getMonth()] + " " + fl.getDate() + ", " + fl.getFullYear();
			
			if (fd.getMinutes() < 10) {
				f.departureTime = fd.getHours() + ":0" + fd.getMinutes();
				
			} else {
				f.departureTime = fd.getHours() + ":" + fd.getMinutes();
			}


			if (fl.getMinutes() < 10) {
				f.landingTime = fl.getHours() + ":0" + fl.getMinutes();
				
			} else {
				f.landingTime = fl.getHours() + ":" + fl.getMinutes();
			}
		}
	}

	calculateAvailableSeats() {

		

	}

	overInterceptions() {
		this.whichOnes = true;
	}

	outInterceptions() {
		this.whichOnes = false;
	}

	

}