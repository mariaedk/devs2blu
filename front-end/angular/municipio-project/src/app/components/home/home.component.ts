import { GrandeRegiao } from './../../models/grande-regiao';
import { IbgeApiGrandesRegioesService } from './../../services/ibge-api-grandes-regioes.service';
import { Component, OnInit } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  showInfo = new Subject<boolean>();
  regioes$ = new Observable<GrandeRegiao>();

  constructor(private ibgeService: IbgeApiGrandesRegioesService) { }

  ngOnInit(): void {
  }

  getMunicipio(event: any)
  {
    const regiao = (event.target as HTMLSelectElement).value;
    if (regiao)
    {
      this.regioes$ = this.ibgeService.getGrandeRegiao(regiao);
      this.ibgeService.getGrandeRegiao(regiao).subscribe(
        (response) => {
          console.log(response);
        }
      )
    }
  }
}
