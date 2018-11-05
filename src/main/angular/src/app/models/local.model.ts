export class Local {
  id: number;

  cidade: string;

  estado: string;

  constructor(object?: Local) {
    Object.assign(this, object);
  }
}
