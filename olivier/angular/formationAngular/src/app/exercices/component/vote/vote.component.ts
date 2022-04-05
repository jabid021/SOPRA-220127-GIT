import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-vote',
  templateUrl: './vote.component.html',
  styleUrls: ['./vote.component.css'],
})
export class VoteComponent implements OnInit {
  candidantEnTete: string = '';
  vote: number = 0;

  constructor() {}

  ngOnInit(): void {}

  voteRecu(infos: any) {
    if (infos.nbreVote > this.vote) {
      this.candidantEnTete = infos.nom;
      this.vote = infos.nbreVote;
    }
  }
}
