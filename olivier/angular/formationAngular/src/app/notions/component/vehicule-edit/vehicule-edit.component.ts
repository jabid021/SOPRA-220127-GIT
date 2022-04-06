import { Vehicule } from './../../model/vehicule';
import { VehiculeService } from './../../services/vehicule.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-vehicule-edit',
  templateUrl: './vehicule-edit.component.html',
  styleUrls: ['./vehicule-edit.component.css'],
})
export class VehiculeEditComponent implements OnInit {
  vehicule: Vehicule = new Vehicule();

  constructor(
    private aR: ActivatedRoute,
    private vehiculeService: VehiculeService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.vehiculeService.get(params['id']).subscribe((result) => {
          this.vehicule = result;
          console.log(result);
        });
      }
    });
  }

  save() {
    if (this.vehicule.id) {
      this.vehiculeService.update(this.vehicule).subscribe((result) => {
        this.goList();
      });
    } else {
      this.vehiculeService.create(this.vehicule).subscribe((result) => {
        this.goList();
      });
    }
  }

  goList() {
    this.router.navigateByUrl('/vehicule');
  }
}
