import { TestBed, inject } from '@angular/core/testing';

import { CreateReceiptService } from './create-receipt.service';

describe('CreateReceiptService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CreateReceiptService]
    });
  });

  it('should be created', inject([CreateReceiptService], (service: CreateReceiptService) => {
    expect(service).toBeTruthy();
  }));
});
