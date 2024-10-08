/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.logic;

import java.util.Date;

public class CheckFields {

    public boolean checkStringField(String text) {
        return text.matches("[a-zA-ZÁ-Úá-úÑñ]+");
    }

    public boolean checkStringTextArea(String text) {
        return text.matches("[a-zA-ZÁ-Úá-úÑñ0-9]+");
    }

    public boolean checkNumberField(String number) {
        return number.matches("[0-9]+");
    }

    public String removeStringBlanks(String text) {
        if (!text.isEmpty()) {
            return text.replaceAll("[\\s.]+", "");
        }
        return text;
    }

    public boolean checkEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }

    public boolean checkComboBox(String text) {
        return !text.equalsIgnoreCase("SELECCIONE UNA ...");
    }

    public String capitalizedString(String text) {
        if (!text.isEmpty()) {
            String firstLetter = text.substring(0, 1).toUpperCase();
            String otherLetter = text.substring(1).toLowerCase();
            return firstLetter + otherLetter;
        }
        return text;
    }

    public int timeElapsed(Date oldDate, Date laterDate) {
        long tiempoTranscurridoMillis = laterDate.getTime() - oldDate.getTime();
        long segundosTranscurridos = tiempoTranscurridoMillis / 1000;
        long minutosTranscurridos = segundosTranscurridos / 60;
        long horasTranscurridas = minutosTranscurridos / 60;
        long diasTranscurridos = horasTranscurridas / 24;
        long añosTranscurridos = diasTranscurridos / 365;
        return (int) añosTranscurridos;
    }
}
