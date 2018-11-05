import { Local } from "./local.model";

export class Hospedagem {
  private id: number;

  private nome: string;

  private local: Local;

  constructor(object?: Hospedagem) {
    Object.assign(this, object);
  }
}
