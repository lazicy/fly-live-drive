import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";


@Injectable()
export class HotelService {
    hotels: any;
    
    constructor(private http:HttpClient) {}

    getHotels() {
        return this.http.get("/api/hotel/all");
    }

    getHotel(id: number) {
        return this.http.get("/api/hotel/" + id);
    }

    saveHotel(hotel) {
		return this.http.post("/api/hotel", hotel);
    }
    
    deleteHotel(id: number) {
		return this.http.delete("/api/hotel/" + id);
	}

}