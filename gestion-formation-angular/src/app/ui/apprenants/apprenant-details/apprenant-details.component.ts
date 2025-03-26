import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApprenantService } from '../../../services/apprenant.service';
import { Apprenant } from '../../../models/apprenant.model';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-apprenant-details',
  templateUrl: './apprenant-details.component.html',
  styleUrls: ['./apprenant-details.component.css'],
  standalone: true,
  imports: [CommonModule]
})
export class ApprenantDetailsComponent implements OnInit {
  apprenant!: Apprenant; // Utilisation de "!" pour dire qu’il sera défini après initialisation

  constructor(
    private route: ActivatedRoute,
    private apprenantService: ApprenantService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.params['id']; // Récupération de l'ID depuis l'URL
    if (id) {
      this.apprenantService.getApprenantById(id).subscribe(
        (data: Apprenant) => {
          this.apprenant = data;
        },
        (error) => {
          console.error('Erreur lors de la récupération des détails :', error);
          this.router.navigate(['/apprenants']); // Redirection si l'apprenant n'existe pas
        }
      );
    }
  }

  onBack(): void {
    this.router.navigate(['/apprenants']); // Retour à la liste des apprenants
  }

  onEdit() {
    this.router.navigate(['/apprenants']);
  }
}
