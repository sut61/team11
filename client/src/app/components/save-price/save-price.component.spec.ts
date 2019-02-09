import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SavePriceComponent } from './save-price.component';

describe('SavePriceComponent', () => {
  let component: SavePriceComponent;
  let fixture: ComponentFixture<SavePriceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SavePriceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SavePriceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
