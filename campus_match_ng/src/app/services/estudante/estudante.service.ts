import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Estudante } from '../../models/estudante.model';

@Injectable({
  providedIn: 'root'
})
export class EstudanteService {

  constructor(private httpClient:HttpClient) { }

  get():Observable<Estudante[]>{
    return this.httpClient.get<Estudante[]>('http://localhost:8080/estudantes/get_all')
  }

  getById(id: number):Observable<Estudante>{
    return this.httpClient.get<Estudante>(`http://localhost:8080/estudantes/${id}`)
  }

  getByName(nome:string):Observable<Estudante[]>{
    return this.httpClient.get<Estudante[]>(`http://localhost:8080/estudantes?nome=${nome}`)
  }

  post(estudante: Estudante):Observable<Estudante>{
    return this.httpClient.post<Estudante>(`http://localhost:8080/estudantes/save`, estudante)
  }

  put(estudante: Estudante):Observable<Estudante>{
    return this.httpClient.put<Estudante>(`http://localhost:8080/estudantes/editEstudante/${estudante.id}`, estudante)
  }

  delete(id: number):Observable<Estudante>{
    return this.httpClient.delete<Estudante>(`http://localhost:8080/estudantes/deleteEstudante/${id}`)
  }
}
