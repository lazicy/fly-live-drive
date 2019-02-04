import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { Subject } from 'rxjs';

@Injectable()
export class RoomService {
	

    constructor(private http: HttpClient) { }
    
    saveRoom(room) {
        return this.http.post("/api/room", room);
    }

}