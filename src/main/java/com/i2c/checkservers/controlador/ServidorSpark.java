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
        port(80);
        externalStaticFileLocation(App.RUTA_RECURSOS + "/vista");
        System.out.println("EXTERNA LOCATION " + App.RUTA_RECURSOS + "/vista");
//        staticFileLocation(App.RUTA_RECURSOS + "/vistas");
    }

    public void runServidor() {

        before((request, response) -> {
            logger.debug(request.contextPath() + " " + request.uri() + " " + request.session().attribute("usuario"));
            if (request.url().contains("/app") == true && request.url().contains("/app/login") == false && request.session().attribute("usuario") == null) {
                request.session(true);
                response.redirect("/app/login");
            } else if (request.url().contains("/app/login") == true || request.session().attribute("usuario") != null) {

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

        get("/app", (req, res) -> {
            Map<String, Object> mapa = new HashMap<String, Object>();
            mapa.put("usuario", req.session().attribute("usuario"));
            ConsultarServidores conServidores = new ConsultarServidores();
            conServidores.cargarServidores();
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
