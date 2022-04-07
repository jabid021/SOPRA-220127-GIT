import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-form-pilote-template',
  templateUrl: './form-pilote-template.component.html',
  styleUrls: ['./form-pilote-template.component.css'],
})
export class FormPiloteTemplateComponent implements OnInit {
  input: string = '';

  constructor() {}

  ngOnInit(): void {}

  submit(form: any) {
    let formGroup = form as FormGroup;
    console.log(formGroup);
    console.log(formGroup.controls['input'].value);
    console.log(this.input);
  }
}
