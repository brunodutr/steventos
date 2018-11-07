export class Pessoa {
  readonly type: string = Pessoa.name;
  private id: number;

  private nome: string;

  private email: string;

  private dataNascimento: Date;

  private perfil: number;

  constructor(object?: any) {
    this.nome = object.nome;
    this.email = object.email;
    this.dataNascimento = object.dataNascimento;
    this.perfil = object.perfil;
  }
}
