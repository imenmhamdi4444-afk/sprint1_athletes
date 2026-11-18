package com.imen.athletes.entities;

import java.util.Date;
import java.util.List;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeEquipe;
    private String nomEquipe;
    private Date dateFondation;

    @JsonIgnore
    @OneToMany(mappedBy = "equipe")
    private List<Athlete> listeAthletes;
}