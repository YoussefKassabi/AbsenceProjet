package web4.jobs.absenceservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import web4.jobs.absenceservice.entities.Absence;

import java.util.List;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {
    List<Absence> findByApprenantId(Long apprenantId);

    @Query("SELECT DISTINCT a.apprenantId FROM Absence a")
    List<Long> findDistinctApprenantIds();
}
