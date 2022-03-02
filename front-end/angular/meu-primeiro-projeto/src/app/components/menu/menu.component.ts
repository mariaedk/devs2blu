import { Menu } from './../../models/interface/menu';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  // array do tipo Menu (arquivo .ts) (em models/interface)
  objMenu: Menu[] = [
    {title: 'Home', url:'/home'}, // objeto Menu com atributos relacionados a pagina Home
    {title: 'Contato', url:'/contato'} // objeto Menu com atributos relacionados a pagina Contato
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
