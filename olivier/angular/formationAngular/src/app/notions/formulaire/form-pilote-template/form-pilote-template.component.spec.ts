import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormPiloteTemplateComponent } from './form-pilote-template.component';

describe('FormPiloteTemplateComponent', () => {
  let component: FormPiloteTemplateComponent;
  let fixture: ComponentFixture<FormPiloteTemplateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormPiloteTemplateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormPiloteTemplateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
