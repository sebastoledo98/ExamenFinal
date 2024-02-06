import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Deudas } from 'src/app/domain/deudas';
import { Persona } from 'src/app/domain/persona';

@Injectable({
  providedIn: 'root'
})
export class DeudasService {

  constructor(private http: HttpClient) { }

  getDeudas(){
    let url = environment.WS_PATH + "/personas/list";
    return this.http.get<any>(url);
  }

  buscarDeudas(dni: string){
    let url = environment.WS_PATH + "/personas?dni=" + dni;
    console.log('url = ' + url);
    return this.http.get<Persona>(url);
  }

  saveDeudas(deuda: Deudas){
    let url = environment.WS_PATH + "/deudas";
    return this.http.post<any>(url, deuda);
  }
}
