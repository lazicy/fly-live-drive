import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AvioComponent } from './avio/avio.component';
import { AppRoutingModule } from './app-routing.module';
import { HeaderComponent } from './header/header.component';
import { AviolistComponent } from './avio/aviolist/aviolist.component';
import { AvioService } from './services/avio.service';
import { FlightService } from './services/flight.service';

import { AvioProfileComponent } from './avio/avio-profile/avio-profile.component';
import { LoadingDirective } from './directives/loading.directive';
import { HotelComponent } from './hotel/hotel.component';
import { HotelService } from './services/hotel.service';
import { HotelPageComponent } from './hotel/hotel-page/hotel-page.component';
import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { AvioAdminComponent } from './avio/avio-admin/avio-admin.component';
import { HotelHomepageComponent } from './hotel/hotel-homepage/hotel-homepage.component';
import { HotelAdminComponent } from './hotel/hotel-admin/hotel-admin.component';
import { VerifyMailComponent } from './verify-mail/verify-mail.component';
import { UserService } from './services/user.service';
import { RentService } from './services/rentacar.service';
import { AuthService } from './services/auth.service';
import { JwtInterceptor } from './_helpers/jwt.interceptor';
import { ErrorInterceptor } from './_helpers/error.interceptor';
import { RentComponent } from './rent/rent.component';
import { RentHomepageComponent } from './rent/rent-homepage/rent-homepage.component';
import { RentAdminComponent } from './rent/rent-admin/rent-admin.component';
import { RentFormComponent } from './rent/rent-form/rent-form.component';
import { SystemAdminComponent } from './system-admin/system-admin.component';
import { SysHotelAdminComponent } from './system-admin/sys-hotel-admin/sys-hotel-admin.component';
import { SysAvioAdminComponent } from './system-admin/sys-avio-admin/sys-avio-admin.component';
import { SysCarAdminComponent } from './system-admin/sys-car-admin/sys-car-admin.component';
import { SysCarFormComponent } from './system-admin/sys-car-admin/sys-car-form/sys-car-form.component';
import { SysAvioFormComponent } from './system-admin/sys-avio-admin/sys-avio-form/sys-avio-form.component';
import { SysHotelFormComponent } from './system-admin/sys-hotel-admin/sys-hotel-form/sys-hotel-form.component';
import { SysUsersComponent } from './system-admin/sys-users/sys-users.component';
import { CountryService } from './services/country.service';
import { AviolistAdminComponent } from './avio/avio-admin/aviolist-admin/aviolist-admin.component';
import { AvioEditComponent } from './avio/avio-admin/avio-edit/avio-edit.component';
import { AddDestinationComponent } from './avio/avio-admin/avio-edit/add-destination/add-destination.component';
import { FlightlistAdminComponent } from './avio/avio-admin/avio-edit/flightlist-admin/flightlist-admin.component';
import { FlightFormComponent } from './avio/avio-admin/flight-form/flight-form.component';
import { RentListComponent } from './rent/rent-list/rent-list.component';
import { BranchesComponent } from './rent/rent-admin/branches/branches.component';
import { DataService } from './services/data.service';
import { VehiclesComponent } from './rent/rent-admin/branches/vehicles/vehicles.component';
import { RentProfileComponent } from './rent/rent-profile/rent-profile.component';
import { SeatsEditComponent } from './avio/avio-admin/flight-form/seats-edit/seats-edit.component';
import { FlightlistComponent } from './avio/avio-profile/flightlist/flightlist.component';
import { VehicleFormComponent } from './rent/rent-admin/branches/vehicles/vehicle-form/vehicle-form.component';
import { BranchFormComponent } from './rent/rent-admin/branches/branch-form/branch-form.component';
import { VehicleListComponent } from './rent/vehicle-list/vehicle-list.component';
import { VehicleSearchComponent } from './rent/vehicle-list/vehicle-search/vehicle-search.component';
import { UtilService } from './services/util.service';
import { AvioHomepageComponent } from './avio/avio-homepage/avio-homepage.component';
import { FlightlistSearchComponent } from './avio/flightlist-search/flightlist-search.component';
import { AvioReservationComponent } from './avio/avio-reservation/avio-reservation.component';
import { ReservationFlightService } from './services/reservation-flight.service';
import { AddServiceComponent } from './hotel/hotel-admin/add-service/add-service.component';
import { EditServiceComponent } from './hotel/hotel-admin/edit-service/edit-service.component';
import { AddRoomComponent } from './hotel/hotel-admin/add-room/add-room.component';
import { EditRoomComponent } from './hotel/hotel-admin/edit-room/edit-room.component';
import { BonusPointsService } from './services/bonus.service';
import { HotelBookComponent } from './hotel/hotel-book/hotel-book.component';
import { HomeComponent } from './home/home.component';
import { FirstLogComponent } from './home/first-log/first-log.component';
import { AddFastresComponent } from './hotel/hotel-admin/add-fastres/add-fastres.component';
import { SeatsSelectComponent } from './avio/avio-reservation/seats-select/seats-select.component';

@NgModule({
  declarations: [
    AppComponent,
    AvioComponent,
    HeaderComponent,
    AviolistComponent,
    AvioProfileComponent,
    LoadingDirective,
    HotelComponent,
    HotelPageComponent,
    LoginComponent,
    SignUpComponent,
    AvioAdminComponent,
    HotelHomepageComponent,
    HotelAdminComponent,
    VerifyMailComponent,
    RentComponent,
    RentHomepageComponent,
    RentAdminComponent,
    RentFormComponent,
    SystemAdminComponent,
    SysHotelAdminComponent,
    SysAvioAdminComponent,
    SysCarAdminComponent,
    SysCarFormComponent,
    SysAvioFormComponent,
    SysHotelFormComponent,
    SysUsersComponent,
    AviolistAdminComponent,
    AvioEditComponent,
    AddDestinationComponent,
    FlightlistAdminComponent,
    FlightFormComponent,
    RentListComponent,
    BranchesComponent,
    BranchFormComponent,
    VehiclesComponent,
    VehicleFormComponent,
    RentProfileComponent,
    SeatsEditComponent,
    FlightlistComponent,
    VehicleListComponent,
    VehicleSearchComponent,
    AvioHomepageComponent,
    FlightlistSearchComponent,
    AvioReservationComponent,
    AddServiceComponent,
    EditServiceComponent,
    AddRoomComponent,
    EditRoomComponent,
    HotelBookComponent,
    HomeComponent,
    FirstLogComponent,
    AddFastresComponent,
    SeatsSelectComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AngularFontAwesomeModule,
    AppRoutingModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [AvioService, FlightService, HotelService, UserService, RentService, AuthService, DataService, CountryService, UtilService, ReservationFlightService, BonusPointsService,
              {provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true}
             //{provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
