import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ProfessorComponent } from './components/professor/professor.component';
import { AlunoComponent } from './components/aluno/aluno.component';
import { PessoaComponent } from './components/pessoa/pessoa.component';
import { PessoaListComponent } from './components/pessoa/pessoa-list/pessoa-list.component';
import { PessoaSaveComponent } from './components/pessoa/pessoa-save/pessoa-save.component';
import { AlunoSaveComponent } from './components/aluno/aluno-save/aluno-save.component';
import { AlunoListComponent } from './components/aluno/aluno-list/aluno-list.component';
import { ProfessorListComponent } from './components/professor/professor-list/professor-list.component';
import { ProfessorSaveComponent } from './components/professor/professor-save/professor-save.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ProfessorComponent,
    AlunoComponent,
    PessoaComponent,
    PessoaListComponent,
    PessoaSaveComponent,
    AlunoSaveComponent,
    AlunoListComponent,
    ProfessorListComponent,
    ProfessorSaveComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
