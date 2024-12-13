import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { EstudanteIndexComponent } from './pages/estudante/estudante-index/estudante-index.component';
import { EstudanteNewComponent } from './pages/estudante/estudante-new/estudante-new.component';

const routes: Routes = [
  {path: '', component:HomeComponent},
  {path: 'estudantes', component:EstudanteIndexComponent},
  {path: 'estudantes/new', component:EstudanteNewComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
