/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.utils.message;

import com.mycompany.marlenproject.data.forms.person.dataFormsPerson;
import java.awt.Component;
import javax.swing.JOptionPane;

public class JPaneMessage {

    public static void incorrectAddressMessage(Component component, String altMsg, String altTitle) {
        String message;
        message = (altMsg == null)
                ? "La dirección solo puede contener letras, números, espacios, el símbolo # y el guion (-)." : altMsg;

        String title;
        title = (altTitle == null)
                ? "Dirección inválida" : altTitle;

        JOptionPane.showMessageDialog(component, message, title, 0);
    }

    public static void incorrectTxtField(Component component, String altMsg, String altTitle) {
        String message = (altMsg == null)
                ? "Solo se permiten letras." : altMsg;

        String title;
        title = (altTitle == null)
                ? "Formato inválido" : altTitle;

        JOptionPane.showMessageDialog(component, message, title, 0);
    }

    public static void incorrectTextArea(Component component, String altMsg, String altTitle) {
        String message = (altMsg == null)
                ? "Solo se permiten números y letras." : altMsg;
        String title;
        title = (altTitle == null)
                ? "Formato inválido" : altTitle;

        JOptionPane.showMessageDialog(component, message, title, 0);
    }

    public static void incorrectNumberField(Component component, String altMsg, String altTitle) {
        String message = (altMsg == null)
                ? "Solo se permiten números." : altMsg;
        String title;
        title = (altTitle == null)
                ? "Formato inválido" : altTitle;

        JOptionPane.showMessageDialog(component, message, title, 0);
    }

    public static void incorrectIdentification(Component component, int type, String altMsg, String altTitle) {
        String message = (altMsg == null)
                ? "Debe ingresar un Numero de identificación válido." : altMsg;
        String title;
        title = (altTitle == null)
                ? "Formato inválido" : altTitle;

        String IdType = dataFormsPerson.IDENTIFICATION_TYPE[type];
        boolean is_Id = (IdType.equals(dataFormsPerson.IDENTIFICATION_TYPE[1]));
        boolean is_ForeingId = (IdType.equals(dataFormsPerson.IDENTIFICATION_TYPE[2]));
        boolean is_Passport = (IdType.equals(dataFormsPerson.IDENTIFICATION_TYPE[3]));

        if (is_Id) {
            message = "La cédula debe ser de 8 o 10 digitos numericos.";
        } else if (is_ForeingId) {
            message = "La cédula de extranjería tener unicamente valores numericos.";
        } else if (is_Passport) {
            message = "El pasaporte debe tener 8 digitos, 2 letras y 6 digitos.";
        }

        JOptionPane.showMessageDialog(component, message, title, 0);
    }

    public static void incorrectEmail(Component component, String altMsg, String altTitle) {
        String message = (altMsg == null)
                ? "Por favor, ingresa un correo electrónico válido. Asegúrate de que tenga un formato correcto, como ejemplo@dominio.com." : altMsg;
        String title;
        title = (altTitle == null)
                ? "Formato inválido" : altTitle;

        JOptionPane.showMessageDialog(component, message, title, 0);
    }

}
