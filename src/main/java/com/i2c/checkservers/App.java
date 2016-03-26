/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.i2c.checkservers;

import org.apache.log4j.*;
import java.io.File;
import com.i2c.checkservers.controlador.*;

/**
 *
 * @author icardenas
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PropertyConfigurator.configure(new File(App.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent() + "\\log4j.properties");
        ConfiguracionPebble configPebble = new ConfiguracionPebble();
        ServidorSpark sp = new ServidorSpark(configPebble);
        configPebble.inicializar();
        System.out.println("TEXTO TEST \n"+configPebble.parsePlantilla("test.html", null));
    }

}
