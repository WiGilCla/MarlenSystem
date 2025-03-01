/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.utils.message;

import com.mycompany.marlenproject.data.forms.person.dataFormsPerson;
import java.awt.Component;
import javax.swing.JOptionPane;

public class JPaneMessage {

    private static String generateMessage(String Message, String[] conditions) {

        String finalMessage = Message;

        if (conditions != null && conditions.length > 0) {
            finalMessage += " ";
            for (String condition : conditions) {
                finalMessage += "*. " + condition + " ";
            }
        }

        return finalMessage;
    }

    public static void incorrectAddressMessage(Component component, String altMsg, String altTitle, String[] altCond) {
        
        String title = (altTitle == null)
                ? "Formato de dirección erróneo" : altTitle;
        
        String message = (altMsg == null)
                ? "El campo de dirección puede incluir:" : altMsg;

        String[] conditions = altCond;
        if (conditions == null) {
            conditions = new String[]{"Letras.", "Números.",
                "Numeral (#).", "Guión medio (-)."};
        }

        message = generateMessage(message, conditions);
        JOptionPane.showMessageDialog(component, message, title, 0);
    }

    public static void incorrectTxtField(Component component, String altMsg, String altTitle, String[] altCond) {
        
        String title = (altTitle == null)
                ? "Formato de texto erróneo" : altTitle;

        String message = (altMsg == null)
                ? "Los campos de texto pueden incluir: " : altMsg;

        String[] conditions = altCond;
        if (conditions == null) {
            conditions = new String[]{"Mayúsculas / Minúsculas",
                "Letras de la A hasta la Z (Incluyendo Ñ)"};
        }
        
        message = generateMessage(message, conditions);
        JOptionPane.showMessageDialog(component, message, title, 0);
    }

    public static void incorrectTextArea(Component component, String altMsg, String altTitle, String[] altCond) {

        String title = (altTitle == null)
                ? "Formato de texto erróneo" : altTitle;

        String message = (altMsg == null)
                ? "Las areas de texto pueden incluir:" : altMsg;

        String[] conditions = altCond;
        if (conditions == null) {
            conditions = new String[]{"Mayúsculas / Minúsculas.",
                "Letras de la A hasta la Z (Incluyendo Ñ).", "Números."};
        }
        
        message = generateMessage(message, conditions);
        JOptionPane.showMessageDialog(component, message, title, 0);
    }

    public static void incorrectNumberField(Component component, String altMsg, String altTitle, String[] altCond) {
        
        String title = (altTitle == null)
                ? "Formato de número erróneo" : altTitle;

        String message = (altMsg == null)
                ? "Los campos númericos pueden incluir:" : altMsg;

        String[] conditions = altCond;
        if (conditions == null) {
            conditions = new String[]{"Números."};
        }
        
        message = generateMessage(message, conditions);
        JOptionPane.showMessageDialog(component, message, title, 0);
    }

    public static void incorrectIdentification(Component component, int type, String altMsg, String altTitle, String[] altCond) {
        
        String title = (altTitle == null)
                ? "Formato de identificación erróneo" : altTitle;

        String message = (altMsg == null)
                ? "Debe ingresar una identificación válida." : altMsg;

        String[] conditions = altCond;

        String IdType = dataFormsPerson.IDENTIFICATION_TYPE[type];
        boolean is_Id = (IdType.equals(dataFormsPerson.IDENTIFICATION_TYPE[1]));
        boolean is_ForeingId = (IdType.equals(dataFormsPerson.IDENTIFICATION_TYPE[2]));
        boolean is_Passport = (IdType.equals(dataFormsPerson.IDENTIFICATION_TYPE[3]));

        if (is_Id) {
            message = "La cédula de ciudadanía debe tener:";
            conditions = new String[]{"Números.", "8 o 10 dígitos."};

        } else if (is_ForeingId) {
            message = "La cédula de extranjería debe tener:";
            conditions = new String[]{"Números."};
        } else if (is_Passport) {
            message = "El pasaporte debe tener:";
            conditions = new String[]{"2 Letras.", "6 Números"};
        }

        message = generateMessage(message, conditions);
        JOptionPane.showMessageDialog(component, message, title, 0);
    }

    public static void incorrectEmail(Component component, String altMsg, String altTitle, String[] altCond) {
        
        String title = (altTitle == null)
                ? "Formato de Email erróneo " : altTitle;

        String message = (altMsg == null)
                ? "El correo electrónico debe tener el siguiente formato: " : altMsg;

        String[] conditions = altCond;
        if (conditions == null) {
            conditions = new String[]{"ejemplo@dominio.com"};
        }
        
        message = generateMessage(message, conditions);
        JOptionPane.showMessageDialog(component, message, title, 0);
    }

}
