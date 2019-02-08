import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { HotelService } from 'src/app/services/hotel.service';
import { CountryService } from 'src/app/services/country.service';
import { NgForm, FormGroup, FormControl, Validators } from '@angular/forms';
import { Subscription } from 'rxjs';
//import { RoomService } from 'src/app/services/room.service';

@Component({
  selector: 'app-hotel-admin',
  templateUrl: './hotel-admin.component.html',
  styleUrls: ['./hotel-admin.component.css']
})
export class HotelAdminComponent implements OnInit {
  hotel: any = null;
  id: number;
  countryList: any = [];
  cityList: any = [];
  servToEdit: any = null;
  roomToEdit: any = null;
  fastRes: any = [];

  //show-hides
  showEditHotel: boolean = false;
  showServices: boolean = false;
  showNewServiceDialog: boolean = false;
  showUpdateServiceDialog: boolean = false;
  showNewRoomDialog: boolean = false;
  showUpdateRoomDialog: boolean = false;
  showFast: boolean = false;
  showRooms: boolean = false;
  showCharts: boolean = false;
  showAddFastDialog: boolean = false;

  cityValid: boolean = true;

  //form
  hotelForm: FormGroup;

  // subscription for countriesList (beeing destroyed)
  subscription: Subscription;

  constructor(private route: ActivatedRoute, private router: Router, private hotelService: HotelService, private countryService: CountryService) { //private roomService: RoomService
    
    // getting route params, params is observable that unsubscribes automatically
		this.route.params.subscribe(
			(params: Params) => {
				this.id = +params['idH'];
			}
    );
    
    // avoiding sending multiple requests to the server, instead if it's initialized get's the value, if not waits for countries loaded event to pop up and subscribes to it => getting countryList anyway
    this.countryList = this.countryService.getCountryList();
    this.subscription = this.countryService.countriesLoaded.subscribe(
      (countryList) => {
        this.countryList = countryList;
      }
    );
  }

  ngOnInit() {
    if (this.id !== NaN && this.id !== undefined) {
			this.hotelService.getHotel(this.id).subscribe(
				(data) => {
          this.hotel = data;
          this.fetchServices();
          this.fetchRooms();
          this.initHotelForm();
          this.fetchFastRes();
				},
				(error) => {
					console.log(error);
					if (error.status === 404) {
						this.router.navigate(['hotel']);
					} else {
						console.error(error);
					}
				}
      );
    }
    
  }

  fetchFastRes() {
    this.hotelService.getFastRes(this.id).subscribe(
      (data) => {
        this.fastRes = data;
      },
      (error) => {
        if (error.status === 404) {
          this.router.navigate(['hotel']);
        } else {
          console.error(error);
        }
      }
    );
  }

  initHotelForm() {

    this.getCities(this.hotel.cityDTO.countryDTO.id);
  
      this.hotelForm = new FormGroup({
        'name': new FormControl(this.hotel.name, Validators.required),
        'starsNo': new FormControl(this.hotel.stars),
        'address': new FormControl(this.hotel.address),
        'map': new FormControl(this.hotel.map),
        'description': new FormControl(this.hotel.description),
        'countryId': new FormControl(this.hotel.cityDTO.countryDTO.id),
        'cityId': new FormControl(this.hotel.cityDTO.id, Validators.required),
        'image': new FormControl(this.hotel.hotelImageURL)
      });
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

  onToggleEditHotel() {
    this.showEditHotel = !this.showEditHotel;
  }

  onToggleServices() {
    this.showServices = !this.showServices;

    if (!this.hotel.services) {
      this.fetchServices();
    }
  }

  onToggleRooms() {
    this.showRooms = !this.showRooms;
  }

  fetchServices() {
    this.hotelService.getHotelServices(this.hotel.id).subscribe(
      data => {
        this.hotel.services = data;
      },  
      error => console.log(error)
        
    );
  }

  fetchRooms() {
    this.hotelService.getHotelRooms(this.hotel.id).subscribe(
      data => {
        this.hotel.rooms = data;
      },  
      error => console.log(error)
        
    );
  }

  // metoda se poziva svaki put kad se promeni selekcija u html selektru za Country
	onChangeCountry() {
    this.hotelForm.value.cityId = undefined;
		this.getCities(this.hotelForm.value.countryId);

  }

  onRestoreHotelInfo() {
    this.hotelForm = new FormGroup({
      'name': new FormControl(this.hotel.name, Validators.required),
      'stars': new FormControl(this.hotel.stars),
      'address': new FormControl(this.hotel.address),
      'map': new FormControl(this.hotel.map),
      'description': new FormControl(this.hotel.description),
      'countryId': new FormControl(this.hotel.cityDTO.countryDTO.id),
      'cityId': new FormControl(this.hotel.cityDTO.id, Validators.required),
      'image': new FormControl(this.hotel.hotelImageURL)
    });
  }

  onSubmitEditHotel() {
    this.cityValid = true;
     console.log(this.hotelForm);

     if (this.hotelForm.value.cityId === undefined) {
       this.cityValid = false;
     } else {
       
       let cityIndex = this.countryService.findCityIndex(this.hotelForm.value.cityId, this.cityList); 
       const cityDTO = this.cityList[cityIndex];
       
       let hotel = {
        id: this.hotel.id,
        name: this.hotelForm.value.name,
        address: this.hotelForm.value.address,
        cityDTO: cityDTO,
        description: this.hotelForm.value.description,
        hotelImageURL: this.hotelForm.value.himageURL,
        map: this.hotelForm.value.map,
        stars: this.hotelForm.value.stars
       }
       
       this.hotelService.updateHotel(hotel).subscribe(
         (response) => {
           swal({title: "Success!", text: "Hotel " + this.hotel.name + " updated.", icon: "success", timer: 1000});
           this.hotel = response;
           this.fetchServices();
         }, (error) => {
           {swal ( "Error occured" ,  "The hotel was not updated." ,  "error" );}
         }
       );
     }
  }

  onNewService() {
    this.showNewServiceDialog = true;
  }

  onUpdateService(serv) {
    this.servToEdit = serv;
    this.showUpdateServiceDialog = true;
  }

  onCloseAddService() {
    this.showNewServiceDialog = false;
  }

  onCloseUpdateService() {
    this.showUpdateServiceDialog = false;
  }

  serviceSubmitted(serv) {
    this.hotel.services.push(serv);
    this.showNewServiceDialog = false;
  }

  
  serviceUpdated(serv) {
    let i = this.hotel.services.findIndex(service => service.id === serv.id);
    this.hotel.services.splice(i, 1, serv);
    this.showUpdateServiceDialog = false;
  }

  onNewRoom() {
    this.showNewRoomDialog = true;
  }

  onCloseAddRoom() {
    this.showNewRoomDialog = false;
  }

  roomSubmitted(r) {
    this.hotel.rooms.push(r);
    this.showNewRoomDialog = false;
  }

  onRemoveService(idSer) {
    swal({
      title: "Are you sure?",
      icon: "warning",
      buttons: ["Cancel", "Delete"],
      dangerMode: true,
    })
    .then((willDelete) => {
      if (willDelete) {
        this.hotelService.removeHotelService(idSer, this.id).subscribe(
          (result) => {
              let i = this.hotel.services.findIndex(service => service.id === idSer);
              this.hotel.services.splice(i, 1);
              swal({title: "Success!", text: "Service deleted.", icon: "success", timer: 1500});
          }, (error) =>  {swal ( "Error occured" ,  "The service was not deleted." ,  "error" );}
          );
      }
    });
  }

  onRemoveRoom(idRoom) {
    swal({
      title: "Are you sure?",
      icon: "warning",
      buttons: ["Cancel", "Delete"],
      dangerMode: true,
    })
    .then((willDelete) => {
      if (willDelete) {
        this.hotelService.removeHotelRoom(idRoom, this.id).subscribe(
          (result) => {
              let i = this.hotel.rooms.findIndex(room => room.id === idRoom);
              this.hotel.rooms.splice(i, 1);
              swal({title: "Success!", text: "Room deleted.", icon: "success", timer: 1500});
          }, (error) =>  {swal ( "Error occured" ,  "The room was not deleted." ,  "error" );}
          );
      }
    });
  }

  onUpdateRoom(rid) {
    this.roomToEdit = rid;
    this.showUpdateRoomDialog = true;
  }

  roomUpdated(r) {
    let i = this.hotel.rooms.findIndex(room => room.id === r.id);
    this.hotel.rooms.splice(i, 1, r);
    this.showUpdateRoomDialog = false;
  }

  onCloseUpdateRoom() {
    this.showUpdateRoomDialog = false;
  }

  onToggleCharts() {
    this.showCharts = !this.showCharts;
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

  onNewFast() {
    this.showAddFastDialog = true;
  }

  onCloseAddFast() {
    this.showAddFastDialog = false;
  }

  fastSubmit(fastrez) {
    this.showAddFastDialog = false;
  }

  // getters for the form validation
  get name() { return this.hotelForm.get('name'); }

}


