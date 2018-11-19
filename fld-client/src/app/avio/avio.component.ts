import { Component, OnInit } from '@angular/core';
import { AvioService } from '../services/avio.service';

@Component({
  selector: 'app-avio',
  templateUrl: './avio.component.html',
  styleUrls: ['./avio.component.css']
})
export class AvioComponent implements OnInit {

  constructor(private avioService: AvioService) { }

  ngOnInit() {
  }

}
