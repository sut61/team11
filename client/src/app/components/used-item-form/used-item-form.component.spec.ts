import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UsedItemFormComponent } from './used-item-form.component';

describe('UsedItemFormComponent', () => {
  let component: UsedItemFormComponent;
  let fixture: ComponentFixture<UsedItemFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UsedItemFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsedItemFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
