import { Observable } from 'rxjs';
import { Animal } from './../models/animal';
import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ZooAnimalApiService {

  constructor(private http: HttpClient) { }

  public listaAnimals$ = new Observable<Animal[]>();

  getListAnimals(numberAnimals: number)
  {
    let url:string = `${environment.urlApiZoo}/animals/rand/${numberAnimals}`;
    this.listaAnimals$ = this.http.get<Animal[]>(url);
    return this.listaAnimals$;
  }

}
