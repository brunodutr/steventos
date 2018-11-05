import { NgModule } from "@angular/core";
import { CidadesAutocomplete } from "../shared/cidades-autocomplete/cidades-autocomplete.component";
import { ReactiveFormsModule, FormsModule } from "@angular/forms";
import { CommonModule } from "@angular/common";
import { SharedMaterial } from "../material/shared.material";

@NgModule({
  imports: [CommonModule, SharedMaterial, FormsModule, ReactiveFormsModule],
  declarations: [CidadesAutocomplete],
  exports: [CidadesAutocomplete]
})
export class SharedModule {}
