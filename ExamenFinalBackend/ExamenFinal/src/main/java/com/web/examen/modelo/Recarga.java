package com.web.examen.modelo;

import java.util.Date;

public class Recarga{

    private int id;
    private Date fecha;
    private Usuario usuario;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
            this.id = id;
    }

    public Date getFecha(){
        return this.fecha;
    }

    public void setFecha(Date fecha){
        this.fecha = fecha;
    }

    public Usuario getUsuario(){
        return this.usuario;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

}
 
