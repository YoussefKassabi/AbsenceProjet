package web4.jobs.absenceservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SeuilAbsence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codeFormation;

    @Column(nullable = false)
    private Integer seuilAbsence;

    @Column(nullable = false)
    private Integer seuilRetard;

    public SeuilAbsence() {}
}
