package com.web.examen.modelo;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario{

    @Id
    @GeneratedValue
    private int id;
    private String telefono;
    private String operadora;
    private double saldo;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
            this.id = id;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getOperadora() {
        return this.operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    @Override
    public String toString(){
        return "Usuario [id=" + id + ", telefono = " + telefono + ", operadora = " + operadora + ", saldo = " + saldo + "]";
    }

}
