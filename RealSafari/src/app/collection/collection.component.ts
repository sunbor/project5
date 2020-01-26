import { Component, OnInit } from '@angular/core';
import { DigimonFromDB } from '../services/encounter.service';
import { HttpClient } from '@angular/common/http';
import { User, AuthService } from '../services/auth.service';
// import { timingSafeEqual } from 'crypto';

@Component({
  selector: 'app-collection',
  templateUrl: './collection.component.html',
  styleUrls: ['./collection.component.scss']
})
export class CollectionComponent implements OnInit {

  private digimon: DigimonFromDB[] = [];
  private toggles: boolean[] = [];

  constructor(private httpClient: HttpClient,
    private authService: AuthService) { }

  infoToggled = false;

  ngOnInit() {
    this.authService.$currentUser.subscribe((user: User) => {
      this.httpClient.get<DigimonFromDB[]>(`http://localhost:8080/project5/users/${user.userId}/digimon`, {
        withCredentials: true
      })
        .subscribe(data => {
          this.digimon = data;
        }, err => {
          console.log(err);
        });
    });
  }

  toggleInfo(i: number) {
      this.toggles[i] = !this.toggles[i];
    // this.infoToggled = !this.infoToggled;
  }

  deleteDigimon(i: number, digimonId: number){
    console.log(i, digimonId);
    for (let i1 = 0; i1 < this.toggles.length; i1++){
      this.toggles[i1] = false;
    }
    this.httpClient.delete<boolean>(`http://localhost:8080/project5/digimon/${digimonId}/`, {
      withCredentials: true
    }).subscribe(() => {
      this.digimon.splice(i, 1);

    });
  }

}