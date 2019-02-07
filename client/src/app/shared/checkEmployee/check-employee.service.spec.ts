import { TestBed, inject } from '@angular/core/testing';

import { CheckEmployeeService } from './check-employee.service';

describe('CheckEmployeeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CheckEmployeeService]
    });
  });

  it('should be created', inject([CheckEmployeeService], (service: CheckEmployeeService) => {
    expect(service).toBeTruthy();
  }));
});
