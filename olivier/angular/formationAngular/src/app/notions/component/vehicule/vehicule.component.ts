import { Vehicule } from './../../model/vehicule';
import { VehiculeService } from './../../services/vehicule.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-vehicule',
  templateUrl: './vehicule.component.html',
  styleUrls: ['./vehicule.component.css'],
})
export class VehiculeComponent implements OnInit {
  vehicules: Vehicule[] = [];

  constructor(private vehiculeService: VehiculeService) {}

  ngOnInit(): void {
    this.list();
  }

  list() {
    this.vehiculeService.getAll().subscribe((result) => {
      this.vehicules = result;
    });
  }

  delete(id: number) {
    this.vehiculeService.delete(id).subscribe((noResult) => {
      this.list();
    });
  }
}
