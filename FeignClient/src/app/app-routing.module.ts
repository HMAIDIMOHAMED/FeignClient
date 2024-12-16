import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VoitureComponent } from './components/voiture/voiture.component';

const routes: Routes = [
  {
    path:"voiture", component:VoitureComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
