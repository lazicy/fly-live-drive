import { Component, OnInit, ElementRef } from '@angular/core';
import { RentService } from 'src/app/services/rentacar.service';
import { ActivatedRoute, Params } from '@angular/router';
import { CountryService } from 'src/app/services/country.service';
import { formGroupNameProvider } from '@angular/forms/src/directives/reactive_directives/form_group_name';
import { FormGroup, FormControl } from '@angular/forms';


@Component({
  selector: 'app-vehicle-search',
  templateUrl: './vehicle-search.component.html',
  styleUrls: ['./vehicle-search.component.css'],
})
export class VehicleSearchComponent implements OnInit {

  countryList: any = [];
  cityList: any = [];
  id: Number;
  time: any = ['7:00', '7:30', '8:00', '8:30','9:00','9:30','10:00','10:30','11:00','11:30','12:00','12:30','13:00','13:30','14:00','14:30','15:00','15:30','16:00','16:30','17:00','17:30','18:00'];
  vehicleList: any = [];
  duration: any;

  noResult: boolean = false;

  //FORMA
  searchForm: FormGroup;
  dateValid: boolean = true;
  dateSet: boolean = true;
  showDropOff: boolean = false;

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
    this.initForm()
   }

  initForm(){
    this.searchForm = new FormGroup({
      "country": new FormControl(""),
      "city": new FormControl(""),
      "pickUpDate": new FormControl(""),
      "dropOffDate": new FormControl(""),
      "pickUpTime": new FormControl(""),
      "dropOffTime": new FormControl(""),
      "type": new FormControl(""),
      "numberOfSeats": new FormControl(""),
      "dropOff": new FormControl(""),
      "diffDropOff": new FormControl(false),
    })
  }

  ngOnInit() {
  }

  onSubmitSearch(){
    let pickUp = new Date(this.searchForm.value.pickUpDate + " " + this.searchForm.value.pickUpTime);
    let dropOff = new Date(this.searchForm.value.dropOffDate + " " + this.searchForm.value.dropOffTime); 
    this.dateValid = this.validateDates(pickUp.getTime(), dropOff.getTime());
    
    this.isDateSet();

    if(this.dateValid){
      var params = { 
        city: this.searchForm.value.city,
        pickUp: pickUp,
        dropOff: dropOff,
        seats: this.searchForm.value.numberOfSeats,
      }

      this.rentService.searchVehicles(params).subscribe(
        (data) => {
          this.vehicleList = data;
          if(this.vehicleList.length == 0){
            this.noResult = true;
          }else{
            this.noResult = false;
            this.calculateDuration(pickUp,dropOff);
          }
          
        }
      )

    }
  }

  onReserveVehicle(){

  }
  
  isDateSet(){
    if(this.searchForm.value.pickUpDate === "" && this.searchForm.value.dropOffDate === ""
        && this.searchForm.value.pickUpTime === "" && this.searchForm.value.dropOffTime === ""){
          this.dateSet = false;
        }else{
          this.dateSet = true;
        }
  }

  validateDates(pickUp,dropOff): boolean{
    if(dropOff - pickUp >= 60*60000){
      return true;
    }else{
      return false;
    }
  }

  calculateDuration(pickUp,dropOff){
    this.duration = Math.round((dropOff - pickUp) / (60*60000*24));
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
  onReset(){
    this.searchForm.reset();
  }

  toggleShowDropOff(){
    this.showDropOff = !this.showDropOff;
  }

}


