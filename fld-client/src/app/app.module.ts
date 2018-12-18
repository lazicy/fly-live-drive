import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { AgmCoreModule } from '@agm/core';

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
import { HotelListComponent } from './hotel/hotel-list/hotel-list.component';
import { HotelPageComponent } from './hotel/hotel-page/hotel-page.component';
import { AvioAdminComponent } from './avio/avio-admin/avio-admin.component';
import { AvioFormComponent } from './avio/avio-admin/avio-form/avio-form.component';
import { HotelHomepageComponent } from './hotel/hotel-homepage/hotel-homepage.component';
import { HotelFormComponent } from './hotel/hotel-form/hotel-form.component';
import { HotelAdminComponent } from './hotel/hotel-admin/hotel-admin.component';

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
    HotelListComponent,
    HotelComponent,
    HotelListComponent,
    HotelPageComponent,
    AvioAdminComponent,
    AvioFormComponent,
    HotelHomepageComponent,
    HotelFormComponent,
    HotelAdminComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AngularFontAwesomeModule,
    AppRoutingModule,
    AgmCoreModule.forRoot({
      apiKey: ''
    })
  ],
  providers: [AvioService, FlightService, HotelService],
  bootstrap: [AppComponent]
})
export class AppModule { }
