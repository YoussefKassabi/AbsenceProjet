import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ApprenantService } from '../../../services/apprenant.service';
import { Apprenant } from '../../../models/apprenant.model';

@Component({
  selector: 'app-edit-apprenant',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './edit-apprenant.component.html',
  styleUrls: ['./edit-apprenant.component.css'],
})
export class EditApprenantComponent implements OnInit {
  apprenant!: Apprenant;

  constructor(
    private route: ActivatedRoute,
    private apprenantService: ApprenantService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.params['id'];
    if (id) {
      this.apprenantService.getApprenantById(id).subscribe(
        (data: Apprenant) => {
          this.apprenant = data;
        },
        (error) => {
          console.error('Erreur lors de la récupération de l’apprenant :', error);
          this.router.navigate(['/apprenants']); // Redirection en cas d’erreur
        }
      );
    }
  }

  onSubmit(): void {
    this.apprenantService.updateApprenant(this.apprenant).subscribe(() => {
      this.router.navigate(['/apprenants']); // Redirection après mise à jour
    });
  }

  onCancel(): void {
    this.router.navigate(['/apprenants']); // Retour à la liste des apprenants
  }
}
