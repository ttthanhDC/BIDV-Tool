import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetOprByServiceComponent } from './get-opr-by-service.component';

describe('GetOprByServiceComponent', () => {
  let component: GetOprByServiceComponent;
  let fixture: ComponentFixture<GetOprByServiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetOprByServiceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetOprByServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
