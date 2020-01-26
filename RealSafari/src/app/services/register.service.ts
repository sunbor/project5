import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http: HttpClient) { }

  register(form: RegisterForm){
    return this.http.post<RegisterForm>('http://localhost:8080/project5/users', form)
  }
}

export interface RegisterForm {
  username: string;
  password: string;
}