import { TestBed } from '@angular/core/testing';

import { OpenissueService } from './openissue.service';

describe('OpenissueService', () => {
  let service: OpenissueService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OpenissueService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
