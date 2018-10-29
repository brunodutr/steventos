import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Observable, of } from "rxjs";
import { debounceTime, startWith, switchMap } from "rxjs/operators";
import { CidadeService } from "../../shared/services/cidades.service";
import { Evento } from "../evento.model";
import { EventoService } from "../eventos.service";

@Component({
  selector: "app-eventos-form",
  templateUrl: "./eventos-form.component.html",
  styleUrls: ["./eventos-form.component.scss"]
})
export class EventosFormComponent implements OnInit {
  eventoForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private service: EventoService,
    private cService: CidadeService
  ) {}

  ngOnInit() {
    this.eventoForm = this.formBuilder.group({
      nome: ["", [Validators.required]],
      descricao: ["", Validators.required],
      dataIni: ["", Validators.required],
      dataFim: ["", [Validators.required]],
      cidade: ["", Validators.required]
    });
  }

  onSubmit() {
    let evento = new Evento(this.eventoForm.value);

    this.service.create(evento);
  }

  setCidade(event) {
    console.log(event);
    this.eventoForm.get("cidade").setValue(event);
  }
}
