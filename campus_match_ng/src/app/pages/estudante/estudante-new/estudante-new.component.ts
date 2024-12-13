import { Component } from '@angular/core';
import { EstudanteService } from '../../../services/estudante/estudante.service';
import { Router } from '@angular/router';
import { Estudante } from '../../../models/estudante.model';

@Component({
  selector: 'app-estudante-new',
  templateUrl: './estudante-new.component.html',
  styleUrl: './estudante-new.component.css'
})
export class EstudanteNewComponent {

  estudante:Estudante;

  constructor(
    private estudanteService:EstudanteService, 
    private router:Router){
      this.estudante = new Estudante(); 
  }

  salvar():void{
    this.estudanteService.post(this.estudante).subscribe({
      next: () =>{
        alert('Estudante adicionado com sucesso.')
        this.router.navigate(['/estudantes'])
      } 
    });
  }

  exibirMensagemErro(status: Number):boolean{
    let message: string = '';

    if(status === 0){
      message = "Falha na requisição. \nEntre em contato com o suporte!";
    } else if(status === 400){
      message = "Verifique os dados que estão sendo enviados.";
    } else if(status === 404){
      message = "Nenhum estudante encontrado.";
    } else if(status === 500){
      message = "Erro interno do servidor.";
    }

    console.log(message);

    return true
  }

  validarDadosExibirMensagem():boolean{
    let msg:string = '';

    if(this.estudante.nome === ''){
      msg += 'Nome\n';
    }
    if(this.estudante.email === ''){
      msg += 'Email\n';
    }
    if(this.estudante.senha === ''){
      msg += 'Senha\n';
    }
    if(this.estudante.cep === ''){
      msg += 'Cep\n';
    }
    if(this.estudante.dataNascimento.toString() === ''){
      msg += 'Data Fabricação\n';
    }

    if(msg !== ''){
      msg = 'Preencha corretamente os dados a seguir:\n' + msg;
      alert(msg);
      return false;
    }

    return true;
  }
}
