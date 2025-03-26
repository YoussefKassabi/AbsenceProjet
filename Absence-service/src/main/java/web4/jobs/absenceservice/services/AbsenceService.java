package web4.jobs.absenceservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web4.jobs.absenceservice.entities.Absence;
import web4.jobs.absenceservice.repositories.AbsenceRepository;
import java.util.List;

@Service
public class AbsenceService {

    private static final int SEUIL_ALERTE = 3; // Définir un seuil d'alerte

    @Autowired
    private AbsenceRepository absenceRepository;

    public Absence enregistrerAbsence(Absence absence) {
        // Sauvegarder l'absence
        Absence savedAbsence = absenceRepository.save(absence);

        // Vérifier le nombre total d'absences de l'apprenant
        List<Absence> absences = absenceRepository.findByApprenantId(absence.getApprenantId());
        int totalAbsences = absences.size();

        // Déclencher une alerte si le seuil est dépassé
        if (totalAbsences >= SEUIL_ALERTE) {
            System.out.println("⚠️ ALERTE : L'apprenant ID " + absence.getApprenantId() +
                    " a atteint " + totalAbsences + " absences !");
        }

        return savedAbsence;
    }

    public List<Absence> getAbsencesParApprenant(Long apprenantId) {
        return absenceRepository.findByApprenantId(apprenantId);
    }
}
