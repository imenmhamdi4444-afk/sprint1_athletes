import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Equipe } from '../model/equipe.model';
import { AthleteService } from '../services/athlete.service';
import { UpdateEquipeComponent } from '../update-equipe/update-equipe.component';

@Component({
  selector: 'app-liste-equipes',
  standalone: true,
  imports: [CommonModule, UpdateEquipeComponent],
  templateUrl: './liste-equipes.component.html',
  styles: ``
})
export class ListeEquipesComponent implements OnInit {
  equipes!: Equipe[];
  updatedEquipe: Equipe = { codeEquipe: 0, nomEquipe: "" };
  ajout: boolean = true;

  constructor(private athleteService: AthleteService) { }

  ngOnInit(): void {
    this.chargerEquipes();
  }

  chargerEquipes() {
    this.athleteService.listeEquipes().subscribe(eqs => {
      this.equipes = eqs._embedded.equipes;
      console.log(eqs);
    });
  }

  equipeUpdated(eq: Equipe) {
    console.log("Equipe updated event", eq);
    this.athleteService.ajouterEquipe(eq).subscribe(() => this.chargerEquipes());
  }

  updateEq(eq: Equipe) {
    this.updatedEquipe = eq;
    this.ajout = false;
  }
}
