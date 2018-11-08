import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-jove',
  templateUrl: './jove.component.html',
  styleUrls: ['./jove.component.css']
})
export class JoveComponent implements OnInit {
  jove: any;
  broj: number;
  gate: boolean = false;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.getData();
    this.broj = 3;

  }

  getData() {
    return this.http.get("http://localhost:8080/jove").subscribe(data => this.jove = data);
  }

  onShow() {
    this.gate = true;
  }

}
