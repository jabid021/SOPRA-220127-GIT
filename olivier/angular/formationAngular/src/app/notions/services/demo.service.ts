import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class DemoService {
  private unAttribut: string = 'hello';

  constructor() {}

  public hello(): string {
    return this.unAttribut;
  }
}
