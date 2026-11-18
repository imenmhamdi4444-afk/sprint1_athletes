package com.imen.athletes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imen.athletes.entities.Athlete;
import com.imen.athletes.entities.Equipe;
import com.imen.athletes.repos.AthleteRepository;

@Service
public class AthleteServiceImpl implements AthleteService {

    @Autowired
    AthleteRepository athleteRepository;

    // ---- CRUD de base ----

    @Override
    public Athlete saveAthlete(Athlete a) {
        return athleteRepository.save(a);
    }

    @Override
    public Athlete updateAthlete(Athlete a) {
        return athleteRepository.save(a);
    }

    @Override
    public void deleteAthlete(Athlete a) {
        athleteRepository.delete(a);
    }

    @Override
    public void deleteAthleteById(Long id) {
        athleteRepository.deleteById(id);
    }

    @Override
    public Athlete getAthlete(Long id) {
        return athleteRepository.findById(id).get();
    }

    @Override
    public List<Athlete> getAllAthletes() {
        return athleteRepository.findAll();
    }

    // ---- Recherche par nom ----

    @Override
    public List<Athlete> findByNomComplet(String nom) {
        return athleteRepository.findByNomComplet(nom);
    }

    @Override
    public List<Athlete> findByNomCompletContains(String nom) {
        return athleteRepository.findByNomCompletContains(nom);
    }

    // ---- Recherche par nom et sport ----

    @Override
    public List<Athlete> findByNomSport(String nom, String sport) {
        return athleteRepository.findByNomSport(nom, sport);
    }

    // ---- Recherche par équipe ----

    @Override
    public List<Athlete> findByEquipe(Equipe equipe) {
        return athleteRepository.findByEquipe(equipe);
    }

    @Override
    public List<Athlete> findByEquipeCodeEquipe(Long id) {
        return athleteRepository.findByEquipeCodeEquipe(id);
    }

    // ---- Tri ----

    @Override
    public List<Athlete> findByOrderByNomCompletAsc() {
        return athleteRepository.findByOrderByNomCompletAsc();
    }

    @Override
    public List<Athlete> trierAthletesNomSport() {
        return athleteRepository.trierAthletesNomSport();
    }
}
