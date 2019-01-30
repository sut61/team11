import { TestBed, inject } from '@angular/core/testing';

import { ViewCartItemService } from './view-cart-item.service';

describe('ViewCartItemService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ViewCartItemService]
    });
  });

  it('should be created', inject([ViewCartItemService], (service: ViewCartItemService) => {
    expect(service).toBeTruthy();
  }));
});
