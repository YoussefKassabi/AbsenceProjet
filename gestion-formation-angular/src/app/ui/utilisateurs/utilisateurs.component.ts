import { Component } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-utilisateurs',
  standalone: false,
  templateUrl: './utilisateurs.component.html',
  styleUrl: './utilisateurs.component.css'
})
export class UtilisateursComponent {
  constructor(private router: Router) {}

  // Redirige vers la page des apprenants
  onSelectApprenant() {
    this.router.navigate(['/apprenants']);
  }
}
