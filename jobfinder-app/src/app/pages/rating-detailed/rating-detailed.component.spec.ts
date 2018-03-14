import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RatingDetailedComponent } from './rating-detailed.component';

describe('RatingDetailedComponent', () => {
  let component: RatingDetailedComponent;
  let fixture: ComponentFixture<RatingDetailedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RatingDetailedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RatingDetailedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
