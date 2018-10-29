import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Evento } from "./evento.model";

const EVENTOS_REST = "http://localhost:8080/rest/eventos";

@Injectable({
  providedIn: "root"
})
export class EventoService {
  constructor(private http: HttpClient) {}

  getAll(): Promise<Evento[]> {
    return this.http
      .get(EVENTOS_REST)
      .toPromise()
      .then((res: Evento[]) => {
        return res;
      });
  }

  create(evento: Evento) {
    return this.http
      .post(EVENTOS_REST, evento)
      .toPromise()
      .then(res => {
        console.log(res);
      });
  }
}
