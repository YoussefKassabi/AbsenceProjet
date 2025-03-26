// src/app/ui/apprenants/apprenants.module.ts
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

// ❌ Ne pas utiliser les composants standalone ici
import { ApprenantsComponent } from './apprenants.component';
import { AddApprenantComponent } from './add-apprenant/add-apprenant.component';
import { EditApprenantComponent } from './edit-apprenant/edit-apprenant.component';
import { ApprenantDetailsComponent } from './apprenant-details/apprenant-details.component';

@NgModule({
  declarations: [ // ✅ Déclaration normale
    ApprenantsComponent,
    AddApprenantComponent,
    EditApprenantComponent,
    ApprenantDetailsComponent
  ],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports: [
    ApprenantsComponent,
    AddApprenantComponent,
    EditApprenantComponent,
    ApprenantDetailsComponent
  ]
})
export class ApprenantsModule {}
