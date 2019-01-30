import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindEmployeeComponent } from './find-employee.component';

describe('FindEmployeeComponent', () => {
  let component: FindEmployeeComponent;
  let fixture: ComponentFixture<FindEmployeeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindEmployeeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindEmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
