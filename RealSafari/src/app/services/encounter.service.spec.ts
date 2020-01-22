import { TestBed } from '@angular/core/testing';

import { EncounterService } from './encounter.service';

describe('CatchServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EncounterService = TestBed.get(EncounterService);
    expect(service).toBeTruthy();
  });
});
