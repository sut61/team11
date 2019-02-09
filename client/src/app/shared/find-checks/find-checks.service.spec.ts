import { TestBed, inject } from '@angular/core/testing';

import { FindChecksService } from './find-checks.service';

describe('FindChecksService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FindChecksService]
    });
  });

  it('should be created', inject([FindChecksService], (service: FindChecksService) => {
    expect(service).toBeTruthy();
  }));
});
