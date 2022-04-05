import { Produit } from './../../../model/produit';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'edit-produit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css'],
})
export class EditComponent implements OnInit {
  produit: Produit = new Produit();

  constructor() {}

  ngOnInit(): void {}

  displayConsole() {
    console.log(this.produit);
  }
}
