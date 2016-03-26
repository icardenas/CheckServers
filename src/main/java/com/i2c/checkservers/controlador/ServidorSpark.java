/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.i2c.checkservers.controlador;

import com.i2c.checkservers.App;
import static spark.Spark.*;

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
            logger.info(request.contextPath()+" "+request.uri()+" "+request.session().attribute("usuario"));
            if (request.url().contains("/app/login") == false && request.session().attribute("usuario") == null) {
                request.session(true);
                request.session().attribute("usuario", "Ivan");
                response.redirect("/app/login");
            }
        });
        get("/app/logout", (request, response) -> {
            logger.info(request.session().id());
            request.session().invalidate();
            logger.info(request.session().id());
            response.redirect("/app");
            return "Salida";
        });
        get("/app/login", (req, res) -> {
            return getConfPebble().parsePlantilla("login.html", null);
        });
        get("/app", (req, res) -> "Menu");
        get("/app/hola", (req, res) -> "hola spark");
        get("/app/test", (req, res) -> {
            return getConfPebble().parsePlantilla("test.html", null);
        });

    }
    
 
}
