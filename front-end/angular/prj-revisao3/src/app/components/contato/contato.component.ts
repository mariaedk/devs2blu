import { MunicipiosModel } from './../../models/municipios.model';
import { IbgeApiService } from './../../services/ibge-api.service';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-contato',
  templateUrl: './contato.component.html',
  styleUrls: ['./contato.component.scss']
})
export class ContatoComponent implements OnInit {

  cidades$ = new Observable<MunicipiosModel>();
  constructor(private ibgeService: IbgeApiService) { }

  ngOnInit(): void {
    this.loadMunicipiosByUF('SC');
  }

  loadMunicipiosByUF(event: any)
  {
    const uf = (event.target as HTMLSelectElement).value;
    this.cidades$ = this.ibgeService.getCidadesByUF(uf);
    // this.ibgeService
    //     .getCidadesByUF(uf)
    //     .subscribe(
    //     (response) => {
    //       console.log(response);
    //     }
    //   );
  }

}
