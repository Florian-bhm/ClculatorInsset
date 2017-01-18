/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import org.insset.client.message.dialogbox.DialogBoxInssetPresenter;
import org.insset.client.service.RomanConverterService;

/**
 *
 * @author user
 */
@SuppressWarnings("serial")
public class RomanConverterServiceImpl extends RemoteServiceServlet implements
        RomanConverterService {

    /**
     * Map for matching each roman element to a value
     */
    private final Map<Integer, String> correspondanceRomainDecimal = new TreeMap<Integer, String>(Collections.reverseOrder()) {
        {
            put(1000, "M");
            put(900, "CM");
            put(500, "D");
            put(400, "CD");
            put(100, "C");
            put(90, "XC");
            put(50, "L");
            put(40, "XL");
            put(10, "X");
            put(9, "IX");
            put(5, "V");
            put(4, "IV");
            put(1, "I");

        }
    };

    /**
     * Convert a decimal date year to a roman date yeaf
     * @param nbr the string date in decimal
     * @return the date in roman format 
     * @throws IllegalArgumentException 
     */
    @Override
    public String convertDateYears(String nbr) throws IllegalArgumentException {
        String resultat = "";
      
        String[] date = nbr.split("\\/|-");
        resultat = convertArabeToRoman(Integer.valueOf(date[0])) + 
                "/" + convertArabeToRoman(Integer.valueOf(date[1]))+
                "/" + convertArabeToRoman(Integer.valueOf(date[2]));
         
        return resultat;
    }

    /**
     * Convert a roman value to a decimal value
     * @param nbr the roman value in string
     * @return a integer which is a convert from roman value
     * @throws IllegalArgumentException 
     */
    @Override
    public Integer convertRomanToArabe(String nbr) throws IllegalArgumentException {
        
        int decimal = 0;
        int lastNumber = 0;
        String romanNumeral = nbr.toUpperCase();
        /* operation to be performed on upper cases even if user 
           enters roman values in lower case chars */
        for (int x = romanNumeral.length() - 1; x >= 0 ; x--) {
            char convertToDecimal = romanNumeral.charAt(x);

            switch (convertToDecimal) {
                case 'M':
                    decimal = processDecimal(1000, lastNumber, decimal);
                    lastNumber = 1000;
                    break;

                case 'D':
                    decimal = processDecimal(500, lastNumber, decimal);
                    lastNumber = 500;
                    break;

                case 'C':
                    decimal = processDecimal(100, lastNumber, decimal);
                    lastNumber = 100;
                    break;

                case 'L':
                    decimal = processDecimal(50, lastNumber, decimal);
                    lastNumber = 50;
                    break;

                case 'X':
                    decimal = processDecimal(10, lastNumber, decimal);
                    lastNumber = 10;
                    break;

                case 'V':
                    decimal = processDecimal(5, lastNumber, decimal);
                    lastNumber = 5;
                    break;

                case 'I':
                    decimal = processDecimal(1, lastNumber, decimal);
                    lastNumber = 1;
                    break;
            }
        }
        
        if (decimal >2000){
           
        } 
        return decimal;        
    }

    /**
     * Algo for add or remove value when converting roman to decimal
     * @param decimal actualValue
     * @param lastNumber last low value (substract)
     * @param lastDecimal substract
     * @return new value of actual integer
     */
    public static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
        if (lastNumber > decimal) {
            return lastDecimal - decimal;
        } else {
            return lastDecimal + decimal;
        }
    }
       
    /**
     * Convert a decimal value to roman
     * @param input the integer write by user
     * @return the roman string
     * @throws IllegalArgumentException 
     */
    @Override
    public String convertArabeToRoman(Integer input) throws IllegalArgumentException {
        String string = "";
        
        for(Integer i : correspondanceRomainDecimal.keySet()) {
            while(input >= i)
            {
                string += correspondanceRomainDecimal.get(i);
                input-= i;
            }
        }
               
        return string;
    }
}
