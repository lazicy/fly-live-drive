import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { TestComponent } from './test/test.component';
import { HttpClientModule } from '@angular/common/http';
import { AvioComponent } from './avio/avio.component';
import { AppRoutingModule } from './app-routing.module';
import { HeaderComponent } from './header/header.component';
import { AviolistComponent } from './avio/aviolist/aviolist.component';
import { AvioService } from './services/avio.service';
import { FlightService } from './services/flight.service';

import { AvioProfileComponent } from './avio/avio-profile/avio-profile.component';
import { LoadingDirective } from './directives/loading.directive';
import { RentAddComponent } from './rent/rent-add/rent-add.component';
import { HotelComponent } from './hotel/hotel.component';
import { HotelService } from './services/hotel.service';
import { AddHotelComponent } from './hotel/add-hotel/add-hotel.component';
import { HotelListComponent } from './hotel/hotel-list/hotel-list.component';
import { HotelPageComponent } from './hotel/hotel-page/hotel-page.component';
import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { AvioAdminComponent } from './avio/avio-admin/avio-admin.component';
import { AvioFormComponent } from './avio/avio-admin/avio-form/avio-form.component';
import { VerifyMailComponent } from './verify-mail/verify-mail.component';
import { UserService } from './services/user.service';
import { RentService } from './services/rentacar.service';

@NgModule({
  declarations: [
    AppComponent,
    TestComponent,
    AvioComponent,
    HeaderComponent,
    AviolistComponent,
    AvioProfileComponent,
    LoadingDirective,
    RentAddComponent,
    HotelComponent,
    AddHotelComponent,
    HotelListComponent,
    HotelComponent,
    AddHotelComponent,
    HotelListComponent,
    HotelPageComponent,
    LoginComponent,
    SignUpComponent,
    AvioAdminComponent,
    AvioFormComponent,
    VerifyMailComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [AvioService, FlightService, HotelService, UserService, RentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
