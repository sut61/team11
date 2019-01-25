import { TestBed, inject } from '@angular/core/testing';

import { RefindCartService } from './refind-cart.service';

describe('RefindCartService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RefindCartService]
    });
  });

  it('should be created', inject([RefindCartService], (service: RefindCartService) => {
    expect(service).toBeTruthy();
  }));
});
