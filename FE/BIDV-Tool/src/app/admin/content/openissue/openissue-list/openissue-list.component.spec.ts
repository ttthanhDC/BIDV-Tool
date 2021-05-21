import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OpenissueListComponent } from './openissue-list.component';

describe('OpenissueListComponent', () => {
  let component: OpenissueListComponent;
  let fixture: ComponentFixture<OpenissueListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OpenissueListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OpenissueListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
