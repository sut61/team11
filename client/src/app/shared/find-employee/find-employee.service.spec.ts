import { TestBed, inject } from '@angular/core/testing';

import { FindEmployeeService } from './find-employee.service';

describe('FindEmployeeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FindEmployeeService]
    });
  });

  it('should be created', inject([FindEmployeeService], (service: FindEmployeeService) => {
    expect(service).toBeTruthy();
  }));
});
