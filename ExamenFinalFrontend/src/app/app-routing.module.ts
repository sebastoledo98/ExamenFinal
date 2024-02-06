import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DeudasComponent } from 'src/app/paginas/deudas/deudas.component';
import { RecargasComponent } from 'src/app/paginas/recargas/recargas.component';

const routes: Routes = [
  {path: 'paginas/deduas', component: DeudasComponent},
  {path: 'paginas/recargas', component: RecargasComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
