import { Component, OnInit, Input } from '@angular/core';
import { AvioService } from 'src/app/services/avio.service';
import { FlightService } from 'src/app/services/flight.service';
import { UtilService } from 'src/app/services/util.service';

@Component({
  selector: 'app-flightlist-search',
  templateUrl: './flightlist-search.component.html',
  styleUrls: ['./flightlist-search.component.css']
})
export class FlightlistSearchComponent implements OnInit {
f = null;
@Input() flight;

searchList: boolean = false;
whichOnes = false;

constructor(private avioService: AvioService, private flightSerice: FlightService, private utilService: UtilService) { }

ngOnInit() {


  this.f = this.flight;
  this.formatDateAndTime();
  this.searchList = true;

  

}


formatDateAndTime() {

 
    this.f.totalDurationMins = this.f.totalDuration % 60;
    this.f.totalDurationHours = Math.floor(this.f.totalDuration/60);
    this.f.totalDurationDays = Math.floor(this.f.totalDurationHours/24);
    this.f.totalDurationHours -= this.f.totalDurationDays * 24;

    let fd = new Date(this.f.departureDate);
    let fl = new Date(this.f.landingDate);

    this.f.departureDate = this.utilService.monthsFull[fd.getMonth()] + " " + fd.getDate() + ", " + fd.getFullYear();
    this.f.landingDate = this.utilService.monthsFull[fl.getMonth()] + " " + fl.getDate() + ", " + fl.getFullYear();
    
    if (fd.getMinutes() < 10) {
      this.f.departureTime = fd.getHours() + ":0" + fd.getMinutes();
      
    } else {
      this.f.departureTime = fd.getHours() + ":" + fd.getMinutes();
    }


    if (fl.getMinutes() < 10) {
      this.f.landingTime = fl.getHours() + ":0" + fl.getMinutes();
      
    } else {
      this.f.landingTime = fl.getHours() + ":" + fl.getMinutes();
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