import { Component, OnInit } from '@angular/core';
import { FlightService } from '../services/flight.service';

@Component({
  selector: 'app-laza-smarac',
  templateUrl: './laza-smarac.component.html',
  styleUrls: ['./laza-smarac.component.css']
})
export class LazaSmaracComponent implements OnInit {

  bulijan: boolean = true;

  constructor(private flightService : FlightService) { }

  ngOnInit() {

  }

  onMilanche() {
    this.bulijan = !this.bulijan;
  }

}
