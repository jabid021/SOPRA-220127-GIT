import { Router } from '@angular/router';
import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  login: string = '';
  password: string = '';
  err: boolean = false;

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit(): void {}

  check() {
    //controle login/password
    this.authService.authentication(this.login, this.password).subscribe({
      next: (value: string) => {
        localStorage.setItem('login', this.login);
        localStorage.setItem(
          'token',
          'Basic ' + btoa(this.login + ':' + this.password)
        );
        localStorage.setItem('role', value);
        this.err = false;
        this.router.navigateByUrl('/home');
      },
      error: (error: any) => {
        console.log(error);
        this.err = true;
      },
    });
  }
}
