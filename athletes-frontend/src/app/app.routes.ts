import { Routes } from '@angular/router';
import { AthletesComponent } from './athletes/athletes.component';
import { AddAthleteComponent } from './add-athlete/add-athlete.component';
import { UpdateAthleteComponent } from './update-athlete/update-athlete.component';
import { RechercheParEquipeComponent } from './recherche-par-equipe/recherche-par-equipe.component';
import { RechercheParNomComponent } from './recherche-par-nom/recherche-par-nom.component';
import { ListeEquipesComponent } from './liste-equipes/liste-equipes.component';
import { LoginComponent } from './login/login.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { athleteGuard } from './athlete.guard';

export const routes: Routes = [
  { path: "athletes", component: AthletesComponent },
  { path: "add-athlete", component: AddAthleteComponent, canActivate: [athleteGuard] },
  { path: "add-produit", redirectTo: "add-athlete", pathMatch: "full" },
  { path: "updateAthlete/:id", component: UpdateAthleteComponent, canActivate: [athleteGuard] },
  { path: "rechercheParEquipe", component: RechercheParEquipeComponent },
  { path: "rechercheParNom", component: RechercheParNomComponent },
  { path: "listeEquipes", component: ListeEquipesComponent },
  { path: "listeCategories", redirectTo: "listeEquipes", pathMatch: "full" },
  { path: "login", component: LoginComponent },
  { path: "app-forbidden", component: ForbiddenComponent },
  { path: "", redirectTo: "athletes", pathMatch: "full" }
];
