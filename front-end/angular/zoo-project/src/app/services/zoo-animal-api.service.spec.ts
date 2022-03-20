import { TestBed } from '@angular/core/testing';

import { ZooAnimalApiService } from './zoo-animal-api.service';

describe('ZooAnimalApiService', () => {
  let service: ZooAnimalApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ZooAnimalApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
