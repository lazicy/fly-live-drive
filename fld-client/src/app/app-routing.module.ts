import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AvioComponent } from './avio/avio.component';
import { AviolistComponent } from './avio/aviolist/aviolist.component';
import { AvioProfileComponent } from './avio/avio-profile/avio-profile.component';
import { HotelComponent } from './hotel/hotel.component';
import { HotelPageComponent } from './hotel/hotel-page/hotel-page.component';
import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { AvioAdminComponent } from './avio/avio-admin/avio-admin.component';
import { HotelHomepageComponent } from './hotel/hotel-homepage/hotel-homepage.component';
import { HotelAdminComponent } from './hotel/hotel-admin/hotel-admin.component';
import { VerifyMailComponent } from './verify-mail/verify-mail.component';
import { RentHomepageComponent } from './rent/rent-homepage/rent-homepage.component';
import { RentAdminComponent } from './rent/rent-admin/rent-admin.component';
import { RentComponent } from './rent/rent.component';
import { SysAvioAdminComponent } from './system-admin/sys-avio-admin/sys-avio-admin.component';
import { SystemAdminComponent } from './system-admin/system-admin.component';
import { SysAvioFormComponent } from './system-admin/sys-avio-admin/sys-avio-form/sys-avio-form.component';
import { SysHotelAdminComponent } from './system-admin/sys-hotel-admin/sys-hotel-admin.component';
import { SysHotelFormComponent } from './system-admin/sys-hotel-admin/sys-hotel-form/sys-hotel-form.component';
import { SysCarAdminComponent } from './system-admin/sys-car-admin/sys-car-admin.component';
import { SysCarFormComponent } from './system-admin/sys-car-admin/sys-car-form/sys-car-form.component';
import { SysUsersComponent } from './system-admin/sys-users/sys-users.component';
import { AvioEditComponent } from './avio/avio-admin/avio-edit/avio-edit.component';
import { AviolistAdminComponent } from './avio/avio-admin/aviolist-admin/aviolist-admin.component';
import { FlightFormComponent } from './avio/avio-admin/flight-form/flight-form.component';
import { RentListComponent } from './rent/rent-list/rent-list.component';
import { BranchesComponent } from './rent/rent-admin/branches/branches.component';
import { VehiclesComponent } from './rent/rent-admin/branches/vehicles/vehicles.component';
import { RentProfileComponent } from './rent/rent-profile/rent-profile.component';
import { SeatsEditComponent } from './avio/avio-admin/flight-form/seats-edit/seats-edit.component';
import { VehicleListComponent } from './rent/vehicle-list/vehicle-list.component';
import { VehicleSearchComponent } from './rent/vehicle-list/vehicle-search/vehicle-search.component';
import { AvioHomepageComponent } from './avio/avio-homepage/avio-homepage.component';
import { AvioReservationComponent } from './avio/avio-reservation/avio-reservation.component';
import { HotelBookComponent } from './hotel/hotel-book/hotel-book.component';
import { HomeComponent } from './home/home.component';
import { GlobalReservationOverviewComponent } from './global-reservation/global-reservation-overview/global-reservation-overview.component';
import { FastResComponent } from './rent/fast-res/fast-res.component';
import { FastResVehicleComponent } from './rent/fast-res/fast-res-vehicle/fast-res-vehicle.component';


const appRoutes: Routes = [
	{ path: '', redirectTo: '/home', pathMatch: 'full'},
	{ path: 'home', component: HomeComponent },
	{ path: 'globalreservation/:id', component: GlobalReservationOverviewComponent},
	{ path: 'avio', component: AvioComponent, children: [
		{ path: '', component: AvioHomepageComponent},
		{ path: 'admin', component: AvioAdminComponent, children: [
			{ path: '', component: AviolistAdminComponent },
			//{ path: ':aId/flight/', component: FlightFormComponent },
			{ path: ':aId/flight',  redirectTo: '/avio/admin', pathMatch: 'full' },
			
			{ path: ':aId/flight/:fId', component: FlightFormComponent },
			
			{ path: ':id', component: AvioEditComponent}
			
		]},
		{ path: 'reservation', component: AvioReservationComponent},
		{ path: ':id', component: AvioProfileComponent},
		{ path: 'list', component: AviolistComponent}
	]},
	{ path: 'rent', component: RentComponent, children: [
		{path: '', component: RentHomepageComponent},
		{path: 'list', component: RentListComponent},
		{path: ':id', component: RentProfileComponent},
		{path: 'rentAdmin/:id', component: RentAdminComponent, children:[
			{path: '', component: BranchesComponent},
			{path: ':idF', component: VehiclesComponent},
		]},
		{path:'fastRes/:id', component: FastResComponent, children:[
			{path:'', component: FastResVehicleComponent},
		]},
		{path: 'vehicles/:id', component: VehicleListComponent, children:[
			{path: '', component: VehicleSearchComponent}
		]}
	]},
	{ path: 'hotel', component: HotelComponent, children: [
		{ path: '', component: HotelHomepageComponent},
		{ path: 'admin/:idH', component: HotelAdminComponent},
		{ path: ':idh/book/:rid', component: HotelBookComponent},
		{ path: ':id', component: HotelPageComponent},
	]},
	{path: 'login', component: LoginComponent},
	{path:'signup', component: SignUpComponent},
	{path: 'verifymail', component: VerifyMailComponent},
	{path: 'systemadmin', component: SystemAdminComponent, children: [
		{ path: '', redirectTo: 'avio', pathMatch: 'full'},
		{ path: 'avio', component: SysAvioAdminComponent, children: [
			{ path: 'add', component: SysAvioFormComponent}
		]},
		{ path: 'hotels', component: SysHotelAdminComponent, children: [
			{ path: 'add', component: SysHotelFormComponent}
		]},
		{ path: 'rent', component: SysCarAdminComponent, children: [
			{ path: 'add', component: SysCarFormComponent}
		]},
		{ path: 'users', component: SysUsersComponent}
	]}
	]


@NgModule({
	imports: [RouterModule.forRoot(appRoutes)],
	exports: [ RouterModule ]
})



export class AppRoutingModule { }
