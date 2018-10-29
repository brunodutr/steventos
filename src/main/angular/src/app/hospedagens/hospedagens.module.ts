import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HospedagensListComponent } from './hospedagens-list/hospedagens-list.component';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    component: HospedagensListComponent
  }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  declarations: [HospedagensListComponent],
  exports: [RouterModule]
})
export class HospedagensModule { }
