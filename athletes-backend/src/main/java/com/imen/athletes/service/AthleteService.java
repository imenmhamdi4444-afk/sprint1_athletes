package com.imen.athletes.service;

import java.util.List;

import com.imen.athletes.entities.Athlete;
import com.imen.athletes.entities.Equipe;

public interface AthleteService {

    // CRUD de base
    Athlete saveAthlete(Athlete a);
    Athlete updateAthlete(Athlete a);
    void deleteAthlete(Athlete a);
    void deleteAthleteById(Long id);
    Athlete getAthlete(Long id);
    List<Athlete> getAllAthletes();

    // Recherche par nom
    List<Athlete> findByNomComplet(String nom);
    List<Athlete> findByNomCompletContains(String nom);

    // Recherche par nom et sport
    List<Athlete> findByNomSport(String nom, String sport);

    // Recherche par équipe
    List<Athlete> findByEquipe(Equipe equipe);
    List<Athlete> findByEquipeCodeEquipe(Long id);

    // Tri
    List<Athlete> findByOrderByNomCompletAsc();
    List<Athlete> trierAthletesNomSport();
}
