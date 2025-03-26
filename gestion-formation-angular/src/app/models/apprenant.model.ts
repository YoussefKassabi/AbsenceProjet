// src/app/models/apprenant.model.ts
export interface Apprenant {
  id: number; // 👈 obligatoire
  nom: string;
  prenom: string;
  email: string;
  role: string;
  niveau: string;
}
