import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReservationHotelService {

  constructor(private http: HttpClient) { }

  public checkin: Date;
  public checkout: Date;
  public guests: number;

  saveHotelReservation(id:number, username, hotelReservation) {
    return this.http.post("/api/hotel/saveReservation/" + id + '/' + username, hotelReservation);
  }

  saveHotelReservationServices(id: number, usluge) {
    return this.http.post('/api/hotel/addReservationServices/' + id, usluge);
  }

}
