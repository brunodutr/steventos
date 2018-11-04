import { Component, OnInit } from "@angular/core";
import { CidadeService } from "src/app/shared/service/cidades.service";
import { Evento } from "../evento.model";
import { EventoService } from "../eventos.service";
import { Local } from "src/app/shared/model/local.model";

@Component({
  selector: "app-eventos-list",
  templateUrl: "./eventos-list.component.html",
  styleUrls: ["./eventos-list.component.scss"]
})
export class EventosListComponent implements OnInit {
  eventos: Evento[] = [];
  local: Local;

  constructor(
    private service: EventoService,
    private cService: CidadeService
  ) {}

  async ngOnInit() {
    this.eventos = await this.service.getAll();
  }

  private setCidade(event: Local) {
    this.local = event;
  }
}
