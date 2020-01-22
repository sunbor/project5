import { Component, OnInit } from '@angular/core';
import { EncounterService, Digimon } from '../services/encounter.service';

const _DIGIDEX_SIZE_: number = 100; // how many different Digimon the API has, hard coded for now

@Component({
  selector: 'app-encounter',
  templateUrl: './encounter.component.html',
  styleUrls: ['./encounter.component.css']
})
export class EncounterComponent implements OnInit {
  private isInEncounter: boolean;
  private catchRate: number; // base rate determined by digimon evolution
  private escapeRate: number; // base rate determined by digimon evolution
  private digimon: Digimon; // Will need to feed a digimon into this
  private currentUser$ = { // This is temporary!
    id: 1,
    username: "admin",
  };

  constructor(private encounterService: EncounterService) { }

  ngOnInit() {
  }


  beginEncounter() {
    let encounterValue: number = Math.floor(Math.random() * _DIGIDEX_SIZE_ + 1); // Random generated the Digimon id from 1 to 100.
    this.encounterService.getEncounter(encounterValue).subscribe(
      data => {
        this.digimon = data;
        this.isInEncounter = true;
      },
      err => {
        console.log(`An error occured when getting Digimon with id: ${encounterValue}.`)
        console.log(err.error);
      }
    );
  };

  throwBall(): void {
    let catchRoll: number = Math.floor(Math.random() * 101); // Random integer between 0 and 100
    if (catchRoll + (this.catchRate * 5) >= 100) { // 100% catch rate
      // Call successful catch method
    }
  }

  throwBait(): void {
    this.catchRate = this.catchRate - Math.floor(Math.random() * 5 + 1); // Reduce catch chance by anywhere from 5% to 25%
    this.escapeRate = this.escapeRate - Math.floor(Math.random() * 5 + 1); // Reduce escape chance by anywhere from 5% to 25%

    if (this.catchRate < 1) {
      this.catchRate = 1;
    }

    if (this.escapeRate < 0) {
      this.escapeRate = 1;
    }

    this.rollForEscape();
  }

  throwRock(): void {
    this.catchRate = this.catchRate + 3; // Increase catch chance by 15%
    this.escapeRate = this.escapeRate + Math.floor(Math.random() * 4 + 1); // Increase escape chance by anywhere from 5% to 20%

    if (this.catchRate > 20) {
      this.catchRate = 20;
    }

    if (this.escapeRate > 20) {
      this.escapeRate = 20;
    }

    this.rollForEscape();
  }

  rollForEscape(): void {
    let escapeRoll: number = Math.floor(Math.random() * 101); // Random integer between 0 and 100
    if ((escapeRoll - 100 + (this.escapeRate * 5)) > 0) {
      // Digimon will flee
    }
    // Add some logic to give a hint to the user if the Digimon is close to fleeing and/or has a high catch rate
  }

  saveDigimon() {
    let saveInfo = {
      "user": `${this.currentUser$}`, // will send current user's info
      "digimon": `${this.digimon}` // will send the Digimon's data
    }
    this.encounterService.saveCatch(saveInfo).subscribe(
      data => {
        console.log("Server responded with success code", data); // This might not return a success code. Will need to be tested
      },
      err => {
        console.log(err.error);
      });
  }

}
