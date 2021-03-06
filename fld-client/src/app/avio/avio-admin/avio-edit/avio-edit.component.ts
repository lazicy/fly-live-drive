import { Component, OnInit, ViewChild, OnDestroy } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { AvioService } from 'src/app/services/avio.service';
import { FlightService } from 'src/app/services/flight.service';
import { CountryService } from 'src/app/services/country.service';
import { NgForm, FormGroup, FormControl, Validators } from '@angular/forms';
import { Subscription } from 'rxjs';
@Component({
  selector: 'app-avio-edit',
  templateUrl: './avio-edit.component.html',
  styleUrls: ['./avio-edit.component.css']
})
export class AvioEditComponent implements OnInit, OnDestroy {
  
  // properties
  avio: any = null;
  id: number;
	countryList: any = [];
  cityList: any = [];
  
  destinations: any = [];
  destCountries: any = [];
  
  // show-hides
  showEditAvioInfo: boolean = false;
  showDestinations: boolean = false;
  showNewDestinationDialog: boolean = false;
  showFlights: boolean = false;
  cityValid: boolean = true;

  // form
  avioInfoForm: FormGroup;

  // subscription for countriesList (beeing destroyed)
  subscription: Subscription;

  constructor(private route: ActivatedRoute, private router: Router, private avioService: AvioService, private flightService: FlightService, private countryService: CountryService) { 
   

		// getting route params, params is observable that unsubscribes automatically
		this.route.params.subscribe(
			(params: Params) => {
				this.id = +params['id'];
			}
    );
    
    // avoiding sending multiple requests to the server, instead if it's initialized get's the value, if not whaits for countries loaded event to pop up and subscribes to it => getting countryList anyway
    this.countryList = this.countryService.getCountryList();
    this.subscription = this.countryService.countriesLoaded.subscribe(
      (countryList) => {
        this.countryList = countryList;
        
      }
    );
  }

  ngOnInit() {
   
    if (this.id !== NaN && this.id !== undefined) {
			this.avioService.getAvio(this.id).subscribe(
				(data) => {
          this.avio = data;
          
          this.fetchDestinations();
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
      'name': new FormControl(this.avio.name, Validators.required),
      'address': new FormControl(this.avio.address),
      'map': new FormControl(this.avio.map),
      'description': new FormControl(this.avio.description),
      'countryId': new FormControl(this.avio.cityDTO.countryDTO.id),
      'cityId': new FormControl(this.avio.cityDTO.id, Validators.required)
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
        // just a reference for a better comparison
        this.destinations = this.avio.destinations;
        this.destCountries = this.countryService.formatCCStructure(this.avio.destinations);
      },  
      error => console.log(error)
        
    );
  }

  // metoda se poziva svaki put kad se promeni selekcija u html selektru za Country
	onChangeCountry() {
    this.avioInfoForm.value.cityId = undefined;
		this.getCities(this.avioInfoForm.value.countryId);

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
    this.cityValid = true;
     console.log(this.avioInfoForm);

     if (this.avioInfoForm.value.cityId === undefined) {
       this.cityValid = false;
     } else {
       
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

    if (this.destinations.length < 2) {
      {swal ( "Not enough destinations" ,  "The avio company has less than 2 destinations." ,  "error" );}
    } else {

      this.router.navigate(['avio/admin/' + this.avio.id + "/flight/new"]);
    }
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

  // getters for the form validation
  get name() { return this.avioInfoForm.get('name'); }

  


}
