import { Component, OnInit } from '@angular/core';
import { RentService } from 'src/app/services/rentacar.service';

@Component({
  selector: 'app-rent-list',
  templateUrl: './rent-list.component.html',
  styleUrls: ['./rent-list.component.css']
})
export class RentListComponent implements OnInit {

  rentList: any;
  emptyRentList: boolean = false;

  constructor(private service: RentService) { }

  ngOnInit() {

    this.service.getServices().subscribe(
      (data) => {
        this.rentList = data;
        if(this.rentList.length === 0){
          this.emptyRentList = true;
        }
      },
      (error) => console.log(error)
    )

  }

}
