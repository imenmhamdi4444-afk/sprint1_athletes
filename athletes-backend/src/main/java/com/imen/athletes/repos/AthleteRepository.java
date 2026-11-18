package com.imen.athletes.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.imen.athletes.entities.Athlete;
import com.imen.athletes.entities.Equipe;

@RepositoryRestResource(path = "rest")
public interface AthleteRepository extends JpaRepository<Athlete, Long> {

    // Recherche par nom exact
    List<Athlete> findByNomComplet(String nom);

    // Recherche par nom contenant une chaîne
    List<Athlete> findByNomCompletContains(String nom);

    // Recherche par nom contenant et sport (JPQL avec paramètres positionnels)
    @Query("select a from Athlete a where a.nomComplet like %?1 and a.sport = ?2")
    List<Athlete> findByNomSport(String nom, String sport);

    // Recherche par nom contenant et sport (JPQL avec @Param)
    @Query("select a from Athlete a where a.nomComplet like %:nom and a.sport = :sport")
    List<Athlete> findByNomSportParam(@Param("nom") String nom, @Param("sport") String sport);

    // Recherche par équipe (entité en paramètre)
    @Query("select a from Athlete a where a.equipe = ?1")
    List<Athlete> findByEquipe(Equipe equipe);

    // Recherche par id de l'équipe
    List<Athlete> findByEquipeCodeEquipe(Long id);

    // Tri par nom complet ascendant
    List<Athlete> findByOrderByNomCompletAsc();

    // Tri par nom complet ASC et sport DESC
    @Query("select a from Athlete a order by a.nomComplet ASC, a.sport DESC")
    List<Athlete> trierAthletesNomSport();
}