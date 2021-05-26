import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetServiceByAppComponent } from './get-service-by-app.component';

describe('GetServiceByAppComponent', () => {
  let component: GetServiceByAppComponent;
  let fixture: ComponentFixture<GetServiceByAppComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetServiceByAppComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetServiceByAppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
