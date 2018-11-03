import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {
  public message: string;
  data: any;
  constructor(private http: HttpClient) { }

  ngOnInit() {
     this.getData();
     setTimeout(() => console.log(this.data), 3000);
  }

  getData() {
    return this.http.get("http://localhost:8080/testarino").subscribe(data => this.data = data);
  }

}
