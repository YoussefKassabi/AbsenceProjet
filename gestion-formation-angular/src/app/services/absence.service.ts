import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Absence } from '../models/absence.model';

@Injectable({
  providedIn: 'root'
})
export class AbsenceService {
  private apiUrl: string = 'http://localhost:8083/absences'; // Assure-toi que cette URL est correcte

  constructor(private http: HttpClient) {}

  /**
   * Récupère toutes les absences
   */
  getAbsences(): Observable<Absence[]> {
    return this.http.get<Absence[]>(this.apiUrl);
  }

  /**
   * Récupère une absence par son ID
   */
  getAbsenceById(id: number): Observable<Absence> {
    return this.http.get<Absence>(`${this.apiUrl}/${id}`);
  }

  /**
   * Ajoute une nouvelle absence
   */
  addAbsence(absence: Absence): Observable<Absence> {
    return this.http.post<Absence>(this.apiUrl, absence);
  }

  /**
   * Met à jour une absence existante
   */
  updateAbsence(absence: Absence): Observable<Absence> {
    return this.http.put<Absence>(`${this.apiUrl}/${absence.id}`, absence);
  }

  /**
   * Supprime une absence
   */
  deleteAbsence(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
