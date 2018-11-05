import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Hospedagem } from "src/app/models/hospedagem.model";
import { SteventosService } from "../steventos.service";

@Injectable()
export class HospedagemService extends SteventosService<Hospedagem> {
  constructor(private _http: HttpClient) {
    super(_http, "hospedagens");
  }
}
