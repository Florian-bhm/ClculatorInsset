/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.shared;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class FieldVerifierTest {
   
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
    @Test
    public void testIsValidRomanKOVide() {
        String nbr = "";
        boolean expResult = false;
        boolean result = FieldVerifier.isValidRoman(nbr);
        assertEquals(expResult, result);
    }
    @Test
    public void testIsValidRomanOK() {
        String nbr = "MDCLXVI";
        boolean expResult = true;
        boolean result = FieldVerifier.isValidRoman(nbr);
        assertEquals(expResult, result);
    }  
}
