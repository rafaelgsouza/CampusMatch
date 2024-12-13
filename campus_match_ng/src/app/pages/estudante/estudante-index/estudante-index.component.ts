import { Component } from '@angular/core';
import { EstudanteService } from '../../../services/estudante/estudante.service';
import { Estudante } from '../../../models/estudante.model';

@Component({
  selector: 'app-estudante-index',
  templateUrl: './estudante-index.component.html',
  styleUrl: './estudante-index.component.css'
})
export class EstudanteIndexComponent {

  estudantes:Estudante[];
  id: Number | null;
  nome: string;

  constructor(
    private estudanteService:EstudanteService){

      this.estudantes = [];
      this.id = null;
      this.nome = '';
  }

  definirPesquisa():void{

    console.log(this.id);
    console.log(this.nome);

    if(this.id !== null){
      this.pesquisarPorId(Number(this.id));
      return;
    }

    if(this.nome !== ''){
      this.pesquisarPorNome();
      return;
    }

    this.pesquisar();
  }

  pesquisar():void{
    this.estudanteService.get().subscribe({
      next: (jsonEstudantes:Estudante[]) => {
        this.estudantes = jsonEstudantes
      },
      error: (jsonError: any) => {
        console.log(jsonError.status)
      }
    });
  }

  pesquisarPorId(id:number):void{
    this.estudanteService.getById(id).subscribe({
      next: (jsonEstudante:Estudante) =>{
        this.estudantes = [jsonEstudante];
      },
      error: (jsonError: any) => {
        console.log(jsonError.status)
      } 
    });
    this.id = null;
  }

  pesquisarPorNome():void{
    this.estudanteService.getByName(this.nome).subscribe({
      next: (jsonEstudante:Estudante[]) =>{
        this.estudantes = jsonEstudante;
      },
      error: (jsonError: any) => {
        console.log(jsonError.status)
      }
    });
  }
}
