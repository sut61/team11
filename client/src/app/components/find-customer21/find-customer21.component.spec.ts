import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindCustomer21Component } from './find-customer21.component';

describe('FindCustomer21Component', () => {
  let component: FindCustomer21Component;
  let fixture: ComponentFixture<FindCustomer21Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindCustomer21Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindCustomer21Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
