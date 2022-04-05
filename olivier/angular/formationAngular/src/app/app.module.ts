import { routes } from './routes';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FirstComponent } from './notions/first/first.component';
import { EditComponent } from './exercices/component/produit/edit/edit.component';
import { CouleurComponent } from './exercices/component/couleur/couleur.component';
import { ShowComponent } from './exercices/component/produit/show/show.component';
import { ProduitComponent } from './exercices/component/produit/produit/produit.component';
import { VoteComponent } from './exercices/component/vote/vote.component';
import { CandidatComponent } from './exercices/component/candidat/candidat.component';
import { ListComponent } from './exercices/component/produit/list/list.component';
import { DemoDirective } from './notions/directive/demo.directive';
import { HighlightDirective } from './notions/directive/highlight.directive';
import { HomeComponent } from './notions/compoment/home/home.component';
import { RouterModule } from '@angular/router';
import { PageNotFoundComponent } from './notions/compoment/page-not-found/page-not-found.component';
import { ProduitInfoComponent } from './notions/compoment/produit-info/produit-info.component';

@NgModule({
  declarations: [
    AppComponent,
    FirstComponent,
    EditComponent,
    CouleurComponent,
    ShowComponent,
    ProduitComponent,
    VoteComponent,
    CandidatComponent,
    ListComponent,
    DemoDirective,
    HighlightDirective,
    HomeComponent,
    PageNotFoundComponent,
    ProduitInfoComponent,
  ],
  imports: [BrowserModule, FormsModule, RouterModule.forRoot(routes)],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
