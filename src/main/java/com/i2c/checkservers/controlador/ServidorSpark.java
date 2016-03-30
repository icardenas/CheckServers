/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.i2c.checkservers.controlador;

import com.i2c.checkservers.App;
import com.i2c.checkservers.logica.ConsultarServidores;
import static spark.Spark.*;
import spark.*;
import java.util.*;
import java.net.*;

/**
 *
 * @author icardenas
 */
public class ServidorSpark {

    private ConfiguracionPebble confPebble;
    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ServidorSpark.class);

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
        int puerto = 80;
        port(puerto);
        crearRuta(puerto);
        externalStaticFileLocation(App.RUTA_RECURSOS + "/vista");
        System.out.println("EXTERNA LOCATION " + App.RUTA_RECURSOS + "/vista");
//        staticFileLocation(App.RUTA_RECURSOS + "/vistas");
    }

    public void crearRuta(int _puerto) {
        try {
            Enumeration e = NetworkInterface.getNetworkInterfaces();
            logger.error("RUTAS SERVIDOR");
            while (e.hasMoreElements()) {
                NetworkInterface n = (NetworkInterface) e.nextElement();
                Enumeration ee = n.getInetAddresses();
                while (ee.hasMoreElements()) {
                    InetAddress i = (InetAddress) ee.nextElement();
                    if (i.getHostAddress().length() < 16) {
                        logger.error("http://" + i.getHostAddress() + ":" + _puerto + "/app");
                    }
                }
            }
        } catch (SocketException ex) {
            logger.error(ex.getMessage());
        }
    }

    public void runServidor() {

        before((request, response) -> {
            logger.debug(request.contextPath() + " " + request.uri() + " " + request.session().attribute("usuario"));
            if (request.url().endsWith("/app/server")) {

            } else if (request.url().endsWith("/app") && request.session().attribute("usuario") == null) {
                request.session(true);
                response.redirect("/app/login");
            }
            else if (request.url().contains("/app") == true && request.url().contains("/app/login") == false && request.session().attribute("usuario") == null) {
                request.session(true);
                response.redirect("/app/login");
            } else if (request.url().contains("/app") == true || request.session().attribute("usuario") != null) {

            } else {

            }
        });

        post("/app/login", (req, res) -> {
//            recorrer(req);
            System.out.println("PARMETROS " + req.queryParams("in_login") + " " + req.queryParams("in_pass"));
            if (!req.queryParams("in_login").isEmpty() && !req.queryParams("in_pass").isEmpty()) {
                if (req.queryParams("in_login").toLowerCase().equals(req.queryParams("in_pass"))) {
                    req.session().attribute("usuario", req.queryParams("in_login").toLowerCase());
                    res.redirect("/app");
                }
            } else if (req.queryParams("in_login").isEmpty()) {

            }
            if (req.queryParams("in_pass").isEmpty()) {

            }

            return getConfPebble().parsePlantilla("login.html", null);
        });

        get("/app/logout", (request, response) -> {
            logger.info(request.session().id());
            request.session().invalidate();
            logger.info(request.session().id());
            response.redirect("/app/login");
            return "Salida";
        });

        get("/app/login", (req, res) -> {
//            recorrer(req);
            return getConfPebble().parsePlantilla("login.html", null);
        });

        get("/app/server/:ip", (req, res) -> {
//            recorrer(req);
            ConsultarServidores conServidores = new ConsultarServidores();
            conServidores.checkOnlineServr(req.params(":ip"));
//            logger.info(req.session().attribute("usuario"));
            return conServidores.checkOnlineServr(req.params(":ip")) ? "up" : "down";
        });
        get("/app/servers/180", (req, res) -> {
//            logger.info(req.session().attribute("usuario"));
            System.out.println("ENTRO a SERVICIOS OK");
            return "OK";
        });
        post("/app/server/:ip", (req, res) -> {
            ConsultarServidores conServidores = new ConsultarServidores();
            conServidores.checkOnlineServr(req.params(":ip"));
//            logger.info(req.session().attribute("usuario"));
            return conServidores.checkOnlineServr(req.params(":ip")) ? "up" : "down";
        });

        get("/app", (req, res) -> {
            Map<String, Object> mapa = new HashMap<String, Object>();
            mapa.put("usuario", req.session().attribute("usuario"));
            ConsultarServidores conServidores = new ConsultarServidores();
            conServidores.cargarServidores2();
            mapa.put("servidores", conServidores.getListaServidores());
            return getConfPebble().parsePlantilla("principal.html", mapa);
        });
        get("/app/test", (req, res) -> {
            return getConfPebble().parsePlantilla("test.html", null);
        });

    }

    public void recorrer(Request req) {
        Set<String> listaAtributos = req.attributes();
        for (String elemento : listaAtributos) {
            logger.info("Elemento " + elemento);
        }

        Map<String, String> listaParametros = req.params();
        listaAtributos = listaParametros.keySet();
        for (String listaAtributo : listaAtributos) {
            logger.info("Parametos " + listaAtributo);
        }
        listaAtributos = req.queryParams();
        for (String listaAtributo : listaAtributos) {
            logger.info("QueryParametos " + listaAtributo);
            logger.info("QueryParametos " + req.queryParams(listaAtributo));
        }
    }

}
