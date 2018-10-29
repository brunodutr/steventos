import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RestaurantesListComponent } from './restaurantes-list/restaurantes-list.component';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    component: RestaurantesListComponent
  }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  declarations: [RestaurantesListComponent],
  exports: [RouterModule]
})
export class RestaurantesModule { }
