package web4.jobs.absenceservice.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Alerte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long apprenantId;
    private String codeFormation;
    private LocalDateTime dateAlerte = LocalDateTime.now();
    private Integer nombreOccurences;
    private Integer seuilConfigure;
}