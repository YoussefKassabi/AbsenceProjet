package web4.jobs.absenceservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web4.jobs.absenceservice.services.AbsenceService;
import web4.jobs.absenceservice.entities.StatistiqueAbsenceDTO;

import java.util.List;

@RestController
@RequestMapping("/api/absences")
public class AbsenceController {

    private final AbsenceService absenceService;

    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    // Vérifie si un apprenant a dépassé le seuil
    @GetMapping("/alerte/{apprenantId}")
    public ResponseEntity<Boolean> verifierSeuil(@PathVariable Long apprenantId) {
        boolean alerte = absenceService.verifierDepassementSeuil(apprenantId);
        return ResponseEntity.ok(alerte);
    }

    // Retourne les statistiques d'absences de tous les apprenants
    @GetMapping("/statistiques")
    public ResponseEntity<List<StatistiqueAbsenceDTO>> getStatistiques() {
        List<StatistiqueAbsenceDTO> stats = absenceService.getStatistiquesAbsences();
        return ResponseEntity.ok(stats);
    }
}
