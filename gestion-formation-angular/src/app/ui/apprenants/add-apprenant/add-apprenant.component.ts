import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ApprenantService } from '../../../services/apprenant.service';
import { Apprenant } from '../../../models/apprenant.model';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-add-apprenant',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './add-apprenant.component.html',
  styleUrls: ['./add-apprenant.component.css']
})
export class AddApprenantComponent {
  apprenant: Apprenant = {
    id: 0 , 
    nom: '',
    prenom: '',
    email: '',
    role: '',
    niveau: ''
  };

  constructor(
    private apprenantService: ApprenantService,
    private router: Router
  ) {}

  onSubmit(): void {
    if (
      this.apprenant.nom.trim() &&
      this.apprenant.prenom.trim() &&
      this.apprenant.email.trim() &&
      this.apprenant.role.trim() &&
      this.apprenant.niveau.trim()
    ) {
      this.apprenantService.addApprenant(this.apprenant).subscribe({
        next: () => {
          alert('✅ Apprenant ajouté avec succès !');
          this.router.navigate(['/apprenants']); // Redirection vers la liste
        },
        error: (error) => {
          console.error('❌ Erreur lors de l\'ajout de l\'apprenant :', error);
          alert('❌ Une erreur est survenue lors de l\'ajout.');
        }
      });
    } else {
      alert('⚠️ Veuillez remplir tous les champs.');
    }
  }

  onCancel(): void {
    this.router.navigate(['/apprenants']);
  }
}
