import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Apprenant } from '../models/apprenant.model';

@Injectable({
  providedIn: 'root',
})
export class ApprenantService {
  private apiUrl = 'http://localhost:8087/api/apprenants/ajouter';

  constructor(private http: HttpClient) {}

  getApprenants(): Observable<Apprenant[]> {
    return this.http.get<Apprenant[]>(this.apiUrl);
  }

  getApprenantById(id: number): Observable<Apprenant> {
    return this.http.get<Apprenant>(`${this.apiUrl}/${id}`);
  }

  addApprenant(apprenant: Apprenant): Observable<Apprenant> {
    return this.http.post<Apprenant>(this.apiUrl, apprenant);
  }

  updateApprenant(apprenant: Apprenant): Observable<Apprenant> {
    return this.http.put<Apprenant>(`${this.apiUrl}/${apprenant.id}`, apprenant);
  }

  deleteApprenant(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
