import { Component, EventEmitter, Input, OnInit, Output } from "@angular/core";
import { FormBuilder, FormGroup } from "@angular/forms";
import { Observable, of } from "rxjs";
import { debounceTime, startWith, switchMap } from "rxjs/operators";
import { Local } from "../../models/local.model";

@Component({
  selector: "cidades-autocomplete",
  templateUrl: "./cidades-autocomplete.component.html",
  styleUrls: ["./cidades-autocomplete.component.scss"]
})
export class CidadesAutocomplete implements OnInit {
  cidadeForm: FormGroup;
  localObservable: Observable<Local[]>;

  @Input()
  display: Function;

  @Input()
  searchFunction: Function;

  @Input()
  value: Local;

  @Output()
  valueChange = new EventEmitter<Local>();

  constructor(private formBuilder: FormBuilder) {}

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
    this.value = event.option.value;
    this.valueChange.emit(this.value);
  }
}
