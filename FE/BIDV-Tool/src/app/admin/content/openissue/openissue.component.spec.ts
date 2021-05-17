import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OpenissueComponent } from './openissue.component';

describe('OpenissueComponent', () => {
  let component: OpenissueComponent;
  let fixture: ComponentFixture<OpenissueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OpenissueComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OpenissueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
