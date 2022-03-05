import { ViaCepModel } from './../models/via-cep-model';
import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

// injectable = cria uma classe que pode ser injetada em vários lugares
@Injectable({
  providedIn: 'root'
})

// get dados
export class ViaCepApiService {

  constructor(private http: HttpClient) {  }

  getCep(cep: string)
  {
    // faz comunicação com api's externas
    const urlGet = `${environment.urlApiViaCep}${cep}/json/`;
    return this.http.get<ViaCepModel>(urlGet);
  }

}
