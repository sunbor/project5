import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EncounterService {  

  constructor(private http: HttpClient) { }

  getEncounter(encounterValue: number) {
  return this.http.get<Digimon>(`https://digimon-api.herokuapp.com/api/digimon/id/${encounterValue}`);
  }

  saveCatch(digimon) {
    return this.http.post(`http://localhost:8080/project5/users/${digimon.userId}/digimon`, digimon, { withCredentials: true });
  }

}
export interface Digimon {
  id: number;
  name: String;
  img: String;
  level: String;
}
export interface DigimonFromDB {
    digiDexId: number,
    digimonName: String,
    imgUrl: String,
    digimonLevel: String,
    userId: number
}