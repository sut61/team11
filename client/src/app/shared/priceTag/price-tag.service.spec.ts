import { TestBed, inject } from '@angular/core/testing';

import { PriceTagService } from './price-tag.service';

describe('PriceTagService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PriceTagService]
    });
  });

  it('should be created', inject([PriceTagService], (service: PriceTagService) => {
    expect(service).toBeTruthy();
  }));
});
