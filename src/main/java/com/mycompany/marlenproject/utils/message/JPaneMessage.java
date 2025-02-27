/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.utils.message;

import java.awt.Component;
import javax.swing.JOptionPane;

public class JPaneMessage {

    public static void incorrectAddressMessage(Component component, String altMsg, String altTitle) {
        String message;
        message = (altMsg == null)
                ? "La dirección solo puede contener letras, números, espacios, el símbolo # y el guion (-)." : altMsg;
        
        String title;
        title = (altTitle == null)
                ? "Dirección inválida":altTitle;

        JOptionPane.showMessageDialog(component, message, title, 0);
    }

    public static void incorrectTxtField(Component component, String altMsg, String altTitle) {
        String message = (altMsg == null)
                ? "Solo se permiten letras." : altMsg;
        
        String title;
        title = (altTitle == null)
                ? "Formato inválido":altTitle;

        JOptionPane.showMessageDialog(component, message, title, 0);
    }
    
    public static void incorrectTextArea(Component component, String altMsg, String altTitle) {
        String message = (altMsg == null)
                ? "Solo se permiten números y letras." : altMsg;
        String title;
        title = (altTitle == null)
                ? "Formato inválido":altTitle;

        JOptionPane.showMessageDialog(component, message, title, 0);
    }
    
    public static void incorrectNumberField(Component component, String altMsg, String altTitle) {
        String message = (altMsg == null)
                ? "Solo se permiten números." : altMsg;
        String title;
        title = (altTitle == null)
                ? "Formato inválido":altTitle;

        JOptionPane.showMessageDialog(component, message, title, 0);
    }
    
    public static void incorrectDni(Component component, String altMsg, String altTitle) {
        String message = (altMsg == null)
                ? "Solo se permite un número entre 8 y 10 dígitos." : altMsg;
        String title;
        title = (altTitle == null)
                ? "Formato inválido":altTitle;

        JOptionPane.showMessageDialog(component, message, title, 0);
    }
    
    public static void incorrectEmail(Component component, String altMsg, String altTitle) {
        String message = (altMsg == null)
                ? "Por favor, ingresa un correo electrónico válido. Asegúrate de que tenga un formato correcto, como ejemplo@dominio.com." : altMsg;
        String title;
        title = (altTitle == null)
                ? "Formato inválido":altTitle;

        JOptionPane.showMessageDialog(component, message, title, 0);
    }

}
