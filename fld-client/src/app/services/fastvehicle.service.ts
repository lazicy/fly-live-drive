import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { Subject } from 'rxjs';

@Injectable()
export class FastVehicleService {
	

    constructor(private http: HttpClient) { }
    
    getFastRes(id){
        return this.http.get('/api/fastResVehicle/getRes/' + id);
    }

    addVehicleToRes(vFastDTO){
        return this.http.post('api/fastResVehicle/addVehicleToRes/',vFastDTO);
    }

    getFastVehicles(id){
        return this.http.get('/api/fastResVehicle/getFastVehicles/' + id);
    }

    newFastRes(res){
        return this.http.post('/api/fastResVehicle/newFastRes',res);
    }
}

