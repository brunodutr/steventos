import { DisplayAutocomplete } from "../interface/display.autocomplete";

export class Local implements DisplayAutocomplete<Local> {
  readonly type: string = Local.name;
  private id: number;

  private cidade: string;

  private estado: string;

  constructor(object?: any) {
    Object.assign(this, object);
  }

  display(object?: Local): string {
    return object ? `${object.cidade} - ${object.estado}` : undefined;
  }

  static display(): Function {
    return new Local().display.bind(this);
  }
}
