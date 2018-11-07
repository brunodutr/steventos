import { Local } from "./local.model";

export class Hospedagem {
  readonly type: string = Hospedagem.name;

  private id: number;

  private nome: string;

  private local: Local;

  constructor(object?: any) {
    Object.assign(this, object);
  }
}
