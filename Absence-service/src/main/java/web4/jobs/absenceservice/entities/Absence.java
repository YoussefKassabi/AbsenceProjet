package web4.jobs.absenceservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long apprenantId; // Lien avec l'apprenant

    private LocalDate dateAbsence;

    @Enumerated(EnumType.STRING)
    private TypeAbsence typeAbsence; // Utilisation correcte de l'Enum

    private int totalAbsences; // Nombre total d'absences de l'apprenant

    // Ajout manuel du getter pour s'assurer qu'il est bien présent
    public Long getApprenantId() {
        return apprenantId;
    }
}
