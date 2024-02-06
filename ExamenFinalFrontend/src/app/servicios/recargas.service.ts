import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Usuario } from 'src/app/domain/usuario';
import { Transaccion } from 'src/app/domain/transaccion';

@Injectable({
  providedIn: 'root'
})
export class RecargasService {

  constructor(private http: HttpClient) { }

  buscarUsuario(usuario: Usuario){
    let url = environment.WS_PATH + "/usuarios?telefono=" + usuario.telefono;
    return this.http.get<any>(url);
  }

  realizarRecargar(usuario: Usuario, monto: number){
    let url = environment.WS_PATH + "/recargar";
    let recarga: Transaccion = new Transaccion();
    recarga.telefono = usuario.telefono;
    recarga.monto = monto;
    recarga.fecha = new Date();
    console.log(recarga);
    return this.http.put<any>(url,recarga);
  }
}
