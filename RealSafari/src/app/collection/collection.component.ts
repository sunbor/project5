import { Component, OnInit } from '@angular/core';
import { Digimon } from '../services/encounter.service';
import { HttpClient } from '@angular/common/http';
import { User, AuthService } from '../services/auth.service';

@Component({
  selector: 'app-collection',
  templateUrl: './collection.component.html',
  styleUrls: ['./collection.component.scss']
})
export class CollectionComponent implements OnInit {

  private currentUserId$: number;
  private digimon: Digimon[] = [];

  constructor(private httpClient: HttpClient,
    private authService: AuthService) { }

  infoToggled = false;

  ngOnInit() {
    this.authService.$currentUser.subscribe((user: User) => {
      this.currentUserId$ = user.id;
      this.httpClient.get<Digimon[]>(`http://localhost:8080/project5/users/${this.currentUserId$}`, {
        withCredentials: true
      })
        .subscribe(data => {
          console.log(data);
          this.digimon = data;
        }, err => {
          console.log(err);
        });
    });
  }

  toggleInfo() {
    this.infoToggled = !this.infoToggled;
  }

}