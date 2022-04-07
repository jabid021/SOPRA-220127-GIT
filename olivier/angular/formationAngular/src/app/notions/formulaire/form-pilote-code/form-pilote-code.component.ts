import { LoginComponent } from './../../component/login/login.component';
import { CustomValidator } from './../../validators/custom-validator';
import {
  FormControl,
  FormGroup,
  Validators,
  AbstractControl,
  ValidationErrors,
} from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-form-pilote-code',
  templateUrl: './form-pilote-code.component.html',
  styleUrls: ['./form-pilote-code.component.css'],
})
export class FormPiloteCodeComponent implements OnInit {
  form: FormGroup;

  constructor() {
    this.form = new FormGroup({
      prenomCtrl: new FormControl('', [
        Validators.required,
        CustomValidator.pasTotoDansInput,
      ]),
      nomCtrl: new FormControl('', [
        Validators.required,
        Validators.minLength(2),
        CustomValidator.pasTexteDansInput('tutu'),
      ]),
      loginPasswordGroup: new FormGroup(
        {
          loginCtrl: new FormControl('', Validators.required),
          passwordCtrl: new FormControl('', Validators.required),
        },
        this.notEquals
      ),
    });
  }

  notEquals(control: AbstractControl): ValidationErrors | null {
    let group = control as FormGroup;
    let login = group.controls['loginCtrl'];
    let password = group.controls['passwordCtrl'];
    //if (login.pristine || password.pristine) return null;
    return login.value == password.value ? { equals: true } : null;
  }

  ngOnInit(): void {}

  submit() {
    console.log(this.form.controls['prenomCtrl'].value);
    console.log(this.form.get('prenomCtrl')?.value);
    console.log(this.form.controls['loginPasswordGroup']);
    console.log(this.form.get('loginPasswordGroup.loginCtrl'));
  }
}
