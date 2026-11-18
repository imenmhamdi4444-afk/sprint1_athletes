package com.imen.athletes.entities;

import java.util.Date;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAthlete;
    private String nomComplet;
    private Date dateNaissance;
    private String nationalite;
    private String sport;

    @ManyToOne
    private Equipe equipe;
}