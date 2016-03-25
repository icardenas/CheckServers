/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.i2c.pebble;

import com.mitchellbosecke.pebble.*;
import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import com.mitchellbosecke.pebble.loader.*;
import java.io.IOException;
import java.io.Writer;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.apache.log4j.*;
import java.io.File;
import com.i2c.pebble.logica.*;
import java.util.*;

/**
 *
 * @author icardenas
 */
public class App {

    /**
     * @param args the command line arguments
     */
    final static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
        try {
            // TODO code application logic here
            File archivo = new File(App.class.getProtectionDomain().getCodeSource().getLocation().getPath());
            PropertyConfigurator.configure(archivo.getParent() + "\\log4j.properties");
            FileLoader fileLoader = new FileLoader();
            //"plantillas"
            fileLoader.setPrefix(archivo.getParent() + "\\plantillas");
            PebbleEngine engine = new PebbleEngine.Builder().loader(fileLoader).strictVariables(true).build();
            
            PebbleTemplate compiledTemplate = engine.getTemplate("principal.html");
            Writer writer = new StringWriter();
            Map<String, Object> context = new HashMap<>();
            context.put("name", "Mitchell");
            Carro carro=new Carro("Blanco", "Ford", new Propietario(17875590, "Ivan Cardenas"));
            context.put("carro", carro);
            List<Carro> lista=new ArrayList<>();
            lista.add(carro);
            lista.add(carro);
            lista.add(carro);
            context.put("listaCarros", lista);
            compiledTemplate.evaluate(writer, context);
            String output = writer.toString();
            System.out.println("Salida \n" + output);
        } catch (PebbleException ex) {
            logger.error(ex);
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            logger.error(ex);
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
