import { AuthService } from './notions/services/auth.service';
import { Produit } from './exercices/model/produit';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'formationAngular';

  public constructor(private authService: AuthService) {}

  get login() {
    return localStorage.getItem('login');
  }

  isAutenticated() {
    return this.authService.isAutenticated();
  }

  logout() {
    localStorage.clear();
  }
}
