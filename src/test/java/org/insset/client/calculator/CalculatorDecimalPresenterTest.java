/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.calculator;

import org.insset.server.RomanConverterServiceImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class CalculatorDecimalPresenterTest {
    
    public CalculatorDecimalPresenterTest() {
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

    
    @Test
    public void convertRomanToArabeOK() {
        System.out.println("Conversion roman to arabe Ok");
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        String nbr = "MLDCXVI";
        Integer ResexpResult = 1566;
        Integer result = instance.convertRomanToArabe(nbr);
        assertEquals(ResexpResult, result);
    }
   
}
 