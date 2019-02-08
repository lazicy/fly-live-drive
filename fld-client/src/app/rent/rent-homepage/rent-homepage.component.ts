import { Component, OnInit } from '@angular/core';
import { RentService } from 'src/app/services/rentacar.service';

@Component({
  selector: 'app-rent-homepage',
  templateUrl: './rent-homepage.component.html',
  styleUrls: ['./rent-homepage.component.css']
})
export class RentHomepageComponent implements OnInit {
  rentListFilter: any;
  emptyRentListFilter: boolean = false;
  filter: boolean = false;
  rentName: string;

  constructor(private service: RentService) { }

  ngOnInit() {

  }

  onSearch(){
    this.filter = true;
    this.rentName = this.rentName.replace(/\s/g, "-")
    this.service.getServicesFilter(this.rentName).subscribe(
      (data) => {
        this.rentListFilter = data;
        if(this.rentListFilter.length === 0){
          this.emptyRentListFilter = true;
        }
      },
      (error) => alert(error)
    )

  }

  onRefresh(){
    this.filter = false;
    this.rentName = ""; 
  }


}
