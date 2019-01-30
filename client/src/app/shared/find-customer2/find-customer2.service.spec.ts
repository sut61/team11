import { TestBed, inject } from '@angular/core/testing';

import { FindCustomer2Service } from './find-customer2.service';

describe('FindCustomer2Service', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FindCustomer2Service]
    });
  });

  it('should be created', inject([FindCustomer2Service], (service: FindCustomer2Service) => {
    expect(service).toBeTruthy();
  }));
});
