import { Safari } from './../../../model/safari';
import { Time } from '@angular/common';
import { Meteo } from './../../../model/meteo';
import { Aquatique } from './../../../model/aquatique';
import { ActiviteService } from '../../../services/activite.service';
import { Component, OnInit } from '@angular/core';
import { Activite } from 'src/app/notions/model/activite';
import { timestamp } from 'rxjs';
import * as moment from 'moment';
import { Vehicule } from 'src/app/notions/model/vehicule';

@Component({
  selector: 'app-list',
  templateUrl: './activite.list.component.html',
  styleUrls: ['./activite.list.component.css'],
})
export class ActiviteListComponent implements OnInit {
  activites: Activite[] = [];

  constructor(private activiteService: ActiviteService) {}

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.activiteService.getAll().subscribe((result) => {
      this.activites = [];
      for (let a of result) {
        if (a.type == 'aquatique') {
          this.activites.push(
            new Aquatique(a.id, a.meteo, a.date, a.heure, a.prix)
          );
        } else {
          this.activites.push(
            new Safari(
              a.id,
              a.meteo,
              a.date,
              a.heure,
              a.prix,
              a.vehicule
                ? new Vehicule(a.vehicule.id, a.vehicule.model)
                : undefined
            )
          );
        }
      }
    });
  }

  delete(id: number) {
    this.activiteService.delete(id).subscribe((ok) => {
      this.list();
    });
  }

  getVehicule(activite: Activite): Vehicule | undefined {
    if (activite instanceof Safari) {
      return (activite as Safari).vehicule;
    }
    return undefined;
  }

  getType(activite: Activite): string {
    if (activite instanceof Safari) {
      return 'safari';
    } else {
      return 'aquatique';
    }
  }
}
