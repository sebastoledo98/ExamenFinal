import { Component } from '@angular/core';
import { Deudas } from 'src/app/domain/deudas';
import { Persona } from 'src/app/domain/persona';
import { DeudasService } from 'src/app/servicios/deudas.service';

@Component({
  selector: 'app-deudas',
  templateUrl: './deudas.component.html',
  styleUrls: ['./deudas.component.css']
})
export class DeudasComponent {

  deudas: any;

  dni: string = '';

  personas: any;

  persona: Persona = new Persona();
  constructor(private deudasService: DeudasService){

  }

  ngOnInit():void {
  }

  buscar(){
    console.log(this.dni);
    this.deudasService.buscarDeudas(this.dni)
      .subscribe(data => {
        this.persona = data;
        this.deudas = data.deudas;
      });
  }
}
