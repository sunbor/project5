import { Component, OnInit } from '@angular/core';
import { DigimonFromDB } from '../services/encounter.service';
import { HttpClient } from '@angular/common/http';
import { User, AuthService } from '../services/auth.service';

@Component({
  selector: 'app-collection',
  templateUrl: './collection.component.html',
  styleUrls: ['./collection.component.scss']
})
export class CollectionComponent implements OnInit {

  private digimon: DigimonFromDB[] = [];

  constructor(private httpClient: HttpClient,
    private authService: AuthService) { }

  infoToggled = false;

  ngOnInit() {
    this.authService.$currentUser.subscribe((user: User) => {
      console.log(user.userId);
      this.httpClient.get<DigimonFromDB[]>(`http://localhost:8080/project5/users/${user.userId}/digimon`, {
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