import { Aluno } from './../../../models/aluno/aluno';
import { AlunoService } from './../../../services/aluno/aluno.service';
import { Component, OnInit } from '@angular/core';
import { Subject, Observable } from 'rxjs';

@Component({
  selector: 'app-aluno-list',
  templateUrl: './aluno-list.component.html',
  styleUrls: ['./aluno-list.component.scss']
})


export class AlunoListComponent implements OnInit {

  listAluno$ = new Observable<Aluno[]>();
  constructor(private alunoService: AlunoService) { }

  ngOnInit(): void
  {
    this.listarAlunos();
  }

  listarAlunos()
  {
    this.listAluno$ = this.alunoService.getListAluno();
  }
}

