import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemAddingComponent } from './item-adding.component';

describe('ItemAddingComponent', () => {
  let component: ItemAddingComponent;
  let fixture: ComponentFixture<ItemAddingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ItemAddingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ItemAddingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
