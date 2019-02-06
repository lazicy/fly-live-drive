import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";

@Injectable()
export class BonusPointsService {

    constructor(private http: HttpClient) { }

    saveBonus(bonus){
        return this.http.post("/api/bonus", bonus);
    }

    getBonuses() {
        return this.http.get('/api/bonus/all');
    }

    removeBonus(id: number) {
        return this.http.delete('/api/bonus/' + id);
    }

}

