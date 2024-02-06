package com.web.examen.modelo;

import java.util.Date;

public class Transaccion{

    private String telefono;
    private double monto;
    private Date fecha;

    public String getTelefono(){
        return this.telefono;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public double getMonto(){
        return this.monto;
    }

    public void setMonto(double monto){
        this.monto = monto;
    }

    public Date getFecha(){
        return this.fecha;
    }

    public void setFecha(Date fecha){
        this.fecha = fecha;
    }

	@Override
	public String toString() {
		return "Transaccion [telefono=" + telefono + ", monto=" + monto + ", fecha=" + fecha + "]";
	}
    
    
}
