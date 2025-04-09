package web4.jobs.absenceservice.services;

import org.springframework.stereotype.Service;
import web4.jobs.absenceservice.entities.Absence;
import web4.jobs.absenceservice.entities.SeuilAbsence;
import web4.jobs.absenceservice.entities.TypeAbsence;
import web4.jobs.absenceservice.entities.StatistiqueAbsenceDTO;
import web4.jobs.absenceservice.repositories.AbsenceRepository;
import web4.jobs.absenceservice.repositories.SeuilAbsenceRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AbsenceService {

    private final AbsenceRepository absenceRepo;
    private final SeuilAbsenceRepository seuilRepo;

    public AbsenceService(AbsenceRepository absenceRepo, SeuilAbsenceRepository seuilRepo) {
        this.absenceRepo = absenceRepo;
        this.seuilRepo = seuilRepo;
    }

    public boolean verifierDepassementSeuil(Long apprenantId) {
        List<Absence> absences = absenceRepo.findByApprenantId(apprenantId);
        if (absences.isEmpty()) return false;

        String codeFormation = absences.get(0).getCodeFormation();
        Optional<SeuilAbsence> seuilOptional = seuilRepo.findByCodeFormation(codeFormation);

        if (seuilOptional.isPresent()) {
            SeuilAbsence seuil = seuilOptional.get();

            long totalAbsences = absences.stream()
                    .filter(a -> TypeAbsence.valueOf(a.getType()) == TypeAbsence.ABSENCE)
                    .count();

            long totalRetards = absences.stream()
                    .filter(a -> TypeAbsence.valueOf(a.getType()) == TypeAbsence.RETARD)
                    .count();

            return totalAbsences >= seuil.getSeuilAbsence() || totalRetards >= seuil.getSeuilRetard();
        }

        return false;
    }

    public List<StatistiqueAbsenceDTO> getStatistiquesAbsences() {
        List<Absence> allAbsences = absenceRepo.findAll();

        Map<Long, List<Absence>> groupedByApprenant = allAbsences.stream()
                .collect(Collectors.groupingBy(Absence::getApprenantId));

        List<StatistiqueAbsenceDTO> statistiques = new ArrayList<>();

        for (Map.Entry<Long, List<Absence>> entry : groupedByApprenant.entrySet()) {
            Long apprenantId = entry.getKey();
            List<Absence> absences = entry.getValue();

            String codeFormation = absences.get(0).getCodeFormation();

            long totalAbsences = absences.stream()
                    .filter(a -> TypeAbsence.valueOf(a.getType()) == TypeAbsence.ABSENCE)
                    .count();

            long totalRetards = absences.stream()
                    .filter(a -> TypeAbsence.valueOf(a.getType()) == TypeAbsence.RETARD)
                    .count();

            boolean alerte = verifierDepassementSeuil(apprenantId);

            StatistiqueAbsenceDTO dto = new StatistiqueAbsenceDTO(
                    apprenantId,
                    codeFormation,
                    totalAbsences,
                    totalRetards,
                    alerte
            );

            statistiques.add(dto);
        }

        statistiques.sort(Comparator.comparingLong(StatistiqueAbsenceDTO::getAbsences));
        return statistiques;
    }
}
