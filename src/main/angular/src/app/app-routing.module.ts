import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";

const routes: Routes = [
  {
    path: "",
    loadChildren: "./modules/eventos.module#EventosModule"
  },
  {
    path: "transportes",
    loadChildren: "./modules/transportes.module#TransportesModule"
  },
  {
    path: "hospedagens",
    loadChildren: "./modules/hospedagens.module#HospedagensModule"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
