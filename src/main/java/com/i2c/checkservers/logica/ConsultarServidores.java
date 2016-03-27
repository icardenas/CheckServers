/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.i2c.checkservers.logica;

import java.io.IOException;
import java.util.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        listaServidores = new ArrayList<>();
        //TODO CONSULTA A BD
        for (int i = 0; i < 40; i++) {
            Servidor server = new Servidor("192.168.2." + i, "dominio.p" + i, false, "PLANTA", true, i * 100);
            if (i < 2) {
                server.setInicializa(false);
            }
            if (i % 2 == 0) {
                server.setLocalidad("REMOTA");
            }
//            server.setStatus(checkOnlineServr(server.getIp()));
            if (i == 1 || i == 3 || i == 8) {
                List<Aplicacion> listaApp = new ArrayList<>();
                for (int j = 8080; j < 8084; j++) {
                    Aplicacion app = new Aplicacion("http", "" + j, "fenix " + j, "servicio" + j);
                    listaApp.add(app);
                }
                server.setListaAplicaciones(listaApp);
            }
            listaServidores.add(server);
        }
    }

    public boolean checkOnlineServr(String _host) {
        try {
            InetAddress address = InetAddress.getByName(_host);
            if (address.isReachable(100)) {
                System.out.println("DISPONIBLE " + _host + " " + address.getHostAddress() + " "
                        + address.getHostName() + " " + address.getCanonicalHostName());
                return true;
            }
        } catch (IOException ex) {
            Logger.getLogger(ConsultarServidores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
