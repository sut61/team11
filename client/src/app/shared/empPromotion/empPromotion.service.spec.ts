import { TestBed, inject } from '@angular/core/testing';

import { EmpPromotionService } from './empPromotion.service';

describe('EmpPromotionService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EmpPromotionService]
    });
  });

  it('should be created', inject([EmpPromotionService], (service: EmpPromotionService) => {
    expect(service).toBeTruthy();
  }));
});
