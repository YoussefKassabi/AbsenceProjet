import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AbsenceService } from '../../../services/absence.service';
import { Absence } from '../../../models/absence.model';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-add-absence',
  standalone: true,
  imports: [FormsModule], // Import FormsModule pour [(ngModel)]
  templateUrl: './add-absence.component.html',
  styleUrls: ['./add-absence.component.css']
})
export class AddAbsenceComponent {
  absence: Absence = {
    id: 0,
    apprenantId: 0,
    dateAbsence: '',
    typeAbsence: 'Ab'
  };

  constructor(private absenceService: AbsenceService, private router: Router) {}

  addAbsence(): void {
    this.absenceService.addAbsence(this.absence).subscribe(() => {
      alert('Absence ajoutée avec succès');
      this.router.navigate(['/absence-list']);
    });
  }
}
