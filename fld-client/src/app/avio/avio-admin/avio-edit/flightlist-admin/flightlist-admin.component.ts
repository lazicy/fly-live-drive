import { Component, OnInit, Input } from '@angular/core';
import { AvioService } from 'src/app/services/avio.service';
import { FlightService } from 'src/app/services/flight.service';
import { AvioEditComponent } from '../avio-edit.component';

@Component({
  selector: 'app-flightlist-admin',
  templateUrl: './flightlist-admin.component.html',
  styleUrls: ['./flightlist-admin.component.css']
})
export class FlightlistAdminComponent implements OnInit {
  flights: any = [];
  @Input() avioId: number;
  constructor(private avioService: AvioService, private flightSerice: FlightService) { }

  ngOnInit() {
    this.fetchFlights();
  }

  fetchFlights() {
		this.avioService.getAviosFlights(this.avioId).subscribe(
			(data) => {
			  this.flights = data;
			},
			(error) => console.log(error)
		);
	}


}
