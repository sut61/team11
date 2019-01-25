import { TestBed, inject } from '@angular/core/testing';

import { FindCustomerService } from './find-customer.service';

describe('FindCustomerService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FindCustomerService]
    });
  });

  it('should be created', inject([FindCustomerService], (service: FindCustomerService) => {
    expect(service).toBeTruthy();
  }));
});
