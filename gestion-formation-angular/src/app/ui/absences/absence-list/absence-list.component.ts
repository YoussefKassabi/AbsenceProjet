import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-absence-list',
  templateUrl: './absence-list.component.html',
  styleUrls: ['./absence-list.component.css'],
  standalone: true,
  imports: [CommonModule]
})
export class AbsenceListComponent {
  absences = [
    { id: 1, apprenant: 'Ali', date: '2024-03-01', type: 'Ab' }, // Absent
    { id: 2, apprenant: 'Sophie', date: '2024-03-05', type: 'Ret' }, // Retard
    { id: 3, apprenant: 'Mehdi', date: '2024-03-10', type: 'Ab' }, // Absent
    { id: 4, apprenant: 'Sara', date: '2024-03-12', type: 'Ret' }, // Retard
    { id: 5, apprenant: 'Amine', date: '2024-03-15', type: 'Ab' }, // Absent
  ];

  seuilAbsence = 3; // 🔥 Définition du seuil d'alerte

  constructor() {
    this.checkAbsenceThreshold();
  }

  deleteAbsence(id: number) {
    this.absences = this.absences.filter(absence => absence.id !== id);
    this.checkAbsenceThreshold();
  }

  checkAbsenceThreshold() {
    const absenceCount = this.absences.filter(absence => absence.type === 'Ab').length;
    if (absenceCount >= this.seuilAbsence) {
      alert('⚠️ Un apprenant a atteint le seuil d\'absences autorisé !');
    }
  }
}
