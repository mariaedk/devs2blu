import { Animal } from './../../models/animal';
import { ZooAnimalApiService } from './../../services/zoo-animal-api.service';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-list-animals',
  templateUrl: './list-animals.component.html',
  styleUrls: ['./list-animals.component.scss']
})
export class ListAnimalsComponent implements OnInit {

  constructor(private zooanimal: ZooAnimalApiService) { }

  animals = new Observable<Animal[]>();

  ngOnInit(): void {
    this.animals = this.zooanimal.getListAnimals(6);
  }
}
