/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.data.forms.person;

public class dataFormsPerson {
    private static final int NO_SELECTED_OPTION = 0;

    public static final String[] IDENTIFICATION_TYPE = {"SELECCIONE UNA ...", "Cédula de ciudadanía",
        "Cédula de extranjería", "Tarjeta pasaporte"};

    public static int getNoOneOptionSelected() {
        return NO_SELECTED_OPTION;
    }

    public static int findIndexSelected(String[] list, String value) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equalsIgnoreCase(value)) {
                return i;
            }
        }
        return 0;
    }

}
