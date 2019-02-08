import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewListReportComponent } from './view-list-report.component';

describe('ViewListReportComponent', () => {
  let component: ViewListReportComponent;
  let fixture: ComponentFixture<ViewListReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewListReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewListReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
