/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.i2c.checkservers.logica;

import java.io.IOException;
import java.io.Reader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import static com.i2c.checkservers.App.RUTA_RECURSOS;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author icardenas
 */
public class UtilidadJson {

    public List<Servidor> CargarValores() {

        Reader reader = null;
        Gson gson = null;
        try {
            System.out.println("Llego");
            String direccionArchivo = RUTA_RECURSOS + "/servidores.json";
//            FileInputStream fis = new FileInputStream(direccionArchivo);
            reader = new InputStreamReader(new FileInputStream(direccionArchivo), "UTF-8");
            gson = new GsonBuilder().create();
            Type listType = new TypeToken<ArrayList<Servidor>>() {}.getType();
            List<Servidor> p = gson.fromJson(reader, listType);
            System.out.println("no llego");
            for (Servidor p1 : p) {
                System.out.println("USER " + p1);
            }
            return p;
        } catch (UnsupportedEncodingException | FileNotFoundException ex) {
            System.out.println("no llego");
            Logger.getLogger(UtilidadJson.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(UtilidadJson.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
