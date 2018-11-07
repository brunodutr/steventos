import { Local } from "./local.model";

export class Evento {
  readonly type: string = Evento.name;

  private id: number;

  private nome: string;

  private descricao: string;

  private local: Local;

  private dataFim: Date;

  private dataIni: Date;

  constructor(object?: any) {
    Object.assign(this, object);
  }
}
