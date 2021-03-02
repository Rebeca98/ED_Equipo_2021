/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fernando
 */
public class ResuelveTest {
    
    public ResuelveTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of revisaErrores method, of class Resuelve.
     */
    @Test
    public void testRevisaErrores() {
        System.out.println("revisaErrores");
        String input = " ( 6 + 1.5 )  * 5 + 5.5 / 5 + 6";
        boolean expResult = true;
        boolean result = Resuelve.revisaErrores(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of agregarCad method, of class Resuelve.
     */
//    @Test
//    public void testAgregarCad() {
//        System.out.println("agregarCad");
//        String cadena = "";
//        String[] expResult = null;
//        String[] result = Resuelve.agregarCad(cadena);
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }

    /**
     * Test of operador method, of class Resuelve.
     */
    @Test
    public void testOperador() {
        System.out.println("operador");
        String cad = "5";
        String expResult = "num";
        String result = Resuelve.operador(cad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getPrioridad method, of class Resuelve.
     */
    @Test
    public void testGetPrioridad() {
        System.out.println("getPrioridad");
        String c = "";
        int expResult = 0;
        int result = Resuelve.getPrioridad(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of jerarquiaOperaciones method, of class Resuelve.
     */
    @Test
    public void testJerarquiaOperaciones() {
        System.out.println("jerarquiaOperaciones");
        String cadena = "+";
        String elemPila = "*";
        boolean expResult = false;
        boolean result = Resuelve.jerarquiaOperaciones(cadena, elemPila);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of convierteAPostfijo method, of class Resuelve.
     */
    @Test
    public void testConvierteAPostfijo() {
        System.out.println("convierteAPostfijo");//( 6 + 1.5 )  * 5 + 5.5 / 5 + 6
        String[] cad1 = new String[14];
        cad1[0] ="("; 
        cad1[1] ="6";
        cad1[2] ="+";
        cad1[3] ="1.5";
        cad1[4] =")";
        cad1[5] ="*"; 
        cad1[6] ="5";
        cad1[7] ="+";
        cad1[8] ="5.5";
        cad1[9] ="/";
        cad1[10] ="5"; 
        cad1[11] ="+";
        cad1[12] ="6";
      
        
        String expResult = " 6 1.5 + 5 * 5.5 5 / + 6 + ";
        String result = Resuelve.convierteAPostfijo(cad1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of resolverPosfijo method, of class Resuelve.
     */
    @Test
    public void testResolverPosfijo() {
        System.out.println("resolverPosfijo");
        String[] cad1 = new String[12];
        
        cad1[0] ="6";
        cad1[1] ="1.5";
        cad1[2] ="+";
        cad1[3] ="5"; 
        cad1[4] ="*";
        cad1[5] ="5.5";
        cad1[6] ="5";
        cad1[7] ="/";
        cad1[8] ="+"; 
        cad1[9] ="6";
        cad1[10] ="+";
        double expResult = 44.6;
        double result = Resuelve.resolverPosfijo(cad1);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
