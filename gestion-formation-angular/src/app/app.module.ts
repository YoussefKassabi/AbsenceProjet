import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UtilisateursComponent } from './ui/utilisateurs/utilisateurs.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';


import { AccueilComponent } from './ui/accueil/accueil.component';
import {AddApprenantComponent} from './ui/apprenants/add-apprenant/add-apprenant.component';

@NgModule({
  declarations: [
    AppComponent,
    UtilisateursComponent,


  ],
  imports: [
    BrowserModule,
    RouterModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    HttpClientModule,
    AccueilComponent,
    AddApprenantComponent,
    AddApprenantComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
