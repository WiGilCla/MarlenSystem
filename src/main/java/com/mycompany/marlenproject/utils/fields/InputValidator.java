/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.utils.fields;

import com.mycompany.marlenproject.data.forms.person.dataFormsPerson;
import java.util.Date;
import javax.swing.JOptionPane;

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

    public static boolean checkIdentification(int type, String personDNI) {
        if (type == dataFormsPerson.getNoOneOptionSelected() || type == -1 ) {
            return false;
        }

        String IdType = dataFormsPerson.IDENTIFICATION_TYPE[type];
        boolean is_Id = (IdType.equals(dataFormsPerson.IDENTIFICATION_TYPE[1]));
        boolean is_ForeingId = (IdType.equals(dataFormsPerson.IDENTIFICATION_TYPE[2]));
        boolean is_Passport = (IdType.equals(dataFormsPerson.IDENTIFICATION_TYPE[3]));

        if (is_Id) {
            return (personDNI.length() == 8 || personDNI.length() == 10) && personDNI.matches("[0-9]+");
            
        } else if (is_Passport) {
            return personDNI.length() == 8
                    && personDNI.chars().filter(Character::isDigit).count() == 6
                    && personDNI.chars().filter(Character::isLetter).count() == 2;

        } else if (is_ForeingId) {
            return personDNI.matches("[0-9]+");
        } else {
            return false;
        }
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
