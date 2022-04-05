import { Produit } from './../../../model/produit';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'edit-produit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css'],
})
export class EditComponent implements OnInit {
  produit: Produit = new Produit();
  @Output()
  produitReady: EventEmitter<Produit> = new EventEmitter<Produit>();

  constructor() {}

  ngOnInit(): void {}

  displayConsole() {
    //this.produitReady.emit({nom:this.produit.nom,prix:this.produit.prix});
    this.produitReady.emit(this.produit);
    this.produit = new Produit();
  }
}
