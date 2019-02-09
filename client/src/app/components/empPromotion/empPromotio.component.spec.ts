import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpPromotionComponent } from './empPromotion.component';

describe('EmpPromotionComponent', () => {
  let component: EmpPromotionComponent;
  let fixture: ComponentFixture<EmpPromotionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmpPromotionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpPromotionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
