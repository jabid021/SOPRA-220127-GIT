import { Component, HostListener, OnInit } from '@angular/core';
import { Personne } from '../model/personne';

@Component({
  selector: 'olivier,app-first,[olivier-directive]',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css'],
})
export class FirstComponent implements OnInit {
  prenom: string = 'olivier';
  couleur: string = 'red';
  olivier: Personne = new Personne('olivier');

  constructor() {}

  ngOnInit(): void {
    this.olivier.nom = 'gozlan';
  }

  sayHello(): string {
    return 'hello';
  }

  button() {
    console.log('click');
  }

  @HostListener('click')
  clickComponent() {
    console.log('click sur le component');
  }

  @HostListener('mouseover')
  mouseOver() {
    console.log('la sourie passe sur le component');
  }

  // get couleur(): string {
  //   return 'red';
  // }
}
