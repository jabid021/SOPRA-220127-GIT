import { debounceTime, map, Observable } from 'rxjs';
import { CompteService } from './../../services/compte.service';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormBuilder,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  form: FormGroup;
  // telephone: FormControl;

  constructor(private compteService: CompteService, private router: Router) {
    // this.telephone=new FormControl('')
    this.form = new FormGroup({
      telephone: new FormControl(
        '',
        Validators.pattern(/^0|(\+33)[1-9]([ -.]{0,1}\d{2}){4}$/)
      ),
      emailPasswordGroup: new FormGroup(
        {
          email: new FormControl(
            '',
            [Validators.required, Validators.email],
            this.checkEmail()
          ),
          passwordGroup: new FormGroup(
            {
              password: new FormControl('', [
                Validators.required,
                Validators.pattern(
                  /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[*_!@-\\.])([a-zA-Z0-9*_!@-\\.]{5,25})$/
                ),
              ]),
              confirm: new FormControl('', Validators.required),
            },
            this.passwordAndConfirmEquals
          ),
        },
        this.mailAndPasswordNotEquals
      ),
      numero: new FormControl('', Validators.required),
      rue: new FormControl('', Validators.required),
      codePostal: new FormControl('', Validators.required),
      ville: new FormControl('', Validators.required),
    });
  }

  checkEmail(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.compteService.findByEmail(control.value).pipe(
        debounceTime(1000),
        map((result) => {
          return result ? { emailExist: true } : null;
        })
      );
    };
  }

  mailAndPasswordNotEquals(control: AbstractControl): ValidationErrors | null {
    let group = control as FormGroup;
    if (group.get('email')?.invalid || group.get('passwordGroup')?.invalid) {
      return null;
    }
    return group.get('email')?.value ==
      group.get('passwordGroup.password')?.value
      ? { mailAndPasswordEquals: true }
      : null;
  }

  passwordAndConfirmEquals(control: AbstractControl): ValidationErrors | null {
    let group = control as FormGroup;
    if (group.get('password')?.errors) {
      return null;
    }
    return group.get('password')?.value == group.get('confirm')?.value
      ? null
      : { passwordAndConfirmNotEquals: true };
  }

  ngOnInit(): void {}

  submit() {
    let compte = {
      mail: this.form.get('emailPasswordGroup.email')?.value,
      password: this.form.get('emailPasswordGroup.passwordGroup.password')
        ?.value,
      tel: this.form.get('telephone')?.value,
      adresse: {
        numero: this.form.get('numero')?.value,
        voie: this.form.get('rue')?.value,
        cp: this.form.get('codePostal')?.value,
        ville: this.form.get('ville')?.value,
      },
    };
    this.compteService.inscriptionClient(compte).subscribe((ok) => {
      this.router.navigateByUrl('/login');
    });
  }
}
