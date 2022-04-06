import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActiviteListComponent } from './activite.list.component';

describe('ListComponent', () => {
  let component: ActiviteListComponent;
  let fixture: ComponentFixture<ActiviteListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ActiviteListComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ActiviteListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
