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
public class Carro implements Serializable {

    private String Color;
    private String Marca;
    private Propietario propietario;

    public Carro(String Color, String Marca, Propietario propetario) {
        this.Color = Color;
        this.Marca = Marca;
        this.propietario = propetario;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }


}
