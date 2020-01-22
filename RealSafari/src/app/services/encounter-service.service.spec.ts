import { TestBed } from '@angular/core/testing';

import { CatchServiceService } from './encounter-service.service';

describe('CatchServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CatchServiceService = TestBed.get(CatchServiceService);
    expect(service).toBeTruthy();
  });
});
