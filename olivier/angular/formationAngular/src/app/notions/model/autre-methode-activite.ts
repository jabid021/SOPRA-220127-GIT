import { Vehicule } from './vehicule';
import { Time } from '@angular/common';
import { Meteo } from './meteo';
export class AutreMethodeActivite {
  public constructor(
    private type: string = 'aquatique',
    private _id?: number | undefined,
    private _meteo?: Meteo | undefined,
    private _date?: Date | undefined,
    private _heure?: Time | undefined,
    private _prix?: number | undefined,
    private _vehicule?: Vehicule | undefined
  ) {}
}
