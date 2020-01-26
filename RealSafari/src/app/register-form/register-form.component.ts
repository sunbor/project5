import { Component, OnInit } from '@angular/core';
import { RegisterService, RegisterForm } from '../services/register.service';

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {

  username: string;
  password: string;

  constructor(private registerService: RegisterService) { }

  ngOnInit() {
  }

  register() {
    const registerForm: RegisterForm = {
      username: this.username,
      password: this.password
    };
    this.registerService.register(registerForm).subscribe(
      () => {
        console.log("success");
      },
      err => {
        console.error(err);
      }
    );
  }
}
