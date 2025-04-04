package web4.jobs.utilisateurservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web4.jobs.utilisateurservice.entities.Apprenant;
import web4.jobs.utilisateurservice.repositories.ApprenantRepository;

import java.util.List;

/*@Service
public class ApprenantService {
    @Autowired
    private ApprenantRepository apprenantRepository;

    public List<Apprenant> getAll() {
        return apprenantRepository.findAll();
    }
    public Apprenant getById(Long id) {
        return apprenantRepository.findById(id).orElse(null);
    }
    public Apprenant save(Apprenant apprenant) {
        return apprenantRepository.save(apprenant);
    }
    public void delete(Long id) {
        apprenantRepository.deleteById(id);
    }
    public Apprenant addApprenant(Apprenant apprenant) {
        return apprenantRepository.save(apprenant); // Sauvegarde en base de données//
         }
    }*/
@Service
public class ApprenantService {
    @Autowired
    private ApprenantRepository apprenantRepository;

    public Apprenant save(Apprenant apprenant) {

        return apprenantRepository.save(apprenant);
    }

    public Apprenant getById(Long id) {
        return apprenantRepository.findById(id).orElse(null);
    }

    public List<Apprenant> getAll() {
        return apprenantRepository.findAll();
    }

    public void delete(Long id) {
        apprenantRepository.deleteById(id);
    }
}