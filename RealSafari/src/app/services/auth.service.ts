import { Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { User } from '../model/user.model';
import { ReplaySubject, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  // not so sure whats going on in here.

  private currentUserStream = new ReplaySubject<User>(1);
  $currentUser = this.currentUserStream.asObservable();

  private loginErrorStream = new Subject<string>();
  private registerErrorStream = new Subject<string>();
  $loginError = this.loginErrorStream.asObservable();
  $registerError = this.registerErrorStream.asObservable();

  constructor(private httpClient: HttpClient, private router: Router) { }

  login(credentials: any) { //
    this.httpClient.post<User>('http://localhost:8080/project5/login', credentials, {
      withCredentials: true // processes only if cedentials are filled ?
    }).subscribe( //
      data => { // if successful / 200's is returned
        console.log('logged in'); // prints error, not required
        this.router.navigateByUrl('/home'); // the link to the next location
        this.currentUserStream.next(data); // sends user data to next location
      },
      err => { // if successful / 400's is returned
        console.log(err); // prints error, not required
        this.loginErrorStream.next('Login Failed'); // sets error message?
      }
    );
  }
}
