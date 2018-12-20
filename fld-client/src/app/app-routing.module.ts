import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AvioComponent } from './avio/avio.component';
import { TestComponent } from './test/test.component';
import { AviolistComponent } from './avio/aviolist/aviolist.component';
import { AvioProfileComponent } from './avio/avio-profile/avio-profile.component';
import { HotelComponent } from './hotel/hotel.component';
import { HotelListComponent } from './hotel/hotel-list/hotel-list.component';
import { HotelPageComponent } from './hotel/hotel-page/hotel-page.component';
import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { AvioAdminComponent } from './avio/avio-admin/avio-admin.component';
import { AvioFormComponent } from './avio/avio-admin/avio-form/avio-form.component';
import { HotelHomepageComponent } from './hotel/hotel-homepage/hotel-homepage.component';
import { HotelAdminComponent } from './hotel/hotel-admin/hotel-admin.component';
import { HotelFormComponent } from './hotel/hotel-form/hotel-form.component';
import { VerifyMailComponent } from './verify-mail/verify-mail.component';
import { RentAddComponent } from './rent/rent-admin/rent-add/rent-add.component';


const appRoutes: Routes = [
	{ path: '', redirectTo: '/test', pathMatch: 'full'},
	{ path: 'test', component: TestComponent },
	{ path: 'avio', component: AvioComponent, children: [
		{ path: '', component: AviolistComponent},
		{ path: 'admin', component: AvioAdminComponent, children: [
			{ path: 'new', component: AvioFormComponent}
		]},
		{ path: ':id', component: AvioProfileComponent}
	]},
	{ path: 'rent', component: RentAddComponent},
	{ path: 'hotel', component: HotelComponent, children: [
		{ path: '', component: HotelHomepageComponent},
		{ path: 'list', component: HotelListComponent},
		{ path: 'administrateHotels', component: HotelAdminComponent, children: [
			{ path: 'add', component: HotelFormComponent}
		]},
		{ path: ':id', component: HotelPageComponent}
	]},
		{path: 'login', component: LoginComponent},
		{path:'signup', component: SignUpComponent},
		{path: 'verifymail', component: VerifyMailComponent}
	]


@NgModule({
	imports: [RouterModule.forRoot(appRoutes)],
	exports: [ RouterModule ]
})



export class AppRoutingModule { }
