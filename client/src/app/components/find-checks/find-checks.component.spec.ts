import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindChecksComponent } from './find-checks.component';

describe('FindChecksComponent', () => {
  let component: FindChecksComponent;
  let fixture: ComponentFixture<FindChecksComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindChecksComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindChecksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
