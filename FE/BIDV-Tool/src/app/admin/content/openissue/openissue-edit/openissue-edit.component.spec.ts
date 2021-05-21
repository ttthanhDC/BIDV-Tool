import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OpenissueEditComponent } from './openissue-edit.component';

describe('OpenissueEditComponent', () => {
  let component: OpenissueEditComponent;
  let fixture: ComponentFixture<OpenissueEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OpenissueEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OpenissueEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
