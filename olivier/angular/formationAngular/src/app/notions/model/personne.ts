export class Personne {
  constructor(private _prenom?: string, private _nom?: string) {}

  public get prenom(): string | undefined {
    return this._prenom;
  }

  public get nom(): string | undefined {
    return this._nom;
  }

  public set prenom(value: string | undefined) {
    this._prenom = value;
  }

  public set nom(value: string | undefined) {
    this._nom = value;
  }
}
