import { ProduitInfoComponent } from './notions/compoment/produit-info/produit-info.component';
import { PageNotFoundComponent } from './notions/compoment/page-not-found/page-not-found.component';
import { VoteComponent } from './exercices/component/vote/vote.component';
import { ListComponent } from './exercices/component/produit/list/list.component';
import { HomeComponent } from './notions/compoment/home/home.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'produits', component: ListComponent },
  { path: 'election', component: VoteComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'produit/info/:nom', component: ProduitInfoComponent },
  { path: '**', component: PageNotFoundComponent },
];
