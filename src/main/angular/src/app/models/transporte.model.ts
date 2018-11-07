import { Local } from "./local.model";

export class Transporte {
  readonly type: string = Transporte.name;

  private valor: number;

  private origem: Local;

  private destino: Local;

  constructor(object?: any) {
    Object.assign(this, object);
  }
}
