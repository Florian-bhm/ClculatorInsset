/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.shared;

import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.Exception;

/**
 *
 * @author user
 */
public class FieldVerifierTest {
    
    /**
     * Test if date works as expected when good
     */
    @Test
    public void testIsValidDateOK() {
        FieldVerifier instance = new FieldVerifier();
        boolean resExpected = true;
        boolean resultat = instance.isValidDate("14/04/2016");
        
         assertEquals(resExpected, resultat);
    }
    
    /**
     * Test if date works as expected when false format
     */
    @Test
    public void testIsValidDateKO() {
        FieldVerifier instance = new FieldVerifier();
        boolean resExpected = false;
        boolean resultat = instance.isValidDate("14/04/19988");
        
        assertEquals(resExpected, resultat);
    }
    
    /**
     * Test if date works as expected when false format
     */
    @Test
    public void testIsValidDateKO31February() {
        FieldVerifier instance = new FieldVerifier();
        boolean resExpected = false;
        boolean resultat = instance.isValidDate("31/02/1998");
        
        assertEquals(resExpected, resultat);
    }
    
    /**
     * Test if decimal format works as expected when good
     */
    @Test
    public void testIsValidDecimalOK() {
        FieldVerifier instance = new FieldVerifier();
        boolean resExpected = true;
        boolean resultat = instance.isValidDecimal(198);
        
        assertEquals(resExpected, resultat);
    }
    
    /**
     * Test if decimal format works as expected when wrong format
     */
    @Test
    public void testIsValidDecimalKo() {
        FieldVerifier instance = new FieldVerifier();
        boolean resExpected = false;
        boolean resultat = instance.isValidDecimal(19898);
        
        assertEquals(resExpected, resultat);
    }
    
    /**
     * Test if name format works as expected when good
     */
    @Test
    public void testIsValidNameOk() {
        FieldVerifier instance = new FieldVerifier();
        boolean resExpected = true;
        boolean resultat = instance.isValidName("Name");
        
        assertEquals(resExpected, resultat);
    }
    
    /**
     * Test if name format works as expected when wrong
     */
    @Test
    public void testIsValidNameKo() {
        FieldVerifier instance = new FieldVerifier();
        boolean resExpected = false;
        boolean resultat = instance.isValidName("");
        
        assertEquals(resExpected, resultat);
    }
   
    /**
     * Test of isValidRoman method, of class FieldVerifier.
     */
    @Test
    public void testIsValidRomanKO() {
        String nbr = "ZZER";
        boolean expResult = false;
        boolean result = FieldVerifier.isValidRoman(nbr);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isValidRoman method, of class FieldVerifier.
     */
    @Test
    public void testIsValidRomanKOVide() {
        String nbr = "";
        boolean expResult = false;
        boolean result = FieldVerifier.isValidRoman(nbr);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isValidRoman method, of class FieldVerifier.
     */
    @Test
    public void testIsValidRomanOK() {
        String nbr = "MDCLXVI";
        boolean expResult = true;
        boolean result = FieldVerifier.isValidRoman(nbr);
        assertEquals(expResult, result);
    }  
}
