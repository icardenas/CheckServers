/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.i2c.checkservers.controlador;

/**
 *
 * @author icardenas
 */
public class ServidorSpark {

    private ConfiguracionPebble confPebble;

    public ConfiguracionPebble getConfPebble() {
        return confPebble;
    }

    public void setConfPebble(ConfiguracionPebble confPebble) {
        this.confPebble = confPebble;
    }

    public ServidorSpark() {
    }

    public ServidorSpark(ConfiguracionPebble _confPebble) {
        confPebble = _confPebble;
    }

    public void crearConfiguracion() {

    }

    public void runServidor() {

    }
}
