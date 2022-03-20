import { ListAnimalsComponent } from './../list-animals/list-animals.component';
import { Animal } from './../../models/animal';
import { animationFrameScheduler, Observable } from 'rxjs';
import { ZooAnimalApiService } from './../../services/zoo-animal-api.service';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-info-animal',
  templateUrl: './info-animal.component.html',
  styleUrls: ['./info-animal.component.scss']
})
export class InfoAnimalComponent implements OnInit {

  constructor(private route: ActivatedRoute, private zooservice: ZooAnimalApiService) { }

  getAnimalId:any;
  animalObj: Animal = new Animal({});
  animalData: any;
  getId:any;
  getHabitat:any;

  ngOnInit(): void {
    this.getId = this.route.snapshot.paramMap.get('id');
    console.log(this.getId);
    this.zooservice.listaAnimals$.subscribe(
      listaAnimals => {
        // colocar console log e ver como esta a lista de animais
        // verificar se esta filtrando
        this.animalObj = listaAnimals.find(p => p.id == this.getId) ?? new Animal({});
      }
    )
    if (this.getId)
    {
      this.getId
    }
  }
}
