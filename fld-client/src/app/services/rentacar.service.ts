import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";

@Injectable()
export class RentService{

    constructor(private http: HttpClient) {}

    saveRent(rent){
        return this.http.post("http://localhost:4200/api/rent", rent);
    }

    getServices(){
        return this.http.get("http://localhost:4200/api/rent/all");
    }

    deleteRent(id){
        return this.http.delete("http://localhost:4200/api/rent/delete/" + id);
    }

    editRent(rent){
        return this.http.put("http://localhost:4200/api/rent/edit/",rent)
    }

    addBranchOffice(branch){
        return this.http.post("http://localhost:4200/api/rent/addBanch/",branch);
    }

    getAllBranches(id){
        return this.http.get("http://localhost:4200/api/rent/getAllBranches/" + id)
    }

}