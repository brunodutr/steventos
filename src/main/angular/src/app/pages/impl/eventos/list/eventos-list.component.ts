import { Component, OnInit } from "@angular/core";
import { Observable } from "rxjs";
import { Evento } from "src/app/models/evento.model";
import { Local } from "src/app/models/local.model";
import { CidadeService } from "src/app/services/cidades.service";
import { EventoService } from "src/app/services/impl/eventos.service";

@Component({
  selector: "app-eventos-list",
  templateUrl: "./eventos-list.component.html",
  styleUrls: ["./eventos-list.component.scss"]
})
export class EventosListComponent implements OnInit {
  eventos: Observable<Evento[]>;
  local: Local;
  displayFn: Function;

  constructor(
    private service: EventoService,
    private cService: CidadeService
  ) {}

  ngOnInit() {
    this.displayFn = Local.display();
    this.eventos = this.service.getAll();

    this.service.getAll().subscribe((res: Evento[]) => {
      console.log(res);
    });
  }
}
