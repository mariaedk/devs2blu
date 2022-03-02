import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import CepModel from '../models/cep-model';
// http client para acessar api
@Injectable({
  providedIn: 'root'
})
export class ViaCepApiService {
  // declara a url da api
  urlViaCep: string = 'https://viacep.com.br/ws';
  // precisa de um cliente que permita conectar externamente:
  constructor(private http: HttpClient) { }
  // método que recebe string como parametro
  getCEP(cep:string)
  {
    const urlGet = `${this.urlViaCep}/${cep}/json/`;
    // <CepModel> = o que retorna segue o formato CepModel
    return this.http.get<CepModel>(urlGet);
  }
}
