import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OpenissueAddComponent } from './openissue-add.component';

describe('OpenissueAddComponent', () => {
  let component: OpenissueAddComponent;
  let fixture: ComponentFixture<OpenissueAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OpenissueAddComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OpenissueAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
