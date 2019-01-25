import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RefindCartComponent } from './refind-cart.component';

describe('RefindCartComponent', () => {
  let component: RefindCartComponent;
  let fixture: ComponentFixture<RefindCartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RefindCartComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RefindCartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
