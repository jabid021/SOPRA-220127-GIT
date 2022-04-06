import { Time } from '@angular/common';
import { Meteo } from './meteo';
import { Activite } from './activite';
export class Aquatique extends Activite {
  public constructor(
    id?: number | undefined,
    meteo?: Meteo | undefined,
    date?: Date | undefined,
    heure?: Time | undefined,
    prix?: number | undefined
  ) {
    super(id, meteo, date, heure, prix);
  }
}
