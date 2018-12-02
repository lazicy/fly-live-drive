import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AvioComponent } from './avio/avio.component';
import { TestComponent } from './test/test.component';
import { AviolistComponent } from './avio/aviolist/aviolist.component';
import { AvioProfileComponent } from './avio/avio-profile/avio-profile.component';
import { RentAddComponent } from './rent/rent-add/rent-add.component';
import { HotelComponent } from './hotel/hotel.component';
import { AddHotelComponent } from './hotel/add-hotel/add-hotel.component';
import { HotelListComponent } from './hotel/hotel-list/hotel-list.component';
import { HotelPageComponent } from './hotel/hotel-page/hotel-page.component';
import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';


const appRoutes: Routes = [
	{ path: '', redirectTo: '/test', pathMatch: 'full'},
	{ path: 'test', component: TestComponent },
	{ path: 'avio', component: AvioComponent, children: [
		{ path: '', component: AviolistComponent},
		{ path: ':id', component: AvioProfileComponent}
	]},
	{ path: 'rent', component: RentAddComponent},
	{ path: 'hotel', component: HotelComponent, children: [
		{path: 'list', component: HotelListComponent, children: [
			{path: ':id', component: HotelPageComponent}
		]},
		{path: 'admin', component: AddHotelComponent}
	]},
	{path: 'login', component: LoginComponent },
	{path:'signup', component: SignUpComponent},
];


@NgModule({
	imports: [RouterModule.forRoot(appRoutes)],
	exports: [ RouterModule ]
})



export class AppRoutingModule { }
