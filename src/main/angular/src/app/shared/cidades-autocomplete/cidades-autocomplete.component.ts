import { Component, OnInit, Output, EventEmitter, Input } from "@angular/core";
import { FormBuilder, FormGroup } from "@angular/forms";
import { Observable, of } from "rxjs";
import { debounceTime, startWith, switchMap } from "rxjs/operators";
import { CidadeService } from "../service/cidades.service";
import { Local } from "../model/local.model";

@Component({
  selector: "cidades-autocomplete",
  templateUrl: "./cidades-autocomplete.component.html",
  styleUrls: ["./cidades-autocomplete.component.scss"]
})
export class CidadesAutocomplete implements OnInit {
  cidadeForm: FormGroup;
  localObservable: Observable<Local[]>;

  @Input()
  searchFunction: Function;

  @Output("selected")
  selected = new EventEmitter<Local>();

  constructor(
    private cService: CidadeService,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit() {
    this.cidadeForm = this.formBuilder.group({
      cidade: [""]
    });

    this.localObservable = this.cidadeForm.get("cidade")!.valueChanges.pipe(
      startWith(""),
      debounceTime(500),
      switchMap(value => {
        if (value !== "") {
          return this.searchFunction(value);
        } else {
          return of(null);
        }
      })
    );
  }

  emit(event) {
    let local: Local = event.option.value;
    this.selected.emit(local);
    this.cidadeForm.get("cidade").setValue(local.cidade + " - " + local.estado);
  }
}
