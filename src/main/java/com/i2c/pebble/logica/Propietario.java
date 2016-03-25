/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.i2c.pebble.logica;

import java.io.Serializable;

/**
 *
 * @author icardenas
 */
public class Propietario implements Serializable {

    private int numero;
    private String Nombre;

    public Propietario(int numero, String Nombre) {
        this.numero = numero;
        this.Nombre = Nombre;
    }
    

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public String toString() {
        return "Propietario{" + "numero=" + numero + ", Nombre=" + Nombre + '}';
    }
    
    

}
