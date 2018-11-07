import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Pessoa } from "src/app/models/pessoa.model";
import { SteventosService } from "../steventos.service";

@Injectable({
  providedIn: "root"
})
export class PessoaService extends SteventosService<Pessoa> {
  constructor(private _http: HttpClient) {
    super(_http, "pessoas");
  }

  findByEmail(email: string) {
    return this._http.get<Pessoa>(`${this.URL_REST}/email`, {
      params: {
        email
      }
    });
  }
}
