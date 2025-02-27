/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.data.forms.worker;

import java.util.Arrays;

public class dataFormsWorker {

    private static final int NO_SELECTED_OPTION = 0;

    public static int getNoOneOptionSelected() {
        return NO_SELECTED_OPTION;
    }

    public static final String[] BLOOD_GROUP = {"SELECCIONE UNA ...", "A", "B", "O", "AB"};
    public static final String[] BLOOD_GROUP_RHD = {"SELECCIONE UNA ...", "+", "-"};
    public static final String[] JOB_TITLE = {"SELECCIONE UNA ...", "Jefe", "Administrador",
        "Pintor", "Lijador", "Carpintero", "Seguridad"};
    public static final String[] HEALTH_ENTITY = {"SELECCIONE UNA ...", "NO POSEE", "ALIANSALUD EPS",
        "ANAS WAYUU EPSI", "ASMET SALUD", "ASOCIACION INDIGENA DEL CAUCA EPSI",
        "CAJACOPI ATLANTICO", "CAPRESOCA", "CAPITAL SALUD EPS-S", "COMFACHOCO",
        "COMFAORIENTE", "COMFENALCO VALLE", "COMPENSAR EPS", "COOSALUD EPS-S",
        "DUSAKAWI EPSI", "EMS SANITAS", "EMSSANAR E.S.S.", "EPS FAMILIAR DE COLOMBIA",
        "EPS SANITAS", "EPS SURA", "FAMISANAR", "FONDO DE PASIVO SOCIAL DE FERROCARRILES NACIONALES DE COLOMBIA",
        "MALLAMAS EPSI", "MUTUAL SER", "NUEVA EPS", "PIJAOS SALUD EPSI", "SALUD BÓLIVAR EPS SAS", "SALUD MIA",
        "SALUD TOTAL EPS S.A.", "SAVIA SALUD EPS EPSS40", "SERVICIO OCCIDENTAL DE SALUD EPS SOS"};
    public static final String[] STATUS = {"SELECCIONE UNA ...", "NO ACTIVO", "ACTIVO"};

    public static int getIndexStatusActive() {
        return Arrays.asList(STATUS).indexOf("ACTIVO");
    }

    public static int getIndexStatusNoActive() {
        return Arrays.asList(STATUS).indexOf("NO ACTIVO");
    }

    public static int findIndexSelected(String[] list, String value) {
        return Arrays.asList(list).indexOf(value);
    }

}
