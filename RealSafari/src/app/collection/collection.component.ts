import { Component, OnInit } from '@angular/core';
import { Digimon } from '../services/encounter.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-collection',
  templateUrl: './collection.component.html',
  styleUrls: ['./collection.component.scss']
})
export class CollectionComponent implements OnInit {

  digimon: Digimon[] = [];

  constructor(private httpClient: HttpClient) { }

  infoToggled = false;

  ngOnInit() {
    this.httpClient.get<Digimon[]>('http://localhost:8080/project5/users?user=', {
      withCredentials: true
    })
      .subscribe(data => {
        console.log(data);
        this.digimon = data;
      }, err => {
        console.log(err);
      });
  }

  toggleInfo() {
    this.infoToggled = !this.infoToggled;
  }

}