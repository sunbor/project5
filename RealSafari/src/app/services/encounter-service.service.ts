import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const _DIGIDEX_SIZE_: number = 100; // how many different Digimon the API has, hard coded for now

@Injectable({
  providedIn: 'root'
})
export class CatchServiceService {
  private digimon: Digimon;

  constructor(private http: HttpClient) { }

  getEncounter() {
    let encounterNumber: number = Math.floor(Math.random()*_DIGIDEX_SIZE_ + 1); // Random generated the Digimon id from 1 to 100.
    return this.http.get<Digimon>(`https://digimon-api.herokuapp.com/api/digimon/${encounterNumber}`).subscribe(
      data =>{
        this.digimon = data;
      },
      err => {
        console.log(`An error occured when getting Digimon with id: ${encounterNumber}.`)
        console.log(err.error);
      }
    );
  }

  saveCatch() {
    this.http.post("http://localhost:8080/project5/users/digimon", withCredentials: true)
  }

}
export interface Digimon {
  id: number;
  name: String;
  img: String;
  level: String;
}
