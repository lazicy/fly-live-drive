import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReservationHotelService {

  constructor(private http: HttpClient) { }

  public checkin: Date = new Date();
  public checkout: Date = new Date();
  public guests: number = 2;

  saveFlightReservation(hotelReservation) {
    return this.http.post("/api/flightreservation", hotelReservation);
}

}
