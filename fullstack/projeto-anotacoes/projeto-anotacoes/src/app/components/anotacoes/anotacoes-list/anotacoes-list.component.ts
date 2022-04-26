import { Categoria } from './../../../models/categoria';
import { CategoriaService } from './../../../services/categoria.service';
import { Component, OnInit } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Component({
  selector: 'app-anotacoes-list',
  templateUrl: './anotacoes-list.component.html',
  styleUrls: ['./anotacoes-list.component.scss']
})
export class AnotacoesListComponent implements OnInit {

  constructor(categoriaService: CategoriaService) { }



  ngOnInit(): void
  {

  }

  getListAnotacoes()
  {

  }

}
