import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";

@Injectable()
export class RentService{

    constructor(private http: HttpClient) {}

    getRent(id){
        return this.http.get("http://localhost:4200/api/rent/getRent/" + id);
    }

    saveRent(rent){
        return this.http.post("http://localhost:4200/api/rent", rent);
    }

    getServices(){
        return this.http.get("http://localhost:4200/api/rent/all");
    }

    getServicesFilter(name){
        return this.http.get('api/rent/getServicesFilter/'+ name);
    }

    deleteRent(id){
        return this.http.delete("http://localhost:4200/api/rent/delete/" + id);
    }

    editRent(rent){
        return this.http.put("http://localhost:4200/api/rent/edit/",rent)
    }

    getBranchOffice(id){
        return this.http.get('/api/rent/getBranchOffice/' + id);
    }

    addBranchOffice(branch,idRent){
        return this.http.post("http://localhost:4200/api/rent/addBranch/" + idRent,branch);
    }

    deleteBranchOffice(idF){
        return this.http.delete('/api/rent/deleteBranch/'+ idF);
    }

    editBranchOffice(branch,idR){
        return this.http.put("http://localhost:4200/api/rent/editBranchOffice/"+idR,branch)
    }

    getAllBranches(id){
        return this.http.get("http://localhost:4200/api/rent/getAllBranches/" + id)
    }

    getAllVehicles(idF){
        return this.http.get('/api/rent/getAllVehicles/'+ idF);
    }

    addVehicle(vehicle,idF){
        return this.http.post("/api/rent/addVehicle/"+idF, vehicle);
    }

    deleteVehicle(id){
        return this.http.delete('api/rent/deleteVehicle/'+ id);
    }

    editVehicle(vehicle,idF){
        return this.http.put('api/rent/editVehicle/'+idF,vehicle);
    }

    getVehicle(id){
        return this.http.get('/api/rent/getVehicle/'+id);
    }

    getRENTVehicles(id){
        return this.http.get('/api/rent/getRENTVehicles/'+ id);
    }

    searchVehicles(params){
        return this.http.post('/api/rent/searchVehicles',params);
    }

}