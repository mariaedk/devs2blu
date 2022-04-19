import { Professor } from './../../models/professor/professor';
import { environment } from './../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProfessorService {


  constructor(private http: HttpClient) {

   }

  getListProfessor()
  {
    const urlGet = `${environment.urlApi}/professor`;
    return this.http.get<Professor[]>(urlGet);
  }

  postProfessor(professorJson: JSON)
  {
    const urlGet = `${environment.urlApi}/professor`;
    return this.http.post<Professor>(urlGet, professorJson);
  }

}
