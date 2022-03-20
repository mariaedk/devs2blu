import { DetailPokemonComponent } from './components/detail-pokemon/detail-pokemon.component';
import { ListPokemonsComponent } from './components/list-pokemons/list-pokemons.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path:'pokemons', component: ListPokemonsComponent},
  {path:'', redirectTo: '/pokemons', pathMatch: 'full'},
  {path:'pokemon/:name', component: DetailPokemonComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
