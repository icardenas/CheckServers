/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.i2c.checkservers.logica;

/**
 *
 * @author icardenas
 */
public class Aplicacion {

    private String protocolo;
    private String puerto;
    private String nombre;
    private String urlServicio;

    public Aplicacion(String protocolo, String puerto, String nombre, String urlServicio) {
        this.protocolo = protocolo;
        this.puerto = puerto;
        this.nombre = nombre;
        this.urlServicio = urlServicio;
    }
    
    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlServicio() {
        return urlServicio;
    }

    public void setUrlServicio(String urlServicio) {
        this.urlServicio = urlServicio;
    }

    @Override
    public String toString() {
        return "Aplicacion{" + "protocolo=" + protocolo + ", puerto=" + puerto + ", nombre=" + nombre + '}';
    }
    

}
