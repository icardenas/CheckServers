/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.i2c.checkservers.logica;

import java.util.*;

/**
 *
 * @author icardenas
 */
public class ConsultarServidores {

    List<Servidor> listaServidores;

    public List<Servidor> getListaServidores() {
        return listaServidores;
    }

    public void setListaServidores(List<Servidor> listaServidores) {
        this.listaServidores = listaServidores;
    }

    public void cargarServidores() {
        listaServidores=new ArrayList<>();
        //TODO CONSULTA A BD
        for (int i = 0; i < 5; i++) {
            Servidor server = new Servidor("192.168.111." + i+1, "dominio.p" + i, true, "PLANTA", true,i*100);
            if (i < 2) {
                server.setInicializa(false);
            }
            if (i % 2 == 0) {
                server.setLocalidad("REMOTA");
            }
            if (i == 1 || i == 3) {
                List<Aplicacion> listaApp = new ArrayList<>();
                for (int j = 8080; j < 8084; j++) {
                    Aplicacion app = new Aplicacion("http", "" + j, "fenix "+j, "servicio" + j);
                    listaApp.add(app);
                }
                server.setListaAplicaciones(listaApp);
            }
            listaServidores.add(server);
        }
    }

}
