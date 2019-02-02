import { TestBed, inject } from '@angular/core/testing';

import { SaveSaleitemService } from './save-saleitem.service';

describe('SaveSaleitemService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SaveSaleitemService]
    });
  });

  it('should be created', inject([SaveSaleitemService], (service: SaveSaleitemService) => {
    expect(service).toBeTruthy();
  }));
});
