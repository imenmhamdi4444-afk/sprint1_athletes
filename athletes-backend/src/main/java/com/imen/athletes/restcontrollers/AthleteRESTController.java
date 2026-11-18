package com.imen.athletes.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imen.athletes.entities.Athlete;
import com.imen.athletes.service.AthleteService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AthleteRESTController {

    @Autowired
    AthleteService athleteService;

    // GET all athletes
    @RequestMapping(path = {"", "/all"}, method = RequestMethod.GET)
    public List<Athlete> getAllAthletes() {
        return athleteService.getAllAthletes();
    }

    // GET athlete by id
    @RequestMapping(value = {"/{id}", "/getbyid/{id}"}, method = RequestMethod.GET)
    public Athlete getAthleteById(@PathVariable("id") Long id) {
        return athleteService.getAthlete(id);
    }

    // POST create athlete
    @RequestMapping(path = {"", "/addprod", "/addathlete"}, method = RequestMethod.POST)
    public Athlete createAthlete(@RequestBody Athlete athlete) {
        return athleteService.saveAthlete(athlete);
    }

    // PUT update athlete
    @RequestMapping(path = {"", "/updateprod", "/updateathlete"}, method = RequestMethod.PUT)
    public Athlete updateAthlete(@RequestBody Athlete athlete) {
        return athleteService.updateAthlete(athlete);
    }

    // DELETE athlete by id
    @RequestMapping(value = {"/{id}", "/delprod/{id}", "/delathlete/{id}"}, method = RequestMethod.DELETE)
    public void deleteAthlete(@PathVariable("id") Long id) {
        athleteService.deleteAthleteById(id);
    }

    // GET athletes by equipe id
    @RequestMapping(value = {"/athletesequipe/{codeEquipe}", "/prodscat/{codeEquipe}"}, method = RequestMethod.GET)
    public List<Athlete> getAthletesByEquipeId(@PathVariable("codeEquipe") Long codeEquipe) {
        return athleteService.findByEquipeCodeEquipe(codeEquipe);
    }

    // GET athletes by name contains (Atelier 07)
    @GetMapping("/athletesByName/{nom}")
    public List<Athlete> findByNomCompletContains(@PathVariable("nom") String nom) {
        return athleteService.findByNomCompletContains(nom);
    }
}
