import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RpfindEmpComponent } from './rpfind-emp.component';

describe('RpfindEmpComponent', () => {
  let component: RpfindEmpComponent;
  let fixture: ComponentFixture<RpfindEmpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RpfindEmpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RpfindEmpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
