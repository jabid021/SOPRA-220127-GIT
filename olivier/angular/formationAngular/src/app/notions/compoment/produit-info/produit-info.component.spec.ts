import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProduitInfoComponent } from './produit-info.component';

describe('ProduitInfoComponent', () => {
  let component: ProduitInfoComponent;
  let fixture: ComponentFixture<ProduitInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProduitInfoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProduitInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
