import { Component, OnInit } from "@angular/core";
import { EventoService } from "../eventos.service";
import { Evento } from "../evento.model";

@Component({
  selector: "app-eventos-list",
  templateUrl: "./eventos-list.component.html",
  styleUrls: ["./eventos-list.component.scss"]
})
export class EventosListComponent implements OnInit {
  eventos: Evento[] = [];

  constructor(private service: EventoService) {}

  async ngOnInit() {
    this.eventos = await this.service.getAll();
  }

  private cidadesValue(event) {
    console.log(event);
  }
}
