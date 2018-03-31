import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WriteMessageDialogComponent } from './write-message-dialog.component';

describe('WriteMessageDialogComponent', () => {
  let component: WriteMessageDialogComponent;
  let fixture: ComponentFixture<WriteMessageDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WriteMessageDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WriteMessageDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
