import { Filme } from './../models/filme';
import { Injectable } from '@angular/core';
import { Firestore, collectionData, collection } from '@angular/fire/firestore';
import { Observable } from 'rxjs';
import { AngularFirestore, AngularFirestoreCollection } from '@angular/fire/compat/firestore';

@Injectable({
  providedIn: 'root'
})
export class FilmesService {
  // declarou os filmes
  filmes$: Observable<Filme[]>;

  filmesCollection: AngularFirestoreCollection<Filme>;

  constructor(private firestore: Firestore, private afs: AngularFirestore)
  {
    this.filmesCollection = this.afs.collection<Filme>('filmes');
    // ao injetar a classe ele ja vai conectar
    const collect = collection(this.firestore, 'filmes');
    this.filmes$ = collectionData(collect);
  }

  getListFilmes()
  {
    // subscribe é quando tem a informação (array de filmes)
    this.filmes$.subscribe(
      (ltFilmes) => {
        console.log(ltFilmes);
      }
    )
    // retornando a lista de filmes
    return this.filmes$;
  }

  addFilme(filme: Filme)
  {
    this.filmesCollection.add(filme);
  }
}
