import { ResponseLink } from './../../models/pokemon/response-link';
import { PokeApiService } from './../../services/poke-api.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable, Subject } from 'rxjs';

@Component({
  selector: 'app-list-pokemons',
  templateUrl: './list-pokemons.component.html',
  styleUrls: ['./list-pokemons.component.scss']
})
export class ListPokemonsComponent implements OnInit {

  // observable -> fica observando se vem uma resposta da requisição da api
  listPokemon$ = new Subject<ResponseLink[]>();

  urlSpriteFront: string = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon";

  constructor(private route: ActivatedRoute,
              private pokemonService: PokeApiService) { }

  ngOnInit(): void {

    this.pokemonService
    .getListPokemons(undefined, 0, 898)
    .subscribe(
      (response) => {
        this.listPokemon$.next(response.results);
      }
    );
  }
}
