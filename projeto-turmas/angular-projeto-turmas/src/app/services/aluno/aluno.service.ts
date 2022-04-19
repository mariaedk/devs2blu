import { Aluno } from './../../models/aluno/aluno';
import { environment } from './../../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AlunoService {

  nomeAluno: string = "";
  idadeAluno: number = 0;
  enderecoAluno: string = "";
  sexoAluno: string = "";
  anoAluno: number = 0;
  jsonObject: JSON;
  arrayObj: any;

  constructor(private http: HttpClient) {
    this.jsonObject = <JSON>this.arrayObj;
  }

  // get all
  getListAluno()
  {
    const urlGet = `${environment.urlApi}/aluno`;
    return this.http.get<Aluno[]>(urlGet);
  }

  // post
  postAluno(alunoJson: JSON)
  {
    const urlGet = `${environment.urlApi}/aluno`;
    return this.http.post<Aluno>(urlGet, alunoJson);
  }

  getAlunoById(id: number)
  {
    return this.http.get<Aluno>(`${environment.urlApi}/aluno/${id}`)
  }
  // meu jeito
  getAlunoJson()
  {
    this.nomeAluno = (<HTMLInputElement>document.getElementById("nomeAluno")).value;
    this.idadeAluno = parseInt((<HTMLInputElement>document.getElementById("idadeAluno")).value);
    this.anoAluno = parseInt((<HTMLInputElement>document.getElementById("anoAluno")).value);
    this.enderecoAluno = (<HTMLInputElement>document.getElementById("enderecoAluno")).value;
    this.sexoAluno = (<HTMLInputElement>document.getElementById("sexoAluno")).value;

    this.arrayObj =
    {
      "ano": this.anoAluno,
      "pessoa": {
          "nome": this.nomeAluno,
          "idade": this.idadeAluno,
          "endereco": this.enderecoAluno,
          "sexo": this.sexoAluno
        }
    }
    return this.arrayObj;
  }
}
