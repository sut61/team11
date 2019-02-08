import { TestBed, inject } from '@angular/core/testing';

import { UsedItemService } from './used-item.service';

describe('UsedItemService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UsedItemService]
    });
  });

  it('should be created', inject([UsedItemService], (service: UsedItemService) => {
    expect(service).toBeTruthy();
  }));
});
