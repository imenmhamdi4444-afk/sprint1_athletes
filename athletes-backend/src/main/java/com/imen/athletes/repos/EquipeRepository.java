package com.imen.athletes.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.imen.athletes.entities.Equipe;

@RepositoryRestResource(path = "eq")
@CrossOrigin("http://localhost:4200/") // pour autoriser angular
public interface EquipeRepository extends JpaRepository<Equipe, Long> {
}
