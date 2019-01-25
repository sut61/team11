import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewListItemComponent } from './view-list-item.component';

describe('ViewListItemComponent', () => {
  let component: ViewListItemComponent;
  let fixture: ComponentFixture<ViewListItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewListItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewListItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
