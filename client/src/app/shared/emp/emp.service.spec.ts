import { TestBed, inject,  } from '@angular/core/testing';

import { EmpService } from './emp.service';

describe('EmpService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EmpService]
    });
  });

  it('should be created', inject([EmpService], (service: EmpService) => {
    expect(service).toBeTruthy();
  }));
});

