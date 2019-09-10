import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BasicAuthenticationService } from './../service/basic-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  private username: string = '';
  private password: string = '';
  private errorMessage: string = 'Invalid Credentials!';
  private invalidLogin: boolean;

  constructor(
    private router: Router,
    private basicAuthenticationService: BasicAuthenticationService
  ) { }

  ngOnInit() { }

  handleJWTAuthLogin() {
    this.basicAuthenticationService.executeJWTAuthenticationService(this.username, this.password)
      .subscribe(
        () => {
          this.router.navigate(['welcome', this.username]);
          this.invalidLogin = false;
        },
        error => {
          console.log(error);
          this.invalidLogin = true;
        }
      )
  }
}
