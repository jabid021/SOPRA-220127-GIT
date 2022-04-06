import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css'],
})
export class FormComponent implements OnInit {
  nom = '';

  constructor(private router: Router) {}

  ngOnInit(): void {}

  envoyer() {
    //this.router.navigateByUrl('/hello/' + this.nom);
    //this.router.navigate(['/hello',this.nom]);

    this.router.navigate(['/hello'], { queryParams: { nom: this.nom } });
  }
}
