import { ProfessorService } from './../../../services/professor/professor.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-professor-save',
  templateUrl: './professor-save.component.html',
  styleUrls: ['./professor-save.component.scss']
})
export class ProfessorSaveComponent implements OnInit {

  constructor(private professorService: ProfessorService) { }

  cadastroProfessor: any;

  ngOnInit(): void {
  }


}
