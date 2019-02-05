import { Component, OnInit, Output, EventEmitter, HostListener, Input } from '@angular/core';
import { NgForm, FormGroup, FormControl } from '@angular/forms';
import { ActivatedRoute, Params } from '@angular/router';
import { identifierModuleUrl } from '@angular/compiler';
import { RentACar } from 'src/app/model/rentacar';
import { RentService } from 'src/app/services/rentacar.service';
import { DataService } from 'src/app/services/data.service';
import { CountryService } from 'src/app/services/country.service';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-branch-form',
  templateUrl: './branch-form.component.html',
  styleUrls: ['./branch-form.component.css']
})
export class BranchFormComponent implements OnInit {
  id: number;
  rent: any;
  ID: string;
  countryList: any = [];
  cityList: any = [];
  
  @Output() branchSubmit = new EventEmitter();
  @Input() closed: Subject<boolean>;
  
  
  branch: any = null;

  //two-way binding atributi
  address: string = '';
  selectedCountry: Number = 0;
  selectedCity: Number = 0;

  constructor(private countryService: CountryService,private service: RentService,private route: ActivatedRoute, private dataService: DataService) {
    this.route.params.subscribe(
      (params: Params) => {
        //uzmi id rent-a-car servisa iz putanje
        this.id = +params['id'];
      }
    ); 
  }

  ngOnInit() {
    this.dataService.edit.subscribe(data => this.ID = data); //subscribe na edit (cuva info da li se radi edit ili ne)

  
    //ako je zatvorena forma i nisu uradjene promene nakon edita mora se osveziti model
    this.closed.subscribe( value =>{
      if(value == true){
        this.branch = null;
        this.dataService.changeID(undefined);
      }
    })
    this.countryService.getCountries().subscribe(
      (data) =>{
        this.countryList = data;
      },
      (error) => console.log(error)
    );

    //ako je pritisnut edit onda popuni model kako bi se prikazale informacije u formi
    if(this.ID !== undefined && this.ID !== ""){
      this.service.getBranchOffice(+this.ID).subscribe(
        (data) => {
          this.branch = data;
          // let id_country = data.cityDTO.countryDTO.id;
          // this.selectedCountry = id_country;
          // let id_city = data.cityDTO.id;
          // this.selectedCity = id_city;
          this.fillForm();
        }
      );
    }
  }

  fillForm(){
    this.getCities(this.branch.cityDTO.countryDTO.id);
    this.address = this.branch.address;
    this.selectedCountry = this.branch.cityDTO.countryDTO.id;
    this.selectedCity = this.branch.cityDTO.id;
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

  onSubmitBranch(form: NgForm){
    const address =  form.value.address;
    // uzmi index iz liste na osnovu selektovanog id-a u html selectu
		let cityIndex = this.cityList.findIndex(city => city.id == this.selectedCity);
    const cityDTO = this.cityList[cityIndex];
    
    var branch = {
      address: this.address,
      cityDTO: cityDTO
    }
    if(this.ID !== undefined && this.ID !== ""){
      var branchTemp = {
        id: +this.ID,
        address: this.address,
        cityDTO: cityDTO
      }
      this.service.editBranchOffice(branchTemp,this.id).subscribe(
        (response) => {
          this.branchSubmit.emit(response);
          this.ngOnDestroy();
        },
        (error) => {alert(error); return;} 
      )
    }else{
      this.service.addBranchOffice(branch,this.id).subscribe(
        (response) => {
          this.branchSubmit.emit(response);
          this.ngOnDestroy();
        },
        (error) => swal("Error", "error")
      );
    }
    form.reset();
  }

  onReset(form: NgForm){
    form.reset();
  }

  ngOnDestroy(){
    this.branchSubmit.unsubscribe();
  }

 
}
