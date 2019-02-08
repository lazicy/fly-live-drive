import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReservationFlightService {

  constructor(private http: HttpClient) { }

  public departureFlightId = -1;
  public returnFlightId = -1;

  saveFlightReservation(flightReservation) {
    return this.http.post("/api/flightreservation", flightReservation);
  }

  getFlightReservation(id) {
    return this.http.get("/api/flightreservation/" + id);
  }

  getGlobalReservation(id) {
    return this.http.get("/api/globalreservation/" + id);
    
  }

}
