import { TestBed, inject } from '@angular/core/testing';

import { CreateRpService } from './create-rp.service';

describe('CreateRpService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CreateRpService]
    });
  });

  it('should be created', inject([CreateRpService], (service: CreateRpService) => {
    expect(service).toBeTruthy();
  }));
});
