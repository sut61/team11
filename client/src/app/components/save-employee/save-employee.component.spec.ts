import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SaveEmployeeComponent } from './save-employee.component';

describe('SaveEmployeeComponent', () => {
  let component: SaveEmployeeComponent;
  let fixture: ComponentFixture<SaveEmployeeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SaveEmployeeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SaveEmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
