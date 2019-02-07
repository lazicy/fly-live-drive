import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ReservationFlightService {

  constructor() { }

  public departureFlightId = -1;
  public returnFlightId = -1;

}
