import { Component, OnInit } from '@angular/core';
import { AvioService } from '../avio.service';

@Component({
  selector: 'app-aviolist',
  templateUrl: './aviolist.component.html',
  styleUrls: ['./aviolist.component.css']
})
export class AviolistComponent implements OnInit {
  avioList: any;
  constructor(private avioService: AvioService) { }

  ngOnInit() {
    this.avioList = this.avioService.getAvioList();
  }

}
