import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FastResVehicleComponent } from './fast-res-vehicle.component';

describe('FastResVehicleComponent', () => {
  let component: FastResVehicleComponent;
  let fixture: ComponentFixture<FastResVehicleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FastResVehicleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FastResVehicleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
