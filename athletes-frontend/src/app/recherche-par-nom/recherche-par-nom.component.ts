import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { Athlete } from '../model/athlete.model';
import { AthleteService } from '../services/athlete.service';
import { AuthService } from '../services/auth.service';
import { SearchFilterPipe } from '../pipes/search-filter.pipe';

@Component({
  selector: 'app-recherche-par-nom',
  standalone: true,
  imports: [FormsModule, CommonModule, RouterLink, SearchFilterPipe],
  templateUrl: './recherche-par-nom.component.html',
  styles: ``
})
export class RechercheParNomComponent implements OnInit {

  nomAthlete!: string;
  athletes!: Athlete[];
  allAthletes!: Athlete[];
  searchTerm!: string;

  constructor(private athleteService: AthleteService,
              public authService: AuthService) { }

  ngOnInit(): void {
    this.chargerAthletes();
  }

  chargerAthletes() {
    this.athleteService.listeAthletes().subscribe(athletes => {
      console.log(athletes);
      this.athletes = athletes;
      this.allAthletes = athletes;
    });
  }

  rechercherAthletes() {
    if (this.nomAthlete) {
      this.athleteService.rechercherParNom(this.nomAthlete).subscribe(athletes => {
        console.log(athletes);
        this.athletes = athletes;
      });
    } else {
      this.chargerAthletes();
    }
  }

  onKeyUp(filterText: string) {
    this.athletes = this.allAthletes.filter(item =>
      item.nomComplet.toLowerCase().includes(filterText));
  }

  supprimerAthlete(athlete: Athlete): void {
    let conf = confirm("Êtes-vous sûr ?");
    if (conf) {
      this.athleteService.supprimerAthlete(athlete.idAthlete).subscribe(() => {
        this.rechercherAthletes();
      });
    }
  }

}