import { ViaCep } from './../models/via-cep';
import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiViaCepService {

  constructor(private http: HttpClient) {  }

  getEnderecoByCEP(cep: string)
  {
    // Esta variável vai conter o caminho para acessar o endereço na web, e estes dados vão ser fornecidos pelo usuário
    const urlGet = `${environment.urlApiViaCep}/${cep}/json/`;

    // retorna um objeto genérico pois não foi passado o tipo
    // Retorna um Observable da API
    return this.http.get<ViaCep>(urlGet);
  }
}
