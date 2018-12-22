import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RentAdminComponent } from './rent-admin.component';

describe('RentAdminComponent', () => {
  let component: RentAdminComponent;
  let fixture: ComponentFixture<RentAdminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RentAdminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RentAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
