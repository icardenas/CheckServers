/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.i2c.checkservers.controlador;

import com.i2c.checkservers.App;
import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.loader.FileLoader;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

/**
 *
 * @author icardenas
 */
public class ConfiguracionPebble {

    private PebbleEngine engine;
    private PebbleTemplate compiledTemplate;
    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ConfiguracionPebble.class);

    public ConfiguracionPebble() {

    }

    public void inicializar() {
        FileLoader fileLoader = new FileLoader();
        fileLoader.setPrefix(App.RUTA_RECURSOS + "\\vista\\plantillas");
        PebbleEngine.Builder builder = new PebbleEngine.Builder();
        builder.strictVariables(true).cacheActive(false).loader(fileLoader);
        engine = builder.build();
    }

    public void configurar() {
        PebbleEngine.Builder builder = new PebbleEngine.Builder();
        engine = builder.build();
    }

    public String parsePlantilla(String _nombrePlantilla, Map<String, Object> _map) {
        Writer writer = new StringWriter();
        try {
            compiledTemplate = engine.getTemplate(_nombrePlantilla);
            compiledTemplate.evaluate(writer, _map);
        } catch (PebbleException | IOException ex) {
            logger.error(ex.getMessage());
        }
        return writer.toString();
    }

}
