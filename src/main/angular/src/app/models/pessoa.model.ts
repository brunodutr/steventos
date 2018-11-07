export class Pessoa {
  readonly type: string = Pessoa.name;
  private id: number;

  private nome: string;

  private email: string;

  private dataNascimento: Date;

  constructor(object?: any) {
    Object.assign(this, object);
  }
}
