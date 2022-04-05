import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-candidat',
  templateUrl: './candidat.component.html',
  styleUrls: ['./candidat.component.css'],
})
export class CandidatComponent implements OnInit {
  @Input('candidat')
  nom: string = '';
  vote: number = 0;
  @Output()
  aVoter: EventEmitter<any> = new EventEmitter<any>();

  constructor() {}

  ngOnInit(): void {}

  voter() {
    this.vote++;
    this.aVoter.emit({ nom: this.nom, nbreVote: this.vote });
  }
}
