import { Categoria } from './../../../models/categoria';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { CategoriaService } from './../../../services/categoria.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-categoria-list',
  templateUrl: './categoria-list.component.html',
  styleUrls: ['./categoria-list.component.scss']
})
export class CategoriaListComponent implements OnInit {

  constructor(private service: CategoriaService, private http: HttpClient) { }

  listaCategorias = new Observable<Categoria[]>();

  ngOnInit(): void
  {
    this.list();
  }

  list()
  {
    this.listaCategorias = this.service.getCategorias();
  }

  delete(id?: number)
  {
    if (!id)
    {
      return;
    }
    this.service.deleteCategoria(id || 0).subscribe(
      (resp) =>
        // se a resposta for verdadeira, executa this.list, se não, executa o ''
        resp ? this.list : ''
    );
  }

  toggleAtivo(id?: number)
  {
    if (!id)
    {
      return;
    }
    this.service.toggleAtivo(id || 0);
  }
}
