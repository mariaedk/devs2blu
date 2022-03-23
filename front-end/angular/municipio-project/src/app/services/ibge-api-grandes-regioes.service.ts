import { GrandeRegiao } from './../models/grande-regiao';
import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class IbgeApiGrandesRegioesService {

  constructor(private http: HttpClient) { }

  getGrandeRegiao(idRegiao: any)
  {
    const url = `${environment.urlApiIbge}${idRegiao}`;
    return this.http.get<GrandeRegiao>(url);
  }
}
