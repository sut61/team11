import { TestBed, inject } from '@angular/core/testing';

import { RefindEmpService } from './refind-emp.service';

describe('RefindEmpService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RefindEmpService]
    });
  });

  it('should be created', inject([RefindEmpService], (service: RefindEmpService) => {
    expect(service).toBeTruthy();
  }));
});
