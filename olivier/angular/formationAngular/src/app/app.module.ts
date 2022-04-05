import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FirstComponent } from './notions/first/first.component';
import { EditComponent } from './exercices/component/produit/edit/edit.component';
import { CouleurComponent } from './exercices/component/couleur/couleur.component';
import { ShowComponent } from './exercices/component/produit/show/show.component';
import { ProduitComponent } from './exercices/component/produit/produit/produit.component';

@NgModule({
  declarations: [AppComponent, FirstComponent, EditComponent, CouleurComponent, ShowComponent, ProduitComponent],
  imports: [BrowserModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
