import { Component, OnInit } from '@angular/core';
import { Personne } from '../model/personne';

@Component({
  selector: 'olivier,app-first,[olivier-directive]',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css'],
})
export class FirstComponent implements OnInit {
  prenom: string = 'olivier';

  olivier: Personne = new Personne('olivier');

  constructor() {}

  ngOnInit(): void {
    this.olivier.nom = 'gozlan';
  }

  sayHello(): string {
    return 'hello';
  }
}
