import { TestBed, inject } from '@angular/core/testing';

import { RpfindEmpService } from './rpfind-emp.service';

describe('RpfindEmpService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RpfindEmpService]
    });
  });

  it('should be created', inject([RpfindEmpService], (service: RpfindEmpService) => {
    expect(service).toBeTruthy();
  }));
});
