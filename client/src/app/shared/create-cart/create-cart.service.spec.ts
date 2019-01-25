import { TestBed, inject } from '@angular/core/testing';

import { CreateCartService } from './create-cart.service';

describe('CreateCartService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CreateCartService]
    });
  });

  it('should be created', inject([CreateCartService], (service: CreateCartService) => {
    expect(service).toBeTruthy();
  }));
});
