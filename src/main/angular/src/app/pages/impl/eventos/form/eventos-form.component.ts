import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Local } from "src/app/models/local.model";
import { EventoService } from "src/app/services/impl/eventos.service";
import { CidadeService } from "src/app/services/cidades.service";
import { Evento } from "src/app/models/evento.model";
import { Pessoa } from "src/app/models/pessoa.model";
import { DisplayAutocomplete } from "src/app/interface/display.autocomplete";

@Component({
  selector: "app-eventos-form",
  templateUrl: "./eventos-form.component.html",
  styleUrls: ["./eventos-form.component.scss"]
})
export class EventosFormComponent implements OnInit {
  eventoForm: FormGroup;

  local: Local;
  displayFn: Function;

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

    this.displayFn = Local.display();
    this.service.getPessoas(4).subscribe((res: Pessoa[]) => console.log(res));
  }

  onSubmit() {
    let ctrl = this.eventoForm.controls;

    const evento: Evento = new Evento({
      nome: ctrl.nome.value,
      descricao: ctrl.descricao.value,
      dataIni: ctrl.dataIni.value,
      dataFim: ctrl.dataFim.value,
      local: this.local
    });

    this.service.create(evento);
  }
}
