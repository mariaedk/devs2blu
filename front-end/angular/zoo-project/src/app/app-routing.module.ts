import { InfoAnimalComponent } from './components/info-animal/info-animal.component';
import { ListAnimalsComponent } from './components/list-animals/list-animals.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'animals', component: ListAnimalsComponent},
  { path: '', redirectTo: '/animals', pathMatch:'full'},
  { path: 'info-animal', component: InfoAnimalComponent},
  { path: 'info-animal/:id', component: InfoAnimalComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
