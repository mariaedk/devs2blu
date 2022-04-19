import { AlunoService } from './../../../services/aluno/aluno.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-aluno-save',
  templateUrl: './aluno-save.component.html',
  styleUrls: ['./aluno-save.component.scss']
})
export class AlunoSaveComponent implements OnInit {

  cadastroAluno: any;
  constructor(private alunoService: AlunoService) { }

  ngOnInit(): void {

  }

  // meu jeito
  addAluno()
  {
    this.cadastroAluno = this.alunoService.getAlunoJson();
    this.alunoService.postAluno(this.cadastroAluno).subscribe((response)=>{
      console.log("Foi");
    });
  }
}

