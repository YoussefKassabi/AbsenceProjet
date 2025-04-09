package web4.jobs.absenceservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web4.jobs.absenceservice.entities.SeuilAbsence;

import java.util.Optional;

public interface SeuilAbsenceRepository extends JpaRepository<SeuilAbsence, Long> {
    Optional<SeuilAbsence> findByCodeFormation(String codeFormation);
}
