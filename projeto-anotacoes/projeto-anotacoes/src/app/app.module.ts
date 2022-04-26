import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { AnotacoesListComponent } from './components/anotacoes/anotacoes-list/anotacoes-list.component';
import { AnotacoesAddComponent } from './components/anotacoes/anotacoes-add/anotacoes-add.component';
import { CategoriaListComponent } from './components/categoria/categoria-list/categoria-list.component';
import { CategoriaAddComponent } from './components/categoria/categoria-add/categoria-add.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    AnotacoesListComponent,
    AnotacoesAddComponent,
    CategoriaListComponent,
    CategoriaAddComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
