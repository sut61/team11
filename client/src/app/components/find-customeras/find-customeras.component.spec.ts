import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindCustomerasComponent } from './find-customeras.component';

describe('FindCustomerasComponent', () => {
  let component: FindCustomerasComponent;
  let fixture: ComponentFixture<FindCustomerasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindCustomerasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindCustomerasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
