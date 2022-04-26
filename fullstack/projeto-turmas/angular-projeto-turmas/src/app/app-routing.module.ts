import { AlunoSaveComponent } from './components/aluno/aluno-save/aluno-save.component';
import { AlunoListComponent } from './components/aluno/aluno-list/aluno-list.component';
import { AlunoComponent } from './components/aluno/aluno.component';
import { ProfessorSaveComponent } from './components/professor/professor-save/professor-save.component';
import { ProfessorListComponent } from './components/professor/professor-list/professor-list.component';
import { ProfessorComponent } from './components/professor/professor.component';
import { PessoaSaveComponent } from './components/pessoa/pessoa-save/pessoa-save.component';
import { PessoaListComponent } from './components/pessoa/pessoa-list/pessoa-list.component';
import { PessoaComponent } from './components/pessoa/pessoa.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'pessoa', component: PessoaComponent },
  { path: 'pessoa-list', component: PessoaListComponent },
  { path: 'pessoa-save', component: PessoaSaveComponent },
  { path: 'professor', component: ProfessorComponent },
  { path: 'professor-list', component: ProfessorListComponent },
  { path: 'professor-save', component: ProfessorSaveComponent },
  { path: 'aluno', component: AlunoComponent },
  { path: 'aluno-list', component: AlunoListComponent },
  { path: 'aluno-save', component: AlunoSaveComponent },
  { path: '', redirectTo: '/', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
