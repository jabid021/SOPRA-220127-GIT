import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

export class CustomValidator {
  public static pasTotoDansInput(
    control: AbstractControl
  ): ValidationErrors | null {
    return control.value == 'toto' ? { totoDansInput: true } : null;
  }

  public static pasTexteDansInput(texteInterdit: string): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      return control.value == texteInterdit
        ? { texteInterditDansInput: true }
        : null;
    };
  }
}
