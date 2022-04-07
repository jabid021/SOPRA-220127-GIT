import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormPiloteCodeComponent } from './form-pilote-code.component';

describe('FormPiloteCodeComponent', () => {
  let component: FormPiloteCodeComponent;
  let fixture: ComponentFixture<FormPiloteCodeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormPiloteCodeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormPiloteCodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
