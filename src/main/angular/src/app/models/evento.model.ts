import { Local } from "./local.model";

export class Evento {
  private id: number;

  private nome: string;

  private descricao: string;

  private local: Local;

  private dataFim: Date;

  private dataIni: Date;

  readonly type: string = Evento.name;

  constructor(object?: any) {
    Object.assign(this, object);
  }
}
