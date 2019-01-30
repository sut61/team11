import { TestBed, inject } from '@angular/core/testing';

import { SaleItemService } from './sale-item.service';

describe('SaleItemService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SaleItemService]
    });
  });

  it('should be created', inject([SaleItemService], (service: SaleItemService) => {
    expect(service).toBeTruthy();
  }));
});
