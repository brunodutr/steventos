import { Local } from "./local.model";

export class Transporte {
  private valor: number;

  private origem: Local;

  private destino: Local;

  constructor(object?: Transporte) {
    Object.assign(this, object);
  }
}
