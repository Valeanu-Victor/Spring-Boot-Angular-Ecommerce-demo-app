import { Component, OnInit } from '@angular/core';
import { RegisterService } from '../service/register/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  private username: string
  private password: string
  private roles: string

  constructor(
    private registerService: RegisterService
  ) { }

  ngOnInit() {
  }

  registerUser() {
    this.roles = this.roles.toUpperCase();
    this.registerService.register(this.username, this.password, this.roles).subscribe();
  }

}
