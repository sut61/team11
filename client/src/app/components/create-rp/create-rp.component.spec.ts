import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateRpComponent } from './create-rp.component';

describe('CreateRpComponent', () => {
  let component: CreateRpComponent;
  let fixture: ComponentFixture<CreateRpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateRpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateRpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
