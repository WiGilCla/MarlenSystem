/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.utils.fields;

import java.util.Date;

public class InputValidator {
    
    public static boolean checkAddress(String address) {        
        return address.matches("^[a-zA-Z0-9\\s#-]*$");
    }

    public static boolean checkStringField(String text) {
        return text.matches("[a-zA-ZÁ-Úá-úÑñ]+");
    }

    public static boolean checkStringTextArea(String text) {
        return text.matches("[a-zA-ZÁ-Úá-úÑñ0-9]+");
    }

    public static boolean checkNumberField(String number) {
        return number.matches("[0-9]+");
    }
    
    public static boolean checkDNILength(String personDNI){
        return (personDNI.length() >= 8 && personDNI.length() <=10) && personDNI.matches("[0-9]+"); 
    }

    public static String removeStringBlanks(String text) {
        if (!text.isEmpty()) {
            return text.replaceAll("[\\s.]+", "");
        }
        return text;
    }

    public static boolean checkEmail(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }

    public static boolean checkComboBox(String text) {
        return !text.equalsIgnoreCase("SELECCIONE UNA ...");
    }

    public static String capitalizedString(String text) {
        if (!text.isEmpty()) {
            String firstLetter = text.substring(0, 1).toUpperCase();
            String otherLetter = text.substring(1).toLowerCase();
            return firstLetter + otherLetter;
        }
        return text;
    }

    public static int timeElapsed(Date oldDate, Date laterDate) {
        long tiempoTranscurridoMillis = laterDate.getTime() - oldDate.getTime();
        long segundosTranscurridos = tiempoTranscurridoMillis / 1000;
        long minutosTranscurridos = segundosTranscurridos / 60;
        long horasTranscurridas = minutosTranscurridos / 60;
        long diasTranscurridos = horasTranscurridas / 24;
        long añosTranscurridos = diasTranscurridos / 365;
        return (int) añosTranscurridos;
    }
}
