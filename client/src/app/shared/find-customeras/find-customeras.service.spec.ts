import { TestBed, inject } from '@angular/core/testing';

import { FindCustomerasService } from './find-customeras.service';

describe('FindCustomerasService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FindCustomerasService]
    });
  });

  it('should be created', inject([FindCustomerasService], (service: FindCustomerasService) => {
    expect(service).toBeTruthy();
  }));
});
