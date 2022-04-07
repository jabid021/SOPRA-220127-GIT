import { AuthInterceptor } from './notions/interceptor/auth.interceptor';
import { ActiviteListComponent } from './notions/component/activite/list/activite.list.component';
import { routes } from './routes';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FirstComponent } from './notions/first/first.component';
import { CouleurComponent } from './exercices/component/couleur/couleur.component';
import { VoteComponent } from './exercices/component/vote/vote.component';
import { CandidatComponent } from './exercices/component/candidat/candidat.component';
import { DemoDirective } from './notions/directive/demo.directive';
import { HighlightDirective } from './notions/directive/highlight.directive';
import { HomeComponent } from './notions/compoment/home/home.component';
import { RouterModule } from '@angular/router';
import { PageNotFoundComponent } from './notions/compoment/page-not-found/page-not-found.component';
import { ProduitInfoComponent } from './notions/compoment/produit-info/produit-info.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { VehiculeComponent } from './notions/component/vehicule/vehicule.component';
import { VehiculeEditComponent } from './notions/component/vehicule-edit/vehicule-edit.component';
import { ActiviteEditComponent } from './notions/component/activite/activite-edit/activite-edit.component';
import { LoginComponent } from './notions/component/login/login.component';
@NgModule({
  declarations: [
    AppComponent,
    FirstComponent,
    CouleurComponent,
    VoteComponent,
    CandidatComponent,
    DemoDirective,
    HighlightDirective,
    HomeComponent,
    PageNotFoundComponent,
    ProduitInfoComponent,
    VehiculeComponent,
    VehiculeEditComponent,
    ActiviteListComponent,
    ActiviteEditComponent,
    LoginComponent,
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes),
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
