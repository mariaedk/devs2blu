import { TestBed } from '@angular/core/testing';

import { ApiViaCepService } from './api-via-cep.service';

describe('ApiViaCepService', () => {
  let service: ApiViaCepService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApiViaCepService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
