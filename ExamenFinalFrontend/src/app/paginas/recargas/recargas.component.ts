import { Component } from '@angular/core';
import { Usuario } from 'src/app/domain/usuario';
import { RecargasService } from 'src/app/servicios/recargas.service';

@Component({
  selector: 'app-recargas',
  templateUrl: './recargas.component.html',
  styleUrls: ['./recargas.component.css']
})
export class RecargasComponent {

  monto: number = 0.00;
  mensaje: string = "";
  usuario: Usuario = new Usuario();

  constructor(private recargasService: RecargasService){}

  ngOnInit():void{}

  buscar() : boolean{
    console.log("Buscando usuario");
    console.log("Numero: " + this.usuario.telefono);
    this.recargasService.buscarUsuario(this.usuario)
      .subscribe(data => {
        console.log("data");
        console.log(data);
        if(data.codigo == 1){
          return true;
        }else{
          this.mensaje = "Error: No existe un usuario de esa operadora con ese numero: " + data.mensaje;
          alert(this.mensaje);
          return false;
        }
      });
      this.mensaje = "Error al relizar la recarga";
      alert(this.mensaje);
      return false;
  }

  recargar(){
    if(this.monto < 1){
      this.mensaje = "El monto debe ser de almenos 1 dolar";
      alert(this.mensaje);
      return;
    }
    if(this.buscar()){
      console.log("Realizando Recarga");
      console.log(this.usuario);
      this.recargasService.realizarRecargar(this.usuario,this.monto)
        .subscribe(data => {
          if(data.codigo == 1){
            this.mensaje = "Recarga realizada exitosamente";
            alert(this.mensaje);
          }else{
            this.mensaje = "Error al realizar la recarga: " + data.mensaje;
            alert(this.mensaje);
          }
        });
    }
  }
}
