import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";

const routes: Routes = [
  {
    path: "",
    loadChildren: "./eventos/eventos.module#EventosModule"
  },
  {
    path: "restaurantes",
    loadChildren: "./restaurantes/restaurantes.module#RestaurantesModule"
  },
  {
    path: "hospedagens",
    loadChildren: "./hospedagens/hospedagens.module#HospedagensModule"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
