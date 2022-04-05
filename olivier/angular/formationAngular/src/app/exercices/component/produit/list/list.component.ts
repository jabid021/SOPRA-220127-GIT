import { Produit } from './../../../model/produit';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
})
export class ListComponent implements OnInit {
  produits: Produit[] = [new Produit('tele', 100), new Produit('pomme', 1)];

  constructor() {}

  ngOnInit(): void {}

  infos(prix: number): string {
    if (prix < 0) {
      return 'negatif';
    } else if (prix > 0) {
      return 'positif';
    } else {
      return 'neutre';
    }
  }

  addProduit(produit: Produit) {
    this.produits.push(produit);
  }
}
