import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-produit-info',
  templateUrl: './produit-info.component.html',
  styleUrls: ['./produit-info.component.css'],
})
export class ProduitInfoComponent implements OnInit {
  nomRecu: string = '';

  constructor(private activatedRoute: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    console.log('ngOnInit');
    //this.nomRecu = this.activatedRoute.snapshot.params['nom'];
    this.activatedRoute.params.subscribe((params) => {
      this.nomRecu = params['nom'];
    });
  }

  goHome() {
    this.router.navigateByUrl('/home');
  }
}
