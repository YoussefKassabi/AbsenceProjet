package web4.jobs.utilisateurservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web4.jobs.utilisateurservice.entities.Apprenant;

@Repository
public interface ApprenantRepository extends JpaRepository <Apprenant,Long> {
}
