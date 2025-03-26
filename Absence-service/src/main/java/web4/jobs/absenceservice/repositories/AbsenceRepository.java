package web4.jobs.absenceservice.repositories;

import web4.jobs.absenceservice.entities.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {
    List<Absence> findByApprenantId(Long apprenantId); // Correction du nom de la méthode
}
