import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";

@Injectable()
export class AvioService {
  avios: any;
  constructor(private http: HttpClient) { }

  getAvios() {
		this.http.get("http://localhost:4200/api/avio/all").subscribe(data => this.avios = data);
  }

  getAvioList() {
    this.getAvios();
    return this.avios.slice();
  }
  
  
}
