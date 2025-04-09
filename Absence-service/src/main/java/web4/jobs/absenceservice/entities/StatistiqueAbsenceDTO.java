package web4.jobs.absenceservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatistiqueAbsenceDTO {
    private Long apprenantId;
    private String codeFormation;
    private long absences;
    private long retards;
    private boolean alerte;
}
