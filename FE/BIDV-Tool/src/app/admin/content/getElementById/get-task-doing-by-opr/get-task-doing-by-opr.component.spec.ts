import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetTaskDoingByOprComponent } from './get-task-doing-by-opr.component';

describe('GetTaskDoingByOprComponent', () => {
  let component: GetTaskDoingByOprComponent;
  let fixture: ComponentFixture<GetTaskDoingByOprComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetTaskDoingByOprComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetTaskDoingByOprComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
