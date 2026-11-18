import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { Athlete } from '../model/athlete.model';
import { Equipe } from '../model/equipe.model';
import { AthleteService } from '../services/athlete.service';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-recherche-par-equipe',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './recherche-par-equipe.component.html',
  styles: ``
})
export class RechercheParEquipeComponent implements OnInit {
  athletes: Athlete[] = [];
  idEquipe!: number;
  equipes: Equipe[] = [];

  constructor(private athleteService: AthleteService,
              public authService: AuthService) { }

  ngOnInit(): void {
    this.athleteService.listeEquipes().subscribe(eqs => {
      this.equipes = eqs._embedded.equipes;
    });
  }

  onChange(): void {
    this.athleteService.rechercherParEquipe(this.idEquipe).subscribe(athletes => {
      this.athletes = athletes;
    });
  }

  supprimerAthlete(athlete: Athlete): void {
    let conf = confirm("Êtes-vous sûr ?");
    if (conf) {
      this.athleteService.supprimerAthlete(athlete.idAthlete).subscribe(() => {
        this.onChange();
      });
    }
  }
}