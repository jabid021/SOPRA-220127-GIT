import { Produit } from './../../../model/produit';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css'],
})
export class ProduitComponent implements OnInit {
  produitAEnvoyer: Produit = new Produit();

  constructor() {}

  ngOnInit(): void {}

  produitRecu(produit: Produit) {
    this.produitAEnvoyer = produit;
  }
}
