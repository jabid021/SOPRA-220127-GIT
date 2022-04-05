export class Produit {
  public constructor(
    private _nom?: string | undefined,
    private _prix?: number | undefined
  ) {}

  public get nom(): string | undefined {
    return this._nom;
  }

  public set nom(value: string | undefined) {
    this._nom = value;
  }
  public get prix(): number | undefined {
    return this._prix;
  }

  public set prix(value: number | undefined) {
    this._prix = value;
  }
}
