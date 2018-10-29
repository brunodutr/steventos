import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { RouterModule, Routes } from "@angular/router";
import { SharedModule } from "../shared/shared.module";
import { EventosFormComponent } from "./eventos-form/eventos-form.component";
import { EventosListComponent } from "./eventos-list/eventos-list.component";
import { EventosMaterial } from "./eventos.material";

const routes: Routes = [
  {
    path: "",
    component: EventosListComponent
  },
  {
    path: "form",
    component: EventosFormComponent
  }
];

@NgModule({
  imports: [
    CommonModule,
    EventosMaterial,
    SharedModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forChild(routes)
  ],
  declarations: [EventosListComponent, EventosFormComponent],
  exports: [RouterModule]
})
export class EventosModule {}
