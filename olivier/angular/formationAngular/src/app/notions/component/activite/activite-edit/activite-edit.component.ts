import { VehiculeService } from './../../../services/vehicule.service';
import { Meteo } from './../../../model/meteo';
import { ActiviteService } from './../../../services/activite.service';
import { Safari } from './../../../model/safari';
import { Aquatique } from './../../../model/aquatique';
import { Activite } from 'src/app/notions/model/activite';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Vehicule } from 'src/app/notions/model/vehicule';

@Component({
  selector: 'app-activite-edit',
  templateUrl: './activite-edit.component.html',
  styleUrls: ['./activite-edit.component.css'],
})
export class ActiviteEditComponent implements OnInit {
  activite: Activite = new Aquatique();
  meteos = Meteo;
  vehicules: Vehicule[] = [];
  vehicule: Vehicule | undefined = new Vehicule();
  operation: string = 'aquatique';

  constructor(
    private aR: ActivatedRoute,
    private activiteService: ActiviteService,
    private vehiculeService: VehiculeService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.vehiculeService.getAll().subscribe((result) => {
      this.vehicules = result;
    });

    this.aR.params.subscribe((params) => {
      if (params['type']) {
        if (params['type'] == 'aquatique') {
          this.operation = 'aquatique';
          this.activite = new Aquatique();
        } else {
          this.operation = 'safari';
          this.activite = new Safari();
        }
      } else {
        this.activiteService.get(params['id']).subscribe((a) => {
          if (a.type == 'aquatique') {
            this.activite = new Aquatique(
              a.id,
              a.meteo,
              a.date,
              a.heure,
              a.prix
            );
            this.operation = 'aquatique';
          } else {
            this.activite = new Safari(
              a.id,
              a.meteo,
              a.date,
              a.heure,
              a.prix,
              a.vehicule
                ? new Vehicule(a.vehicule.id, a.vehicule.model)
                : undefined
            );
            let s = this.activite as Safari;
            this.vehicule = s.vehicule;
            this.operation = 'safari';
          }
        });
      }
    });
  }

  save() {
    if (this.vehicule?.id) {
      let safari = this.activite as Safari;
      safari.vehicule = this.vehicule;
      this.activite = safari;
    }
    if (this.activite.id) {
      this.activiteService.update(this.activite).subscribe(() => {
        this.goList();
      });
    } else {
      this.activiteService.create(this.activite).subscribe(() => {
        this.goList();
      });
    }
  }

  goList() {
    this.router.navigateByUrl('/activite');
  }

  byId(obj1: Vehicule, obj2: Vehicule) {
    if (obj1 && obj2) return obj1.id == obj2.id;
    return false;
  }
}
