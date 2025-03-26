import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-edit-absence',
  templateUrl: './edit-absence.component.html',
  styleUrls: ['./edit-absence.component.css'],
  standalone: true,
  imports: [FormsModule]
})
export class EditAbsenceComponent {
  absence = {
    apprenantId: '',
    dateAbsence: '',
    typeAbsence: ''
  };

  constructor() {}

  updateAbsence() {
    console.log('Absence mise à jour:', this.absence);
    alert('Absence mise à jour avec succès !');
  }
}
