import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewCartItemComponent } from './view-cart-item.component';

describe('ViewCartItemComponent', () => {
  let component: ViewCartItemComponent;
  let fixture: ComponentFixture<ViewCartItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewCartItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewCartItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
