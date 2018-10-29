export class Evento {
  cidade: string;

  descricao: string;

  dataFim: Date;

  id: number;

  dataIni: Date;

  nome: string;

  constructor(object?) {
    Object.assign(this, object);
  }
}
