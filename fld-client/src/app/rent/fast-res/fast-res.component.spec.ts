import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FastResComponent } from './fast-res.component';

describe('FastResComponent', () => {
  let component: FastResComponent;
  let fixture: ComponentFixture<FastResComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FastResComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FastResComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
