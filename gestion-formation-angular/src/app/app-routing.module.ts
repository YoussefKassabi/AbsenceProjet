import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccueilComponent } from './ui/accueil/accueil.component';
import { ApprenantsComponent } from './ui/apprenants/apprenants.component';
import { AddApprenantComponent } from './ui/apprenants/add-apprenant/add-apprenant.component';
import { EditApprenantComponent } from './ui/apprenants/edit-apprenant/edit-apprenant.component';
import { ApprenantDetailsComponent } from './ui/apprenants/apprenant-details/apprenant-details.component';

const routes: Routes = [
  { path: '', component: AccueilComponent },
  { path: 'apprenants', component: ApprenantsComponent },
  { path: 'apprenants/add', component: AddApprenantComponent },
  { path: 'apprenants/:id', component: ApprenantDetailsComponent },
  { path: 'apprenants/:id/edit', component: EditApprenantComponent },
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
