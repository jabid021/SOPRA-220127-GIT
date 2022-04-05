import { Produit } from './../../../model/produit';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'show-produit',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css'],
})
export class ShowComponent implements OnInit {
  @Input()
  produit: Produit = new Produit();
  constructor() {}

  ngOnInit(): void {}
}
