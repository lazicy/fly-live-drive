import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { AvioService } from 'src/app/services/avio.service';
import { FlightService } from 'src/app/services/flight.service';
import { CountryService } from 'src/app/services/country.service';
import { NgForm, FormGroup, FormControl } from '@angular/forms';
@Component({
  selector: 'app-avio-edit',
  templateUrl: './avio-edit.component.html',
  styleUrls: ['./avio-edit.component.css']
})
export class AvioEditComponent implements OnInit {
  
  // properties
  avio: any = null;
  id: number;
	countryList: any = [];
  cityList: any = [];
  
  destCountries: any = [];
  
  // show-hides
  showEditAvioInfo: boolean = false;
  showDestinations: boolean = false;
  showNewDestinationDialog: boolean = false;

  avioInfoForm: FormGroup;

  constructor(private route: ActivatedRoute, private router: Router, private avioService: AvioService, private flightService: FlightService, private countryService: CountryService) { 
   

		// getting route params, params is observable that unsubscribes automatically
		this.route.params.subscribe(
			(params: Params) => {
				this.id = +params['id'];
			}
    );
    
    // get countries for editing
    this.countryService.getCountries().subscribe(
      (data) => {
        this.countryList = data;
      },
      (error) => console.log(error)
    );

    
    
  }

  ngOnInit() {
   
    if (this.id !== NaN && this.id !== undefined) {
			this.avioService.getAvio(this.id).subscribe(
				(data) => {
          this.avio = data;
          this.initAvioInfoForm();
				},
				(error) => {
					console.log(error);
					if (error.status === 404) {
						this.router.navigate(['avio']);
					} else {
						console.error(error);
					}
				}
      );
    }
  
  }

  initAvioInfoForm() {

    this.getCities(this.avio.cityDTO.countryDTO.id);

    this.avioInfoForm = new FormGroup({
      'name': new FormControl(this.avio.name),
      'address': new FormControl(this.avio.address),
      'map': new FormControl(this.avio.map),
      'description': new FormControl(this.avio.description),
      'countryId': new FormControl(this.avio.cityDTO.countryDTO.id),
      'cityId': new FormControl(this.avio.cityDTO.id)
    });
  }

  onToggleAvioInfo() {
    this.showEditAvioInfo = !this.showEditAvioInfo;
  }

  onToggleDestinations() {
    this.showDestinations = !this.showDestinations;

    if (!this.avio.destinations) {
      this.avioService.getAviosDestinations(this.avio.id).subscribe(
        data => {
          this.avio.destinations = data;
          this.formatCCStructure();
        },  
        error => console.log(error)
          
      );
    }
  }

  // metoda se poziva svaki put kad se promeni selekcija u html selektru za Country
	onChangeCountry(event) {
		const selectedCountryId = event.target.value;
		this.getCities(selectedCountryId);

  }
  

  // uzima i dodeljuje vrednost listi gradova koja se trenutno prikazuje u formi
	getCities(id) {
		
		this.countryService.getCountysCities(id).subscribe(
			(data) => {
				this.cityList = data;
			},
			(error) => console.log(error)
		);
  }

  
  
  onSubmitEditAvioInfo() {
    console.log(this.avioInfoForm);
  }

  onNewDestination() {
    this.showNewDestinationDialog = true;
  }

  onCloseAddDestination() {
    this.showNewDestinationDialog = false;
  }

  destinationSubmitted(dest) {
    this.avio.destinations.push(dest);
    this.formatCCStructure();
    this.showNewDestinationDialog = false;

  }

  formatCCStructure() {

    this.destCountries = [];

    for(let city of this.avio.destinations) {
      
      let match = false;
      for (let country of this.destCountries) {
        if (country.id === city.countryDTO.id) {
        
            country.cities.push(city);
            match = true;
            break;
        }
      }

      if (!match) {
        city.countryDTO.cities = [];
        city.countryDTO.cities.push(city);
        this.destCountries.push(city.countryDTO);
      }


    }

    console.log(this.destCountries);


  }


}
