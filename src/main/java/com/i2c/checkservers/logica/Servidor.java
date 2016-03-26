/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.i2c.checkservers.logica;

import java.util.List;

/**
 *
 * @author icardenas
 */
public class Servidor {

    private String ip;
    private String dominio;
    private boolean status;
    private List<Aplicacion> listaAplicaciones;
    private String localidad;
    private boolean inicializa;
    private int orden;

    public Servidor(String ip, String dominio, boolean status, String localidad, boolean inicializa,int orden) {
        this.ip = ip;
        this.dominio = dominio;
        this.status = status;
        this.localidad = localidad;
        this.inicializa = inicializa;
        this.orden = orden;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Aplicacion> getListaAplicaciones() {
        return listaAplicaciones;
    }

    public void setListaAplicaciones(List<Aplicacion> listaAplicaciones) {
        this.listaAplicaciones = listaAplicaciones;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public boolean isInicializa() {
        return inicializa;
    }

    public void setInicializa(boolean inicializa) {
        this.inicializa = inicializa;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }
    
}
