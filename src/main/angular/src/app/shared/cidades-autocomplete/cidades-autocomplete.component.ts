import { Component, OnInit, Output, EventEmitter } from "@angular/core";
import { FormBuilder, FormGroup } from "@angular/forms";
import { Observable, of } from "rxjs";
import { debounceTime, startWith, switchMap } from "rxjs/operators";
import { CidadeService } from "../services/cidades.service";

@Component({
  selector: "cidades-autocomplete",
  templateUrl: "./cidades-autocomplete.component.html",
  styleUrls: ["./cidades-autocomplete.component.scss"]
})
export class CidadesAutocomplete implements OnInit {
  cidadeForm: FormGroup;
  cidadesOptions: Observable<any[]>;

  @Output("selected")
  selected = new EventEmitter<string>();

  constructor(
    private cService: CidadeService,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit() {
    this.cidadeForm = this.formBuilder.group({
      cidade: [""]
    });

    this.cidadesOptions = this.cidadeForm.get("cidade")!.valueChanges.pipe(
      startWith(""),
      debounceTime(500),
      switchMap(value => {
        if (value !== "") {
          return this.cService.getCidades(value);
        } else {
          return of(null);
        }
      })
    );
  }

  emit(event) {
    console.log(event);
    this.selected.emit(event.option.value);
  }
}
