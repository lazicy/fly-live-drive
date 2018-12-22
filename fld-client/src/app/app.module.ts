import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { AgmCoreModule } from '@agm/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { TestComponent } from './test/test.component';
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
import { HotelListComponent } from './hotel/hotel-list/hotel-list.component';
import { HotelPageComponent } from './hotel/hotel-page/hotel-page.component';
import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { AvioAdminComponent } from './avio/avio-admin/avio-admin.component';
import { AvioFormComponent } from './avio/avio-admin/avio-form/avio-form.component';
import { HotelHomepageComponent } from './hotel/hotel-homepage/hotel-homepage.component';
import { HotelFormComponent } from './hotel/hotel-form/hotel-form.component';
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

@NgModule({
  declarations: [
    AppComponent,
    TestComponent,
    AvioComponent,
    HeaderComponent,
    AviolistComponent,
    AvioProfileComponent,
    LoadingDirective,
    HotelComponent,
    HotelListComponent,
    HotelComponent,
    HotelListComponent,
    HotelPageComponent,
    LoginComponent,
    SignUpComponent,
    AvioAdminComponent,
    AvioFormComponent,
    HotelHomepageComponent,
    HotelFormComponent,
    HotelAdminComponent,
    VerifyMailComponent,
    RentComponent,
    RentHomepageComponent,
    RentAdminComponent,
    RentFormComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AngularFontAwesomeModule,
    AppRoutingModule,
    AgmCoreModule.forRoot({
      apiKey: ''
    }),
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [AvioService, FlightService, HotelService, UserService, RentService, AuthService,
              {provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true},
             //{provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
