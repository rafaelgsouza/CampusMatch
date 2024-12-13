export class Estudante {

    id!: number;
    email: string;
    senha: string;
    cep: string;
    nome: string;
    dataNascimento: Date;

    public constructor(){
        this.email = '';
        this.senha = '';
        this.cep = '';
        this.nome = '';
        this.dataNascimento = new Date();
    }
}
