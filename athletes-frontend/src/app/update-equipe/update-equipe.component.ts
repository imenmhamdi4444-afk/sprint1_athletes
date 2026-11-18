import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Equipe } from '../model/equipe.model';

@Component({
  selector: 'app-update-equipe',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './update-equipe.component.html',
  styles: ``
})
export class UpdateEquipeComponent implements OnInit {
  @Input()
  equipe!: Equipe;

  @Input()
  ajout!: boolean;

  @Output()
  equipeUpdated = new EventEmitter<Equipe>();

  ngOnInit(): void {
    console.log("ngOnInit du composant UpdateEquipe ", this.equipe);
  }

  saveEquipe() {
    this.equipeUpdated.emit(this.equipe);
  }
}
