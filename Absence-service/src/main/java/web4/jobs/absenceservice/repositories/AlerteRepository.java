package web4.jobs.absenceservice.repositories;

import web4.jobs.absenceservice.entities.Alerte;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlerteRepository extends JpaRepository<Alerte, Long> {
    List<Alerte> findByApprenantId(Long apprenantId);
    List<Alerte> findByCodeFormation(String codeFormation);
}