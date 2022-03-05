import { ViaCepModel } from './../../models/via-cep-model';
import { ViaCepApiService } from './../../services/via-cep-api.service';
import { Component, OnInit } from '@angular/core';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-form-contato',
  templateUrl: './form-contato.component.html',
  styleUrls: ['./form-contato.component.scss']
})
export class FormContatoComponent implements OnInit {

  formContato: ViaCepModel = {};

  showForm = new Subject<boolean>();

  cepInput: string = '';

  constructor(private cepService: ViaCepApiService) { }

  ngOnInit(): void {
  }

  getViaCEP(cep: FocusEvent)
  {
    if ((cep.target as HTMLInputElement)?.value)
    {
      let inputCEP = (cep.target as HTMLInputElement)?.value;
      console.log(inputCEP);
      const cepResponse = this.cepService.getCep(inputCEP);
      cepResponse.subscribe(
        (cepModel) =>
        {
          this.formContato = cepModel;
          // só vai exibir o formulário se ele retornar algo
          this.showForm.next(true);
        }
      );
    }
  }
}
