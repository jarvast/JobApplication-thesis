import { TestBed, inject } from '@angular/core/testing';

import { RatingsService } from './ratings.service';

describe('RatingsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RatingsService]
    });
  });

  it('should be created', inject([RatingsService], (service: RatingsService) => {
    expect(service).toBeTruthy();
  }));
});
