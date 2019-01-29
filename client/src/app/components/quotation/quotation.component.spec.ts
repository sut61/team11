import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QUOTATIONComponent } from './quotation.component';

describe('QUOTATIONComponent', () => {
  let component: QUOTATIONComponent;
  let fixture: ComponentFixture<QUOTATIONComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QUOTATIONComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QUOTATIONComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
