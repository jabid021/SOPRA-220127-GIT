import { Time } from '@angular/common';
import { Meteo } from './meteo';
export abstract class Activite {
  public constructor(
    private _id?: number | undefined,
    private _meteo?: Meteo | undefined,
    private _date?: Date | undefined,
    private _heure?: Time | undefined,
    private _prix?: number | undefined
  ) {}

  public get id(): number | undefined {
    return this._id;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }
  public get meteo(): Meteo | undefined {
    return this._meteo;
  }

  public set meteo(value: Meteo | undefined) {
    this._meteo = value;
  }
  public get date(): Date | undefined {
    return this._date;
  }

  public set date(value: Date | undefined) {
    this._date = value;
  }
  public get heure(): Time | undefined {
    return this._heure;
  }

  public set heure(value: Time | undefined) {
    this._heure = value;
  }
  public get prix(): number | undefined {
    return this._prix;
  }

  public set prix(value: number | undefined) {
    this._prix = value;
  }
}
