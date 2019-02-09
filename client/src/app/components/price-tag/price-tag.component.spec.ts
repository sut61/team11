import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PriceTagComponent } from './price-tag.component';

describe('PriceTagComponent', () => {
  let component: PriceTagComponent;
  let fixture: ComponentFixture<PriceTagComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PriceTagComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PriceTagComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
