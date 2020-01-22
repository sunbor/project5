import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user.model';



@Injectable({
  providedIn: 'root'
})
export class EncounterService {
  private digimon: Digimon;
  private currentUser$: User;

  constructor(private http: HttpClient) { }

  getEncounter(encounterNumber: number) {
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

  saveCatch(digimon: Digimon) { // Followed an April 2019 Angular example on this one. 
    this.http.post("http://localhost:8080/project5/users/digimon", 
    {
      "user":`${this.currentUser$}`,
      "digimon": `${digimon}`
    }).subscribe(
      data => {
        console.log("Server responded with success code", data);
      },
      err => {
        console.log(`Error saving Digimon to ${this.currentUser$.username}: ${digimon}`);
        console.log(err.error);
      });
  }

}
export interface Digimon {
  id: number;
  name: String;
  img: String;
  level: String;
}
