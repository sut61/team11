import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SaveSaleitemComponent } from './save-saleitem.component';

describe('SaveSaleitemComponent', () => {
  let component: SaveSaleitemComponent;
  let fixture: ComponentFixture<SaveSaleitemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SaveSaleitemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SaveSaleitemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
