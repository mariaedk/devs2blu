import { Pokemon } from './../../models/pokemon/pokemon';
import { PokeApiService } from './../../services/poke-api.service';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-detail-pokemon',
  templateUrl: './detail-pokemon.component.html',
  styleUrls: ['./detail-pokemon.component.scss']
})
export class DetailPokemonComponent implements OnInit {

  pokemonObj: Pokemon = new Pokemon({});

  constructor(private route: ActivatedRoute,
              private pokemonService: PokeApiService) { }

  ngOnInit(): void {
    let name = this.route.snapshot.paramMap.get('name');
    if (name)
    {
      this.pokemonService.getPokemonByNameOrId(name);
    }
  }

}
