/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.i2c.checkservers.logica;

import com.google.gson.Gson;
import junit.framework.TestCase;

/**
 *
 * @author icardenas
 */
public class UtilidadJsonTest extends TestCase {
    
    public UtilidadJsonTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of CargarValores method, of class UtilidadJson.
     */
    public void testCargarValores() {
        System.out.println("CargarValores");
        UtilidadJson instance = new UtilidadJson();
        Gson expResult = null;
        Object v = instance.CargarValores();
        
//        System.out.println(result.toString());
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
