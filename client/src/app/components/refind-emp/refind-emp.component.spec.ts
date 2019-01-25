import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RefindEmpComponent } from './refind-emp.component';

describe('RefindEmpComponent', () => {
  let component: RefindEmpComponent;
  let fixture: ComponentFixture<RefindEmpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RefindEmpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RefindEmpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
