import { Vehicule } from './vehicule';
import { Time } from '@angular/common';
import { Meteo } from './meteo';
import { Activite } from './activite';
export class Safari extends Activite {
  public constructor(
    id?: number | undefined,
    meteo?: Meteo | undefined,
    date?: Date | undefined,
    heure?: Time | undefined,
    prix?: number | undefined,
    private _vehicule?: Vehicule | undefined
  ) {
    super(id, meteo, date, heure, prix);
  }

  public get vehicule(): Vehicule | undefined {
    return this._vehicule;
  }

  public set vehicule(value: Vehicule | undefined) {
    this._vehicule = value;
  }
}
