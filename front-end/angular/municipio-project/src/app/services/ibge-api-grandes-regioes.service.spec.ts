import { TestBed } from '@angular/core/testing';

import { IbgeApiGrandesRegioesService } from './ibge-api-grandes-regioes.service';

describe('IbgeApiGrandesRegioesService', () => {
  let service: IbgeApiGrandesRegioesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IbgeApiGrandesRegioesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
