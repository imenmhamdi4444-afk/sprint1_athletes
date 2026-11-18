package com.imen.athletes;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.imen.athletes.entities.Athlete;
import com.imen.athletes.entities.Equipe;
import com.imen.athletes.repos.AthleteRepository;
import com.imen.athletes.repos.EquipeRepository;

@SpringBootTest
class AthletesApplicationTests {

    @Autowired
    private AthleteRepository athleteRepository;

    @Autowired
    private EquipeRepository equipeRepository;

    @Test
    void contextLoads() {
    }

    // ---- CRUD de base ----

    @Test
    public void testCreateEquipe() {
        Equipe eq = new Equipe(null, "Club Africain", new Date(), null);
        equipeRepository.save(eq);
    }

    @Test
    public void testCreateAthlete() {
        Equipe eq = equipeRepository.findById(1L).get();
        Athlete a1 = new Athlete(null, "Mohamed Ali", new Date(), "Tunisien", "Boxe", eq);
        Athlete a2 = new Athlete(null, "Zinedine Zidane", new Date(), "Français", "Football", eq);
        Athlete a3 = new Athlete(null, "Ahmed Ben", new Date(), "Tunisien", "Boxe", eq);
        athleteRepository.save(a1);
        athleteRepository.save(a2);
        athleteRepository.save(a3);
    }

    @Test
    public void testFindAthlete() {
        Athlete a = athleteRepository.findById(1L).get();
        System.out.println(a);
    }

    @Test
    public void testUpdateAthlete() {
        Athlete a = athleteRepository.findById(1L).get();
        a.setNomComplet("Mohamed Ali - Updated");
        athleteRepository.save(a);
    }

    @Test
    public void testDeleteAthlete() {
        athleteRepository.deleteById(1L);
    }

    @Test
    public void testListerTousAthletes() {
        List<Athlete> athletes = athleteRepository.findAll();
        for (Athlete a : athletes) {
            System.out.println(a);
        }
    }

    // ---- Recherche par nom ----

    @Test
    public void testFindByNomComplet() {
        List<Athlete> athletes = athleteRepository.findByNomComplet("Mohamed Ali");
        for (Athlete a : athletes) {
            System.out.println(a);
        }
    }

    @Test
    public void testFindByNomCompletContains() {
        List<Athlete> athletes = athleteRepository.findByNomCompletContains("Ali");
        for (Athlete a : athletes) {
            System.out.println(a);
        }
    }

    // ---- Recherche par nom et sport (@Query JPQL) ----

    @Test
    public void testFindByNomSport() {
        List<Athlete> athletes = athleteRepository.findByNomSport("Ali", "Boxe");
        for (Athlete a : athletes) {
            System.out.println(a);
        }
    }

    // ---- Recherche par équipe (entité en paramètre) ----

    @Test
    public void testFindByEquipe() {
        Equipe eq = new Equipe();
        eq.setCodeEquipe(1L);
        List<Athlete> athletes = athleteRepository.findByEquipe(eq);
        for (Athlete a : athletes) {
            System.out.println(a);
        }
    }

    // ---- Recherche par id de l'équipe ----

    @Test
    public void testFindByEquipeCodeEquipe() {
        List<Athlete> athletes = athleteRepository.findByEquipeCodeEquipe(1L);
        for (Athlete a : athletes) {
            System.out.println(a);
        }
    }

    // ---- Tri par nom ASC ----

    @Test
    public void testFindByOrderByNomCompletAsc() {
        List<Athlete> athletes = athleteRepository.findByOrderByNomCompletAsc();
        for (Athlete a : athletes) {
            System.out.println(a);
        }
    }

    // ---- Tri par nom ASC et sport DESC ----

    @Test
    public void testTrierAthletesNomSport() {
        List<Athlete> athletes = athleteRepository.trierAthletesNomSport();
        for (Athlete a : athletes) {
            System.out.println(a);
        }
    }
}
