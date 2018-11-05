import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Evento } from "src/app/models/evento.model";
import { SteventosService } from "../steventos.service";

@Injectable()
export class EventoService extends SteventosService<Evento> {
  constructor(private _http: HttpClient) {
    super(_http, "eventos");
  }

  getPessoas(id: number) {
    return this.getField(id, "pessoas");
  }
}
