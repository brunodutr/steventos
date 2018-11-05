import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Local } from "src/app/models/local.model";
import { SteventosService } from "../steventos.service";

@Injectable({
  providedIn: "root"
})
export class LocalService extends SteventosService<Local> {
  constructor(private _http: HttpClient) {
    super(_http, "locais");
  }
}
