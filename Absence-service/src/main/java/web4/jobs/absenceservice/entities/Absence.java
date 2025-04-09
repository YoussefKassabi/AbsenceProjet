package web4.jobs.absenceservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter
@Setter

    public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long apprenantId; // ou relation @ManyToOne avec Apprenant
    private String codeFormation;
    private LocalDate dateAbsence;
    private String type; // "AB" ou "RET"

    // getters & setters
}
