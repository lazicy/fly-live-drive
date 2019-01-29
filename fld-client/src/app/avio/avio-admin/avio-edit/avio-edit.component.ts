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
  showFlights: boolean = false;

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

    // needs to be fixed!
    if (!this.avio.destinations) {
      this.fetchDestinations();
    }
  }

  onToggleFlights() {
    this.showFlights = !this.showFlights;
  }

  fetchDestinations() {
    this.avioService.getAviosDestinations(this.avio.id).subscribe(
      data => {
        this.avio.destinations = data;
        this.destCountries = this.countryService.formatCCStructure(this.avio.destinations);
      },  
      error => console.log(error)
        
    );
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

    let cityIndex = this.countryService.findCityIndex(this.avioInfoForm.value.cityId, this.cityList); 
		const cityDTO = this.cityList[cityIndex];
		
		let avio = {
      id: this.avio.id,
			name: this.avioInfoForm.value.name,
			address: this.avioInfoForm.value.address,
			cityDTO: cityDTO,
			map: this.avioInfoForm.value.map,
			description: this.avioInfoForm.value.description
    }
    
    this.avioService.updateAvio(avio).subscribe(
      (response) => {
        swal({title: "Success!", text: "Avio company " + this.avio.name + " updated.", icon: "success", timer: 1000});
        this.avio = response;
        this.fetchDestinations();
      }, (error) => {
        {swal ( "Error occured" ,  "The company was not updated." ,  "error" );}
      }
    );

  }

  onRestoreAvioInfo() {
    this.avioInfoForm = new FormGroup({
      'name': new FormControl(this.avio.name),
      'address': new FormControl(this.avio.address),
      'map': new FormControl(this.avio.map),
      'description': new FormControl(this.avio.description),
      'countryId': new FormControl(this.avio.cityDTO.countryDTO.id),
      'cityId': new FormControl(this.avio.cityDTO.id)
    });
  }

  onNewDestination() {
    this.showNewDestinationDialog = true;
  }

  onCloseAddDestination() {
    this.showNewDestinationDialog = false;
  }

  destinationSubmitted(dest) {
    this.avio.destinations.push(dest);
    this.destCountries = this.countryService.formatCCStructure(this.avio.destinations);
    this.showNewDestinationDialog = false;

  }

  onNewFlight() {
    // to be implemented
  }

  


}
