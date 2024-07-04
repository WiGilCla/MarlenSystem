/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.logic;

import java.util.Calendar;

/**
 *
 * @author willy
 */
public class CheckFields {
    public boolean checkStringField(String text){
        return text.matches("[a-zA-ZÁ-Úá-úÑñ]+");
    }
    
    public boolean checkNumberField(String number){
        return number.matches("[0-9]+");
    }
    
    public String removeStringBlanks(String text){
        if(!text.isEmpty()){
            return text.replaceAll("[\\s.]+", "");
        }
        return text;
    }
    
    public boolean checkComboBox(String text){
        return !text.equalsIgnoreCase("SELECCIONE UNA ...");
    }
    
    public String capitalizedString(String text){
        if(!text.isEmpty()){
            String firstLetter = text.substring(0, 1).toUpperCase();
            String otherLetter = text.substring(1).toLowerCase();
            return firstLetter + otherLetter;
        }
        return text;
    }
}
