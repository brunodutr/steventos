import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Local } from "src/app/shared/model/local.model";
import { CidadeService } from "../../shared/service/cidades.service";
import { Evento } from "../evento.model";
import { EventoService } from "../eventos.service";

@Component({
  selector: "app-eventos-form",
  templateUrl: "./eventos-form.component.html",
  styleUrls: ["./eventos-form.component.scss"]
})
export class EventosFormComponent implements OnInit {
  eventoForm: FormGroup;

  local: Local;

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
    let ctrl = this.eventoForm.controls;

    let evento = new Evento(
      ctrl.nome.value,
      ctrl.descricao.value,
      ctrl.dataIni.value,
      ctrl.dataFim.value,
      this.local
    );

    this.service.create(evento);
  }

  setCidade(event: Local) {
    this.local = event;
  }
}
