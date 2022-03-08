import { MunicipiosModel } from './../models/municipios.model';
import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class IbgeApiService {

  constructor(private http: HttpClient) { }

  getCidadesByUF(uf: string)
  {
    const url = `${environment.urlApiCidades}/${uf}/municipios`;
    return this.http.get<MunicipiosModel>(url);
  }
}
