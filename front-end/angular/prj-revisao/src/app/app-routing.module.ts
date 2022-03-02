import { HomeComponent } from './components/home/home.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  // Carrega o homecomponent e todos os components que o compõe
  {path: 'home', component: HomeComponent},
  // quando  não tiver nada, redireciona para home. pathmatch:full = passa o caminho inteiro
  {path: '', redirectTo: '/home', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
