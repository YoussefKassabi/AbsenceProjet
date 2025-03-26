package web4.jobs.absenceservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web4.jobs.absenceservice.entities.Absence;
import web4.jobs.absenceservice.services.AbsenceService;
import java.util.List;

@RestController
@RequestMapping("/api/absences")
public class AbsenceController {

    @Autowired
    private AbsenceService absenceService;

    // Ajouter une absence
    @PostMapping("/ajout")
    public Absence ajouterAbsence(@RequestBody Absence absence) {

        return absenceService.enregistrerAbsence(absence);
    }

    // Récupérer les absences d'un apprenant
    @GetMapping("/apprenant/{apprenantId}")
    public List<Absence> getAbsencesParApprenant(@PathVariable Long apprenantId) {
        return absenceService.getAbsencesParApprenant(apprenantId);
    }
}
