import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";


@Injectable()
export class HotelService {
    hotels: any;
    
    constructor(private http:HttpClient) {}

    getHotelList() {
        return this.hotels.slice();
    }

    getHotels() {
        return this.http.get("/api/hotel/all");
    }

    getHotel(id) {
        return this.http.get("/api/hotel/" + id);
    }

}