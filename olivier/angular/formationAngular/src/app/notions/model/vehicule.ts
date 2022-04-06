export class Vehicule {
  public constructor(
    private _id?: number | undefined,
    private _model?: string | undefined
  ) {}

  public get id(): number | undefined {
    return this._id;
  }

  public set id(value: number | undefined) {
    this._id = value;
  }

  public get model(): string | undefined {
    return this._model;
  }

  public set model(value: string | undefined) {
    this._model = value;
  }
}
