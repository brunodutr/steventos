import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { RouterModule, Routes } from "@angular/router";
import { HospedagensListComponent } from "../pages/impl/hospedagens/list/hospedagens-list.component";

const routes: Routes = [
  {
    path: "",
    component: HospedagensListComponent
  }
];

@NgModule({
  imports: [CommonModule, RouterModule.forChild(routes)],
  declarations: [HospedagensListComponent],
  exports: [RouterModule]
})
export class HospedagensModule {}
