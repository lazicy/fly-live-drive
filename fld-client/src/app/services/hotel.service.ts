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

    updateHotel(hotel) {
        return this.http.put("/api/hotel", hotel);
    }
    
    searchHotel(searchParams) {
        return this.http.post("/api/hotel/search", searchParams);
    }

    getHotelServices(id: number) {
		return this.http.get("/api/hotel/" + id + "/services");
    }
    
    saveHotelService(serv, id:number) {
		return this.http.post("/api/hotel/service/" + id, serv);
    }

    removeHotelService(idSer: number, idHot: number) {
        return this.http.delete("/api/hotel/" + idHot + "/service/" + idSer);
    }

    updateHotelService(serv, id:number) {
        return this.http.put("/api/hotel/service/" + id, serv);
    }

    getHotelService(idS: number) {
		return this.http.get("/api/hotel/service/" + idS);
    }

    getHotelRooms(id: number) {
        return this.http.get("/api/hotel/" + id + "/rooms");
    }

    saveHotelRoom(room, id:number) {
		return this.http.post("/api/hotel/room/" + id, room);
    }

    removeHotelRoom(idR: number, idH: number) {
        return this.http.delete("/api/hotel/" + idH + "/room/" + idR);
    }

    updateHotelRoom(room, idH: number) {
        return this.http.put("/api/hotel/room/" + idH, room);
    }

    getHotelRoom(idR: number) {
        return this.http.get("/api/hotel/room/" + idR);
    }

    saveFastRez(fastRez, id: number) {
      return this.http.post('/api/hotel/addFastRes/' + id, fastRez);
    }

    saveFastResServices(usluge, id:number) {
      return this.http.post('/api/hotel/addFastResServices/' + id, usluge);
    }

    getFastRes(id: number) {
      return this.http.get('/api/hotel/getFastRes/' + id);
    }

    getFreeRooms(id: number, podaci) {
      return this.http.post('/api/hotel/getFreeRooms/' + id, podaci)
    }

}