import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-encounter',
  templateUrl: './encounter.component.html',
  styleUrls: ['./encounter.component.css']
})
export class EncounterComponent implements OnInit {
  private catchRate: number; // base rate determined by digimon evolution
  private escapeRate: number; // base rate determined by digimon evolution
  // private digimon: Digimon; // Will need to feed a digimon into this

  constructor() { }

  ngOnInit() {
  }


  throwBall(): void {
    let catchRoll: number = Math.floor(Math.random()*101); // Random integer between 0 and 100
    if(catchRoll + (this.catchRate * 5) >= 100){ // 100% catch rate
      // Call successful catch method
    }
  }

  throwBait(): void{
    this.catchRate = this.catchRate - Math.floor(Math.random()*5 + 1); // Reduce catch chance by anywhere from 5% to 25%
    this.escapeRate = this.escapeRate - Math.floor(Math.random()*5 + 1); // Reduce escape chance by anywhere from 5% to 25%

    if(this.catchRate < 1) {
      this.catchRate = 1;
    }

    if(this.escapeRate < 0){
      this.escapeRate = 1;
    }

    this.rollForEscape();
  }

  throwRock(): void{
    this.catchRate = this.catchRate + 3; // Increase catch chance by 15%
    this.escapeRate = this.escapeRate + Math.floor(Math.random()*4 + 1); // Increase escape chance by anywhere from 5% to 20%

    if(this.catchRate > 20){
      this.catchRate = 20;
    }

    if(this.escapeRate > 20){
      this.escapeRate = 20;
    }

    this.rollForEscape();
  }

  rollForEscape(): void {
    let escapeRoll: number = Math.floor(Math.random()*101); // Random integer between 0 and 100
    if((escapeRoll - 100 + (this.escapeRate * 5)) > 0) {
      // Digimon will flee
    } 
    // Add some logic to give a hint to the user if the Digimon is close to fleeing and/or has a high catch rate
  }
}
