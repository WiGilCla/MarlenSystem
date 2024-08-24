/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.marlenproject.userinterface.panelViews.workersSection;

import com.mycompany.marlenproject.logic.CheckFields;
import com.mycompany.marlenproject.logic.request.requestPerson;
import com.mycompany.marlenproject.logic.request.requestWorker;
import com.mycompany.marlenproject.persistence.exceptions.PreexistingEntityException;
import java.awt.Color;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AddWorkerView extends javax.swing.JPanel {
    private final requestPerson NEW_REQUEST_PERSON = new requestPerson();
    private final requestWorker NEW_REQUEST_WORKER = new requestWorker();
    private final CheckFields CHECKER = new CheckFields();
    private final Color COLOR_RED = new Color(255,0,0);
    private final Color COLOR_WHITE = new Color(255,255,255);

    public AddWorkerView() {
        initComponents();
    }
    
    private void personalizedMessage(String type, String message, String title){
        int typeMessage = 0;
        typeMessage = switch (type) {
            case "Error" -> 0;
            case "Information" -> 1;
            case "Warning" -> 2;
            case "Question" -> 3;
            default -> 1;
        };
        JOptionPane.showMessageDialog(this, message,title,typeMessage);
    }
    
    private boolean changeColorRequiredField(){
        String personFirstName = CHECKER.removeStringBlanks(txtFirstName.getText()); 
        String personFirstLastName = CHECKER.removeStringBlanks(txtFirstLastName.getText());
        String personIdentificationType = sltIdentificationType.getSelectedItem().toString();
        String personIdentificationNumber = CHECKER.removeStringBlanks(txtIdentificationNum.getText());
        //Worker information
        String bloodType = sltBloodType.getSelectedItem().toString();
        String bloodTypeCmplt = sltBloodTypeCmplt.getSelectedItem().toString();
        String healthEntity = sltEPS.getSelectedItem().toString();
        String position = sltPosition.getSelectedItem().toString();
        
        if(!CHECKER.checkStringField(personFirstName)){
            txtFirstName.setBackground(COLOR_RED);
            return false;
        }
        if(!CHECKER.checkStringField(personFirstLastName)){
            txtFirstLastName.setBackground(COLOR_RED);
             return false;
        }
        if(!CHECKER.checkComboBox(personIdentificationType)){
            sltIdentificationType.setBackground(COLOR_RED);
            return false;
        }
        if(!CHECKER.checkNumberField(personIdentificationNumber) 
                || !(personIdentificationNumber.length() <= 10  
                && personIdentificationNumber.length() >= 8)){
            txtIdentificationNum.setBackground(COLOR_RED);
            return false;
        }
        if(!CHECKER.checkComboBox(bloodType)){
            sltBloodType.setBackground(COLOR_RED);
            return false;
        }
        if(!CHECKER.checkComboBox(bloodTypeCmplt)){
            sltBloodTypeCmplt.setBackground(COLOR_RED);
            return false;
        }
        if(!CHECKER.checkComboBox(healthEntity)){
            sltEPS.setBackground(COLOR_RED);
            return false;
        }
        if(null == dateBirthdate.getDate()){
            dateBirthdate.setBackground(COLOR_RED);
            return false;
        }
        if(null == dateVinculation.getDate()){
            dateVinculation.setBackground(COLOR_RED);
            return false;
        }
        if(!CHECKER.checkComboBox(position)){
            sltPosition.setBackground(COLOR_RED);
            return false;
        }
        
        return true;
    }
    
    private boolean changeColorNoRequiredField(){
        String personSecondName = CHECKER.removeStringBlanks(txtSecondName.getText()); 
        String personSecondLastName = CHECKER.removeStringBlanks(txtSecondLastName.getText());
        
        
        if(!CHECKER.checkStringField(personSecondName) && !personSecondName.equalsIgnoreCase("")){
            txtSecondName.setBackground(COLOR_RED);
            return false;
        }
        
        if(!CHECKER.checkStringField(personSecondLastName) && !personSecondLastName.equalsIgnoreCase("")){
            txtSecondLastName.setBackground(COLOR_RED);
             return false;
        }
        
        return true;
    }
    
    private void clearFields(){
        txtFirstName.setText("");
        txtSecondName.setText("");
        txtFirstLastName.setText("");
        txtSecondLastName.setText("");
        sltIdentificationType.setSelectedIndex(0);
        txtIdentificationNum.setText("");
        sltBloodType.setSelectedIndex(0);
        sltBloodTypeCmplt.setSelectedIndex(0);
        sltEPS.setSelectedIndex(0);
        dateBirthdate.setDate(null);
        dateVinculation.setDate(null);
        sltPosition.setSelectedIndex(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonsPanel = new javax.swing.JPanel();
        btnCleanFields = new javax.swing.JButton();
        btnSaveWorker = new javax.swing.JButton();
        information1Panel = new javax.swing.JPanel();
        lbsInformation1Panel = new javax.swing.JPanel();
        lbFirstName = new javax.swing.JLabel();
        lbFirstlastName = new javax.swing.JLabel();
        lbIdentificationType = new javax.swing.JLabel();
        lbBloodType = new javax.swing.JLabel();
        lbAge = new javax.swing.JLabel();
        lbPosition = new javax.swing.JLabel();
        dataInformation1Panel = new javax.swing.JPanel();
        txtFirstName = new javax.swing.JTextField();
        txtFirstLastName = new javax.swing.JTextField();
        sltIdentificationType = new javax.swing.JComboBox<>();
        sltPosition = new javax.swing.JComboBox<>();
        sltBloodType = new javax.swing.JComboBox<>();
        sltBloodTypeCmplt = new javax.swing.JComboBox<>();
        dateBirthdate = new com.toedter.calendar.JDateChooser();
        information2Panel = new javax.swing.JPanel();
        lbsInformation2Panel = new javax.swing.JPanel();
        lbSecondName = new javax.swing.JLabel();
        lbSecondLastName = new javax.swing.JLabel();
        lbIdentificationNum = new javax.swing.JLabel();
        lbEps = new javax.swing.JLabel();
        lbDateVinculation = new javax.swing.JLabel();
        dataInformation2Panel = new javax.swing.JPanel();
        txtSecondName = new javax.swing.JTextField();
        txtSecondLastName = new javax.swing.JTextField();
        dateVinculation = new com.toedter.calendar.JDateChooser();
        txtIdentificationNum = new javax.swing.JTextField();
        sltEPS = new javax.swing.JComboBox<>();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "AGREGAR NUEVO TRABAJADOR", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        setPreferredSize(new java.awt.Dimension(970, 576));

        buttonsPanel.setPreferredSize(new java.awt.Dimension(958, 208));

        btnCleanFields.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconDelete.png"))); // NOI18N
        btnCleanFields.setText("Limpiar campos");
        btnCleanFields.setPreferredSize(new java.awt.Dimension(180, 60));
        btnCleanFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanFieldsActionPerformed(evt);
            }
        });

        btnSaveWorker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconSave.png"))); // NOI18N
        btnSaveWorker.setText("Guardar");
        btnSaveWorker.setPreferredSize(new java.awt.Dimension(180, 60));
        btnSaveWorker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveWorkerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonsPanelLayout = new javax.swing.GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(buttonsPanelLayout);
        buttonsPanelLayout.setHorizontalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(btnCleanFields, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addGap(121, 121, 121)
                .addComponent(btnSaveWorker, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addGap(122, 122, 122))
        );
        buttonsPanelLayout.setVerticalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCleanFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveWorker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108))
        );

        information1Panel.setPreferredSize(new java.awt.Dimension(476, 350));

        lbsInformation1Panel.setPreferredSize(new java.awt.Dimension(150, 338));

        lbFirstName.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbFirstName.setText("Primer nombre:");
        lbFirstName.setPreferredSize(new java.awt.Dimension(138, 25));

        lbFirstlastName.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbFirstlastName.setText("Primer apellido:");
        lbFirstlastName.setPreferredSize(new java.awt.Dimension(138, 25));

        lbIdentificationType.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbIdentificationType.setText("Tipo de identificación:");
        lbIdentificationType.setPreferredSize(new java.awt.Dimension(138, 25));

        lbBloodType.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbBloodType.setText("Tipo de sangre:");
        lbBloodType.setPreferredSize(new java.awt.Dimension(138, 25));

        lbAge.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbAge.setText("Fecha de nacimiento:");
        lbAge.setPreferredSize(new java.awt.Dimension(138, 25));

        lbPosition.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbPosition.setText("Cargo:");
        lbPosition.setPreferredSize(new java.awt.Dimension(138, 25));

        javax.swing.GroupLayout lbsInformation1PanelLayout = new javax.swing.GroupLayout(lbsInformation1Panel);
        lbsInformation1Panel.setLayout(lbsInformation1PanelLayout);
        lbsInformation1PanelLayout.setHorizontalGroup(
            lbsInformation1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbsInformation1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lbsInformation1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAge, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbBloodType, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbIdentificationType, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbFirstlastName, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbFirstName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        lbsInformation1PanelLayout.setVerticalGroup(
            lbsInformation1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbsInformation1PanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lbFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbFirstlastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbIdentificationType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbBloodType, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dataInformation1Panel.setPreferredSize(new java.awt.Dimension(308, 338));

        txtFirstName.setPreferredSize(new java.awt.Dimension(296, 25));
        txtFirstName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFirstNameMouseClicked(evt);
            }
        });

        txtFirstLastName.setPreferredSize(new java.awt.Dimension(296, 25));
        txtFirstLastName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFirstLastNameMouseClicked(evt);
            }
        });

        sltIdentificationType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE UNA ...", "Cédula de ciudadanía", "Cédula de extranjería", "Tarjeta pasaporte", "Sin identificación" }));
        sltIdentificationType.setPreferredSize(new java.awt.Dimension(296, 25));
        sltIdentificationType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sltIdentificationTypeMouseClicked(evt);
            }
        });

        sltPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE UNA ...", "Jefe", "Administrador", "Pintor", "Lijador", "Carpintero", "Seguridad", " " }));
        sltPosition.setPreferredSize(new java.awt.Dimension(296, 25));
        sltPosition.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sltPositionMouseClicked(evt);
            }
        });

        sltBloodType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE UNA ...", "A", "B", "O", "AB" }));
        sltBloodType.setPreferredSize(new java.awt.Dimension(136, 25));
        sltBloodType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sltBloodTypeMouseClicked(evt);
            }
        });

        sltBloodTypeCmplt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE UNA ...", "+", "-" }));
        sltBloodTypeCmplt.setPreferredSize(new java.awt.Dimension(136, 25));
        sltBloodTypeCmplt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sltBloodTypeCmpltMouseClicked(evt);
            }
        });

        dateBirthdate.setDateFormatString("dd/MM/yyyy");
        dateBirthdate.setMaxSelectableDate(new Date());
        dateBirthdate.setPreferredSize(new java.awt.Dimension(296, 25));

        javax.swing.GroupLayout dataInformation1PanelLayout = new javax.swing.GroupLayout(dataInformation1Panel);
        dataInformation1Panel.setLayout(dataInformation1PanelLayout);
        dataInformation1PanelLayout.setHorizontalGroup(
            dataInformation1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataInformation1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataInformation1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sltIdentificationType, 0, 0, Short.MAX_VALUE)
                    .addComponent(txtFirstLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(sltPosition, 0, 0, Short.MAX_VALUE)
                    .addGroup(dataInformation1PanelLayout.createSequentialGroup()
                        .addComponent(sltBloodType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(22, 22, 22)
                        .addComponent(sltBloodTypeCmplt, 0, 135, Short.MAX_VALUE))
                    .addComponent(dateBirthdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        dataInformation1PanelLayout.setVerticalGroup(
            dataInformation1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataInformation1PanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFirstLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(sltIdentificationType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(dataInformation1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sltBloodType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sltBloodTypeCmplt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(sltPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout information1PanelLayout = new javax.swing.GroupLayout(information1Panel);
        information1Panel.setLayout(information1PanelLayout);
        information1PanelLayout.setHorizontalGroup(
            information1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(information1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbsInformation1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataInformation1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addContainerGap())
        );
        information1PanelLayout.setVerticalGroup(
            information1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, information1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(information1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dataInformation1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                    .addComponent(lbsInformation1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
                .addContainerGap())
        );

        information2Panel.setPreferredSize(new java.awt.Dimension(476, 350));

        lbsInformation2Panel.setPreferredSize(new java.awt.Dimension(150, 338));

        lbSecondName.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbSecondName.setText("Segundo nombre:");
        lbSecondName.setPreferredSize(new java.awt.Dimension(138, 25));

        lbSecondLastName.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbSecondLastName.setText("Segundo apellido:");
        lbSecondLastName.setPreferredSize(new java.awt.Dimension(138, 25));

        lbIdentificationNum.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbIdentificationNum.setText("Num. de identificación:");
        lbIdentificationNum.setPreferredSize(new java.awt.Dimension(138, 25));

        lbEps.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbEps.setText("Entidad de salud:");
        lbEps.setPreferredSize(new java.awt.Dimension(138, 25));

        lbDateVinculation.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbDateVinculation.setText("Fecha vinculación:");
        lbDateVinculation.setPreferredSize(new java.awt.Dimension(138, 25));

        javax.swing.GroupLayout lbsInformation2PanelLayout = new javax.swing.GroupLayout(lbsInformation2Panel);
        lbsInformation2Panel.setLayout(lbsInformation2PanelLayout);
        lbsInformation2PanelLayout.setHorizontalGroup(
            lbsInformation2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbsInformation2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lbsInformation2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbDateVinculation, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbEps, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbIdentificationNum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbSecondLastName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbSecondName, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        lbsInformation2PanelLayout.setVerticalGroup(
            lbsInformation2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbsInformation2PanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lbSecondName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbSecondLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbIdentificationNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbEps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbDateVinculation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dataInformation2Panel.setPreferredSize(new java.awt.Dimension(308, 338));

        txtSecondName.setPreferredSize(new java.awt.Dimension(296, 25));
        txtSecondName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSecondNameMouseClicked(evt);
            }
        });

        txtSecondLastName.setPreferredSize(new java.awt.Dimension(296, 25));
        txtSecondLastName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSecondLastNameMouseClicked(evt);
            }
        });

        dateVinculation.setDateFormatString("dd/MM/yyyy");
        dateVinculation.setPreferredSize(new java.awt.Dimension(296, 25));
        dateVinculation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dateVinculationMouseClicked(evt);
            }
        });

        txtIdentificationNum.setPreferredSize(new java.awt.Dimension(296, 25));
        txtIdentificationNum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIdentificationNumMouseClicked(evt);
            }
        });

        sltEPS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE UNA ...", "NO POSEE", "ALIANSALUD EPS", "ANAS WAYUU EPSI", "ASMET SALUD", "ASOCIACION INDIGENA DEL CAUCA EPSI", "CAJACOPI ATLANTICO", "CAPRESOCA", "CAPITAL SALUD EPS-S", "COMFACHOCO", "COMFAORIENTE", "COMFENALCO VALLE", "COMPENSAR EPS", "COOSALUD EPS-S", "DUSAKAWI EPSI", "EMS SANITAS", "EMSSANAR E.S.S.", "EPS FAMILIAR DE COLOMBIA", "EPS SANITAS", "EPS SURA", "FAMISANAR", "FONDO DE PASIVO SOCIAL DE FERROCARRILES NACIONALES DE COLOMBIA", "MALLAMAS EPSI", "MUTUAL SER", "NUEVA EPS", "PIJAOS SALUD EPSI", "SALUD BÓLIVAR EPS SAS", "SALUD MIA", "SALUD TOTAL EPS S.A.", "SAVIA SALUD EPS EPSS40", "SERVICIO OCCIDENTAL DE SALUD EPS SOS", "OTRO" }));
        sltEPS.setPreferredSize(new java.awt.Dimension(296, 25));
        sltEPS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sltEPSMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout dataInformation2PanelLayout = new javax.swing.GroupLayout(dataInformation2Panel);
        dataInformation2Panel.setLayout(dataInformation2PanelLayout);
        dataInformation2PanelLayout.setHorizontalGroup(
            dataInformation2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataInformation2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataInformation2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSecondName, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtSecondLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtIdentificationNum, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(dateVinculation, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(sltEPS, 0, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        dataInformation2PanelLayout.setVerticalGroup(
            dataInformation2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataInformation2PanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(txtSecondName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSecondLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(txtIdentificationNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sltEPS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(dateVinculation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout information2PanelLayout = new javax.swing.GroupLayout(information2Panel);
        information2Panel.setLayout(information2PanelLayout);
        information2PanelLayout.setHorizontalGroup(
            information2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(information2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbsInformation2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataInformation2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addContainerGap())
        );
        information2PanelLayout.setVerticalGroup(
            information2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, information2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(information2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dataInformation2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                    .addComponent(lbsInformation2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(information1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(information2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(information1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                    .addComponent(information2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCleanFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanFieldsActionPerformed
        clearFields();
    }//GEN-LAST:event_btnCleanFieldsActionPerformed

    private void btnSaveWorkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveWorkerActionPerformed
            
            
            String personFirstName = CHECKER.removeStringBlanks(txtFirstName.getText()); 
            String personSecondName = CHECKER.removeStringBlanks(txtSecondName.getText());//
            String personFirstLastName = CHECKER.removeStringBlanks(txtFirstLastName.getText());
            String personSecondLastName = CHECKER.removeStringBlanks(txtSecondLastName.getText());//
            String personIdentificationType = sltIdentificationType.getSelectedItem().toString();
            String personIdentificationNumber = CHECKER.removeStringBlanks(txtIdentificationNum.getText());
            Date personBirthdate = dateBirthdate.getDate();
            //Worker information
            String bloodType = sltBloodType.getSelectedItem().toString();
            String bloodTypeCmplt = sltBloodTypeCmplt.getSelectedItem().toString();
            String healthEntity = sltEPS.getSelectedItem().toString();
            Date dayLink = dateVinculation.getDate();
            String position = sltPosition.getSelectedItem().toString();
            
            
            if(changeColorRequiredField() && changeColorNoRequiredField()){
                try {
                    NEW_REQUEST_PERSON.savePerson(personFirstName, personSecondName, 
                            personFirstLastName, personSecondLastName, personIdentificationType, 
                            personIdentificationNumber, personBirthdate);
                    NEW_REQUEST_WORKER.saveWorker(personIdentificationNumber, bloodType, 
                            bloodTypeCmplt, healthEntity, dayLink, position);
                    personalizedMessage("Information", "El trabajador ha sido agregado correctamente", "Operación exitosa");
                    clearFields();
                } catch (PreexistingEntityException ex) {
                    personalizedMessage("Error", "El numero de identificación ya está asociado a alguien.", 
                            "Identificación duplicada");
                    txtIdentificationNum.setBackground(COLOR_RED);
                }  catch (Exception ex) {
                    Logger.getLogger(AddWorkerView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                personalizedMessage("Warning", "Asegurese de que los campos en rojo estén correctamente diligenciados", "Error en Campos");
            }
            
            
    }//GEN-LAST:event_btnSaveWorkerActionPerformed

    private void txtFirstNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFirstNameMouseClicked
        txtFirstName.setBackground(COLOR_WHITE);
    }//GEN-LAST:event_txtFirstNameMouseClicked

    private void txtSecondNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSecondNameMouseClicked
        txtSecondName.setBackground(COLOR_WHITE);
    }//GEN-LAST:event_txtSecondNameMouseClicked

    private void txtFirstLastNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFirstLastNameMouseClicked
        txtFirstLastName.setBackground(COLOR_WHITE);
    }//GEN-LAST:event_txtFirstLastNameMouseClicked

    private void txtSecondLastNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSecondLastNameMouseClicked
        txtSecondLastName.setBackground(COLOR_WHITE);
    }//GEN-LAST:event_txtSecondLastNameMouseClicked

    private void sltIdentificationTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sltIdentificationTypeMouseClicked
        sltIdentificationType.setBackground(COLOR_WHITE);
    }//GEN-LAST:event_sltIdentificationTypeMouseClicked

    private void txtIdentificationNumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdentificationNumMouseClicked
        txtIdentificationNum.setBackground(COLOR_WHITE);
    }//GEN-LAST:event_txtIdentificationNumMouseClicked

    private void sltBloodTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sltBloodTypeMouseClicked
        sltBloodType.setBackground(COLOR_WHITE);
    }//GEN-LAST:event_sltBloodTypeMouseClicked

    private void sltBloodTypeCmpltMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sltBloodTypeCmpltMouseClicked
        sltBloodTypeCmplt.setBackground(COLOR_WHITE);
    }//GEN-LAST:event_sltBloodTypeCmpltMouseClicked

    private void sltEPSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sltEPSMouseClicked
        sltEPS.setBackground(COLOR_WHITE);
    }//GEN-LAST:event_sltEPSMouseClicked

    private void dateVinculationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateVinculationMouseClicked
        dateVinculation.setBackground(COLOR_WHITE);
    }//GEN-LAST:event_dateVinculationMouseClicked

    private void sltPositionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sltPositionMouseClicked
        sltPosition.setBackground(COLOR_WHITE);
    }//GEN-LAST:event_sltPositionMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCleanFields;
    private javax.swing.JButton btnSaveWorker;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JPanel dataInformation1Panel;
    private javax.swing.JPanel dataInformation2Panel;
    private com.toedter.calendar.JDateChooser dateBirthdate;
    private com.toedter.calendar.JDateChooser dateVinculation;
    private javax.swing.JPanel information1Panel;
    private javax.swing.JPanel information2Panel;
    private javax.swing.JLabel lbAge;
    private javax.swing.JLabel lbBloodType;
    private javax.swing.JLabel lbDateVinculation;
    private javax.swing.JLabel lbEps;
    private javax.swing.JLabel lbFirstName;
    private javax.swing.JLabel lbFirstlastName;
    private javax.swing.JLabel lbIdentificationNum;
    private javax.swing.JLabel lbIdentificationType;
    private javax.swing.JLabel lbPosition;
    private javax.swing.JLabel lbSecondLastName;
    private javax.swing.JLabel lbSecondName;
    private javax.swing.JPanel lbsInformation1Panel;
    private javax.swing.JPanel lbsInformation2Panel;
    private javax.swing.JComboBox<String> sltBloodType;
    private javax.swing.JComboBox<String> sltBloodTypeCmplt;
    private javax.swing.JComboBox<String> sltEPS;
    private javax.swing.JComboBox<String> sltIdentificationType;
    private javax.swing.JComboBox<String> sltPosition;
    private javax.swing.JTextField txtFirstLastName;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtIdentificationNum;
    private javax.swing.JTextField txtSecondLastName;
    private javax.swing.JTextField txtSecondName;
    // End of variables declaration//GEN-END:variables
}
