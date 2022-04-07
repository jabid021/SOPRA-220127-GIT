import { FormPiloteCodeComponent } from './notions/formulaire/form-pilote-code/form-pilote-code.component';
import { FormPiloteTemplateComponent } from './notions/formulaire/form-pilote-template/form-pilote-template.component';
import { GuardClientService } from './notions/services/guard-client.service';
import { GuardService } from './notions/services/guard.service';
import { LoginComponent } from './notions/component/login/login.component';
import { ActiviteEditComponent } from './notions/component/activite/activite-edit/activite-edit.component';
import { ActiviteListComponent } from './notions/component/activite/list/activite.list.component';
import { VehiculeEditComponent } from './notions/component/vehicule-edit/vehicule-edit.component';
import { VehiculeComponent } from './notions/component/vehicule/vehicule.component';
import { ProduitInfoComponent } from './notions/compoment/produit-info/produit-info.component';
import { PageNotFoundComponent } from './notions/compoment/page-not-found/page-not-found.component';
import { VoteComponent } from './exercices/component/vote/vote.component';
import { HomeComponent } from './notions/compoment/home/home.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'election', component: VoteComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'vehicule', component: VehiculeComponent },
  {
    path: 'activite',
    component: ActiviteListComponent,
    canActivate: [GuardService],
  },
  {
    path: 'vehicule/edit',
    component: VehiculeEditComponent,
    canActivate: [GuardService],
  },
  {
    path: 'vehicule/edit/:id',
    component: VehiculeEditComponent,
    canActivate: [GuardService],
  },
  { path: 'produit/info/:nom', component: ProduitInfoComponent },
  {
    path: 'activite/edit/:id',
    component: ActiviteEditComponent,
    canActivate: [GuardClientService],
  },
  {
    path: 'activite/add/:type',
    component: ActiviteEditComponent,
    canActivate: [GuardClientService],
  },
  { path: 'login', component: LoginComponent },
  { path: 'form/template', component: FormPiloteTemplateComponent },
  { path: 'form/code', component: FormPiloteCodeComponent },
  { path: '**', component: PageNotFoundComponent },
];
