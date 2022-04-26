import { ProfessorService } from './../../../services/professor/professor.service';
import { Professor } from './../../../models/professor/professor';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-professor-list',
  templateUrl: './professor-list.component.html',
  styleUrls: ['./professor-list.component.scss']
})
export class ProfessorListComponent implements OnInit {

  listProfessor$ = new Observable<Professor[]>();

  constructor(private professorService: ProfessorService) { }

  ngOnInit(): void {
    this.listarProfessores();
  }

  listarProfessores()
  {
    this.listProfessor$ = this.professorService.getListProfessor();
  }

}
