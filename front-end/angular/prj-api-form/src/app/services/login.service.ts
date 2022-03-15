import { environment } from './../../environments/environment';
import { Login } from './../models/login';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor() { }

  doLogin(user: Login)
  {
    // verificando se a informação que o usuário passou é a correta
    // numa aplicação real, pegaria do banco de dados
    if (user.login == environment.loginUser && user.pass == environment.passwordUser)
    {
      localStorage.setItem('login', user.login);
      localStorage.setItem('pass', user.pass);
      localStorage.setItem('isLogged', 'true');
    }
    else
    {
      return false;
    }

    return true;
  }
}
