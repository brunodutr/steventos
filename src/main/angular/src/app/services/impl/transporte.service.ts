import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Transporte } from "src/app/models/transporte.model";
import { SteventosService } from "../steventos.service";

@Injectable()
export class TransporteService extends SteventosService<Transporte> {
  constructor(private _http: HttpClient) {
    super(_http, "transportes");
  }
}
