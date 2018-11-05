import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { RouterModule, Routes } from "@angular/router";
import { TransportesListComponent } from "../pages/impl/transportes/list/transportes-list.component";

const routes: Routes = [
  {
    path: "",
    component: TransportesListComponent
  }
];

@NgModule({
  imports: [CommonModule, RouterModule.forChild(routes)],
  declarations: [TransportesListComponent],
  exports: [RouterModule]
})
export class TransportesModule {}
