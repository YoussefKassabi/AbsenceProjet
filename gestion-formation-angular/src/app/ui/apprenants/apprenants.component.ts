// src/app/ui/apprenants/apprenants.component.ts
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApprenantService } from '../../services/apprenant.service';
import { Apprenant } from '../../models/apprenant.model';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-apprenants',
  templateUrl: './apprenants.component.html',
  styleUrls: ['./apprenants.component.css'],
  imports: [CommonModule]
})
export class ApprenantsComponent implements OnInit {
  apprenants: Apprenant[] = [];

  constructor(
    private apprenantService: ApprenantService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadApprenants();
  }

  loadApprenants(): void {
    this.apprenantService.getApprenants().subscribe({
      next: (data) => {
        this.apprenants = data;
      },
      error: (err) => {
        console.error('Erreur lors du chargement des apprenants', err);
      }
    });
  }

  onAdd(): void {
    this.router.navigate(['/apprenants/add']);
  }

  onDetail(id: number): void {
    this.router.navigate(['/apprenants', id]);
  }

  onEdit(id: number): void {
    this.router.navigate(['/apprenants', id, 'edit']);
  }

  onDelete(id: number): void {
    if (confirm('Voulez-vous vraiment supprimer cet apprenant ?')) {
      this.apprenantService.deleteApprenant(id).subscribe(() => {
        this.loadApprenants();
      });
    }
  }
}
