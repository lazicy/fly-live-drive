import { Component, OnInit } from '@angular/core';
import { RentService } from 'src/app/services/rentacar.service';
import { ActivatedRoute, Params } from '@angular/router';
import { CountryService } from 'src/app/services/country.service';

@Component({
  selector: 'app-vehicle-search',
  templateUrl: './vehicle-search.component.html',
  styleUrls: ['./vehicle-search.component.css']
})
export class VehicleSearchComponent implements OnInit {

  countryList: any = [];
  cityList: any = [];
  id: Number;
  time: any = ['7:00', '7:30', '8:00', '8:30','9:00','9:30','10:00','10:30','11:00','11:30','12:00','12:30','13:00','13:30','14:00','14:30','15:00','15:30','16:00','16:30','17:00','17:30','18:00'];
  constructor(private countryService: CountryService, private rentService: RentService, private route: ActivatedRoute) {
    this.route.params.subscribe(
      (params: Params)=>{
        this.id = +params['id'];
      }
    )
    this.countryService.getRentCountries(this.id).subscribe(
      (data) => {
        this.countryList = data;
      }
    )
   }

  ngOnInit() {
  }
  onChangeCountry(event){
    const selectedCountryId = event.target.value;
    this.getCities(selectedCountryId);
  }
  getCities(id){
    this.countryService.getCityByCountryId(this.id,id).subscribe(
      (data) => {
        this.cityList = data;
      },
      (error) => console.log(error)
    )
  }


}
