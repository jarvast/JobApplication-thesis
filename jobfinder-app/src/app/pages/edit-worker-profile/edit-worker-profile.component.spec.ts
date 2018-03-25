import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditWorkerProfileComponent } from './edit-worker-profile.component';

describe('EditWorkerProfileComponent', () => {
  let component: EditWorkerProfileComponent;
  let fixture: ComponentFixture<EditWorkerProfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditWorkerProfileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditWorkerProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
