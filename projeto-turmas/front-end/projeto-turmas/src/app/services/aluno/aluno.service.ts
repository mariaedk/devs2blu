import { Aluno } from './../../models/aluno/aluno';
import { environment } from './../../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AlunoService {

  constructor(private http: HttpClient) { }

  getListAluno()
  {
    const urlGet = `${environment.urlApi}/aluno`;
    return this.http.get<Aluno[]>(urlGet);
  }
}
