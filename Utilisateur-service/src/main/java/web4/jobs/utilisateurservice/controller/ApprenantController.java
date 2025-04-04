package web4.jobs.utilisateurservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web4.jobs.utilisateurservice.entities.Apprenant;
import web4.jobs.utilisateurservice.service.ApprenantService;

import java.util.List;

@RestController
@RequestMapping("/api/apprenants")
@CrossOrigin(origins = "http://localhost:4200")

public class ApprenantController {
    @Autowired
    private ApprenantService apprenantService;

    @GetMapping("/list")
    public List<Apprenant> getAll() {
        return apprenantService.getAll();
    }

    @GetMapping("/{id}")
    public Apprenant getById(@PathVariable Long id) {
        return apprenantService.getById(id);
    }

    @PostMapping("/ajouter")
    public Apprenant save(@RequestBody Apprenant apprenant) {
        System.out.println("Reçu : " + apprenant);
        return apprenantService.save(apprenant);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        apprenantService.delete(id);
    }

    @PutMapping("/{id}")
    public Apprenant updateApprenant(@PathVariable Long id, @RequestBody Apprenant apprenant) {
        Apprenant existingApprenant = apprenantService.getById(id);
        if (existingApprenant != null) {
            existingApprenant.setNom(apprenant.getNom());
            existingApprenant.setPrenom(apprenant.getPrenom());
            existingApprenant.setEmail(apprenant.getEmail());
            existingApprenant.setNiveau(apprenant.getNiveau());
            return apprenantService.save(existingApprenant);
        }
        return null;
    }

}