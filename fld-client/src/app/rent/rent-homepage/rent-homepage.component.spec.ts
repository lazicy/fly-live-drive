import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RentHomepageComponent } from './rent-homepage.component';

describe('RentHomepageComponent', () => {
  let component: RentHomepageComponent;
  let fixture: ComponentFixture<RentHomepageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RentHomepageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RentHomepageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
