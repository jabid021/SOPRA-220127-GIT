import { HelloComponent } from './component/hello/hello.component';
import { FormComponent } from './component/form/form.component';
import { HomeComponent } from './component/home/home.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'form', component: FormComponent },
  // { path: 'hello/:nom', component: HelloComponent },
  { path: 'hello', component: HelloComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
