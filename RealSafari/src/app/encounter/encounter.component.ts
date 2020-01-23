import { Component, OnInit } from '@angular/core';
import { EncounterService, Digimon } from '../services/encounter.service';

const _DIGIDEX_SIZE_: number = 100; // how many different Digimon the API has, hard coded for now
const _FRESH_CATCH_RATE_: number = 50;
const _FRESH_ESCAPE_RATE_: number = 5;
const _IN_TRAINING_CATCH_RATE_: number = 45; // base catch rate of Digimon with level "In Training"
const _IN_TRAINING_ESCAPE_RATE_: number = 10; // base escape rate of Digimon with level "In Training"
const _ROOKIE_CATCH_RATE_: number = 35;
const _ROOKIE_ESCAPE_RATE_: number = 15;
const _CHAMPION_CATCH_RATE_: number = 25;
const _CHAMPION_ESCAPE_RATE_: number = 25;
const _ULTIMATE_CATCH_RATE_: number = 15;
const _ULTIMATE_ESCAPE_RATE_: number = 35;
const _MEGA_CATCH_RATE_: number = 10;
const _MEGA_ESCAPE_RATE_: number = 45;

@Component({
  selector: 'app-encounter',
  templateUrl: './encounter.component.html',
  styleUrls: ['./encounter.component.css']
})
export class EncounterComponent implements OnInit {
  private message: String = '';
  private isEscaped: boolean = false; // Must have an encounter before this can be true
  private catchRate: number; // base rate determined by digimon level
  private escapeRate: number; // base rate determined by digimon level
  private digimon: Digimon = null; // Will need to feed a digimon into this
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
        this.digimon = data; // Stores an array of Digimon with a single entry
        this.setBaseRates();
        this.isEscaped = false;
        this.message = `A wild ${this.digimon[0].name} has appeared!`;
        console.log(this.digimon[0]);
      },
      err => {
        console.log(`An error occured when getting Digimon with id: ${encounterValue}.`)
        console.log(err.error);
      }
    );
  };

  setBaseRates() {
    if(this.digimon[0].level === "Fresh"){
      this.catchRate = _FRESH_CATCH_RATE_;
      this.escapeRate = _FRESH_ESCAPE_RATE_;
    } else if (this.digimon[0].level === "In Training") {
      this.catchRate = _IN_TRAINING_CATCH_RATE_;
      this.escapeRate = _IN_TRAINING_ESCAPE_RATE_;
    } else if (this.digimon[0].level === "Rookie") {
      this.catchRate = _ROOKIE_CATCH_RATE_;
      this.escapeRate = _ROOKIE_ESCAPE_RATE_;
    } else if (this.digimon[0].level === "Champion") {
      this.catchRate = _CHAMPION_CATCH_RATE_;
      this.escapeRate = _CHAMPION_ESCAPE_RATE_;
    } else if (this.digimon[0].level === "Ultimate") {
      this.catchRate = _ULTIMATE_CATCH_RATE_;
      this.escapeRate = _ULTIMATE_ESCAPE_RATE_;
    } else {
      this.catchRate = _MEGA_CATCH_RATE_;
      this.escapeRate = _MEGA_ESCAPE_RATE_;
    }
  }

  throwBall(): void {
    this.message = 'You threw a ball!';
    let catchRoll: number = Math.floor(Math.random() * 101); // Random integer between 0 and 100
    if (catchRoll >= 100 - this.catchRate) { // successfully catches a pokemon if the roll is greater than the catch rate threshold
     this.message += ` You caught the ${this.digimon[0].name}!`;
      this.saveDigimon();
    } else {
      this.message += ` You failed to catch ${this.digimon[0].name}! The Digimon has become more nervous around you!`;
      this.escapeRate = this.escapeRate + 10; // Increases the escape chance by 10% if capture fails
      if (this.escapeRate > 100) {
        this.escapeRate = 100;
      }
      this.rollForEscape();
    }
  }

  throwBait(): void {
    this.catchRate = this.catchRate - (Math.floor(Math.random() * 5 + 1) * 5); // Reduce catch chance by anywhere from 5% to 25%
    this.escapeRate = this.escapeRate - (Math.floor(Math.random() * 5 + 1) * 5); // Reduce escape chance by anywhere from 5% to 25%

    if (this.catchRate < 5) {
      this.catchRate = 5;
    }

    if (this.escapeRate < 0) {
      this.escapeRate = 5;
    }

    this.message = `You threw some bait!`;
    this.rollForEscape();
  }

  throwRock(): void {
    this.catchRate = this.catchRate + 15; // Increase catch chance by 15%
    this.escapeRate = this.escapeRate + (Math.floor(Math.random() * 4 + 1) * 5); // Increase escape chance by anywhere from 5% to 20%

    if (this.catchRate > 100) {
      this.catchRate = 100;
    }

    if (this.escapeRate > 100) {
      this.escapeRate = 100;
    }
    this.message = `You threw a rock!`;
    this.rollForEscape();
  }

  rollForEscape(): void {
    let escapeRoll: number = Math.floor(Math.random() * 101); // Random integer between 0 and 100
    if (escapeRoll > 100 - this.escapeRate) {
      this.message += ` Oh no, the ${this.digimon[0].name} ran away!`;
      this.isEscaped = true;
    }
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
        this.message = `Warning: Failed to add ${this.digimon[0].name} to your collection due to a connection issue.`; // Add a retry method for this.
        console.log(err.error);
      });
  }
}
