/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marlenproject.userinterface.panelViews.workersSection;

/**
 *
 * @author willy
 */
public class ComboBoxWorkerOptions {

    private final String[] identificationTypeOptions = {"SELECCIONE UNA ...", "Cédula de ciudadanía",
        "Cédula de extranjería", "Tarjeta pasaporte", "Sin identificación"};
    private final String[] bloodGroupOptions = {"SELECCIONE UNA ...", "A", "B", "O", "AB"};
    private final String[] bloodGroupRhdOptions = {"SELECCIONE UNA ...", "+", "-"};
    private final String[] positionOptions = {"SELECCIONE UNA ...", "Jefe", "Administrador",
        "Pintor", "Lijador", "Carpintero", "Seguridad"};
    private final String[] healthEntityOptions = {"SELECCIONE UNA ...", "NO POSEE", "ALIANSALUD EPS",
        "ANAS WAYUU EPSI", "ASMET SALUD", "ASOCIACION INDIGENA DEL CAUCA EPSI",
        "CAJACOPI ATLANTICO", "CAPRESOCA", "CAPITAL SALUD EPS-S", "COMFACHOCO",
        "COMFAORIENTE", "COMFENALCO VALLE", "COMPENSAR EPS", "COOSALUD EPS-S",
        "DUSAKAWI EPSI", "EMS SANITAS", "EMSSANAR E.S.S.", "EPS FAMILIAR DE COLOMBIA",
        "EPS SANITAS", "EPS SURA", "FAMISANAR", "FONDO DE PASIVO SOCIAL DE FERROCARRILES NACIONALES DE COLOMBIA",
        "MALLAMAS EPSI", "MUTUAL SER", "NUEVA EPS", "PIJAOS SALUD EPSI", "SALUD BÓLIVAR EPS SAS", "SALUD MIA",
        "SALUD TOTAL EPS S.A.", "SAVIA SALUD EPS EPSS40", "SERVICIO OCCIDENTAL DE SALUD EPS SOS", "OTRO"};

    public ComboBoxWorkerOptions() {
    }

    public String[] getIdentificationTypeOptions() {
        return identificationTypeOptions;
    }

    public String[] getBloodGroupOptions() {
        return bloodGroupOptions;
    }

    public String[] getBloodGroupRhdOptions() {
        return bloodGroupRhdOptions;
    }

    public String[] getPositionOptions() {
        return positionOptions;
    }

    public String[] getHealthEntityOptions() {
        return healthEntityOptions;
    }

    public int findIndexSelected(String[] list,String value) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equalsIgnoreCase(value)) {
                return i;
            }
        }
        return -1;
    }
    
}
