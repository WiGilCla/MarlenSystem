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
/**
 *
 * @author willy
 */
public class AddWorkerView extends javax.swing.JPanel {
    private final requestPerson newRequestPerson = new requestPerson();
    private final requestWorker newRequestWorker = new requestWorker();
    private final CheckFields checker = new CheckFields();
    private final Color colorRed = new Color(255,0,0);
    private final Color colorWhite = new Color(255,255,255);

    /**
     * Creates new form SecondWorkersView
     */
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
        JOptionPane.showMessageDialog(buttonsPanel, message,title,typeMessage);
    }
    
    private boolean changeColorRequiredField(){
        String personFirstName = checker.removeStringBlanks(txtFirstName.getText()); 
        String personFirstLastName = checker.removeStringBlanks(txtFirstLastName.getText());
        String personIdentificationType = sltIdentificationType.getSelectedItem().toString();
        String personIdentificationNumber = checker.removeStringBlanks(txtIdentificationNum.getText());
        //Worker information
        String bloodType = sltBloodType.getSelectedItem().toString();
        String bloodTypeCmplt = sltBloodTypeCmplt.getSelectedItem().toString();
        String healthEntity = sltEPS.getSelectedItem().toString();
        String position = sltPosition.getSelectedItem().toString();
        
        if(!checker.checkStringField(personFirstName)){
            txtFirstName.setBackground(colorRed);
            return false;
        }
        if(!checker.checkStringField(personFirstLastName)){
            txtFirstLastName.setBackground(colorRed);
             return false;
        }
        if(!checker.checkComboBox(personIdentificationType)){
            sltIdentificationType.setBackground(colorRed);
            return false;
        }
        if(!checker.checkNumberField(personIdentificationNumber) 
                || !(personIdentificationNumber.length() <= 10  
                && personIdentificationNumber.length() >= 8)){
            txtIdentificationNum.setBackground(colorRed);
            return false;
        }
        if(!checker.checkComboBox(bloodType)){
            sltBloodType.setBackground(colorRed);
            return false;
        }
        if(!checker.checkComboBox(bloodTypeCmplt)){
            sltBloodTypeCmplt.setBackground(colorRed);
            return false;
        }
        if(!checker.checkComboBox(healthEntity)){
            sltEPS.setBackground(colorRed);
            return false;
        }
        if(null == dateBirthdate.getDate()){
            dateBirthdate.setBackground(colorRed);
            return false;
        }
        if(null == dateVinculation.getDate()){
            dateVinculation.setBackground(colorRed);
            return false;
        }
        if(!checker.checkComboBox(position)){
            sltPosition.setBackground(colorRed);
            return false;
        }
        
        return true;
    }
    
    private boolean changeColorNoRequiredField(){
        String personSecondName = checker.removeStringBlanks(txtSecondName.getText()); 
        String personSecondLastName = checker.removeStringBlanks(txtSecondLastName.getText());
        
        
        if(!checker.checkStringField(personSecondName) && !personSecondName.equalsIgnoreCase("")){
            txtSecondName.setBackground(colorRed);
            return false;
        }
        if(!checker.checkStringField(personSecondLastName) && !personSecondLastName.equalsIgnoreCase("")){
            txtSecondLastName.setBackground(colorRed);
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
        setPreferredSize(new java.awt.Dimension(800, 500));

        btnCleanFields.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconDelete.png"))); // NOI18N
        btnCleanFields.setText("Limpiar campos");
        btnCleanFields.setPreferredSize(new java.awt.Dimension(180, 60));
        btnCleanFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanFieldsActionPerformed(evt);
            }
        });

        btnSaveWorker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconSave.png"))); // NOI18N
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
                .addGap(255, 255, 255)
                .addComponent(btnCleanFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSaveWorker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(238, 238, 238))
        );
        buttonsPanelLayout.setVerticalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCleanFields, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSaveWorker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        information1Panel.setPreferredSize(new java.awt.Dimension(350, 300));

        lbsInformation1Panel.setPreferredSize(new java.awt.Dimension(150, 300));

        lbFirstName.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbFirstName.setText("Primer nombre:");
        lbFirstName.setPreferredSize(new java.awt.Dimension(0, 25));

        lbFirstlastName.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbFirstlastName.setText("Primer apellido:");
        lbFirstlastName.setPreferredSize(new java.awt.Dimension(0, 25));

        lbIdentificationType.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbIdentificationType.setText("Tipo de identificación:");
        lbIdentificationType.setPreferredSize(new java.awt.Dimension(0, 25));

        lbBloodType.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbBloodType.setText("Tipo de sangre:");
        lbBloodType.setPreferredSize(new java.awt.Dimension(0, 25));

        lbAge.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbAge.setText("Fecha de nacimiento:");
        lbAge.setPreferredSize(new java.awt.Dimension(0, 25));

        lbPosition.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbPosition.setText("Cargo:");
        lbPosition.setPreferredSize(new java.awt.Dimension(0, 25));

        javax.swing.GroupLayout lbsInformation1PanelLayout = new javax.swing.GroupLayout(lbsInformation1Panel);
        lbsInformation1Panel.setLayout(lbsInformation1PanelLayout);
        lbsInformation1PanelLayout.setHorizontalGroup(
            lbsInformation1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbFirstlastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbIdentificationType, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addComponent(lbBloodType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbPosition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(lbBloodType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        dataInformation1Panel.setPreferredSize(new java.awt.Dimension(230, 300));

        txtFirstName.setPreferredSize(new java.awt.Dimension(75, 25));
        txtFirstName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFirstNameMouseClicked(evt);
            }
        });
        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });

        txtFirstLastName.setPreferredSize(new java.awt.Dimension(75, 25));
        txtFirstLastName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFirstLastNameMouseClicked(evt);
            }
        });
        txtFirstLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstLastNameActionPerformed(evt);
            }
        });

        sltIdentificationType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE UNA ...", "Cédula de ciudadanía", "Cédula de extranjería", "Tarjeta pasaporte", "Sin identificación" }));
        sltIdentificationType.setPreferredSize(new java.awt.Dimension(75, 25));
        sltIdentificationType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sltIdentificationTypeMouseClicked(evt);
            }
        });
        sltIdentificationType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sltIdentificationTypeActionPerformed(evt);
            }
        });

        sltPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE UNA ...", "Jefe", "Administrador", "Pintor", "Lijador", "Carpintero", "Seguridad", " " }));
        sltPosition.setPreferredSize(new java.awt.Dimension(75, 25));
        sltPosition.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sltPositionMouseClicked(evt);
            }
        });
        sltPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sltPositionActionPerformed(evt);
            }
        });

        sltBloodType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE UNA ...", "A", "B", "O", "AB" }));
        sltBloodType.setPreferredSize(new java.awt.Dimension(75, 25));
        sltBloodType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sltBloodTypeMouseClicked(evt);
            }
        });
        sltBloodType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sltBloodTypeActionPerformed(evt);
            }
        });

        sltBloodTypeCmplt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE UNA ...", "+", "-" }));
        sltBloodTypeCmplt.setPreferredSize(new java.awt.Dimension(75, 25));
        sltBloodTypeCmplt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sltBloodTypeCmpltMouseClicked(evt);
            }
        });
        sltBloodTypeCmplt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sltBloodTypeCmpltActionPerformed(evt);
            }
        });

        dateBirthdate.setDateFormatString("y/MM/d");
        dateBirthdate.setPreferredSize(new java.awt.Dimension(75, 25));
        dateBirthdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dateBirthdateMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout dataInformation1PanelLayout = new javax.swing.GroupLayout(dataInformation1Panel);
        dataInformation1Panel.setLayout(dataInformation1PanelLayout);
        dataInformation1PanelLayout.setHorizontalGroup(
            dataInformation1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataInformation1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataInformation1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sltIdentificationType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFirstLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sltPosition, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(dataInformation1PanelLayout.createSequentialGroup()
                        .addComponent(sltBloodType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sltBloodTypeCmplt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(dateBirthdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout information1PanelLayout = new javax.swing.GroupLayout(information1Panel);
        information1Panel.setLayout(information1PanelLayout);
        information1PanelLayout.setHorizontalGroup(
            information1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(information1PanelLayout.createSequentialGroup()
                .addComponent(lbsInformation1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataInformation1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
        );
        information1PanelLayout.setVerticalGroup(
            information1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbsInformation1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addComponent(dataInformation1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );

        information2Panel.setPreferredSize(new java.awt.Dimension(350, 300));

        lbsInformation2Panel.setPreferredSize(new java.awt.Dimension(150, 300));

        lbSecondName.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbSecondName.setText("Segundo nombre:");
        lbSecondName.setPreferredSize(new java.awt.Dimension(0, 25));

        lbSecondLastName.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbSecondLastName.setText("Segundo apellido:");
        lbSecondLastName.setPreferredSize(new java.awt.Dimension(0, 25));

        lbIdentificationNum.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbIdentificationNum.setText("Num. de identificación:");
        lbIdentificationNum.setPreferredSize(new java.awt.Dimension(0, 25));

        lbEps.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbEps.setText("Entidad de salud:");
        lbEps.setPreferredSize(new java.awt.Dimension(0, 25));

        lbDateVinculation.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbDateVinculation.setText("Fecha vinculación:");
        lbDateVinculation.setPreferredSize(new java.awt.Dimension(0, 25));

        javax.swing.GroupLayout lbsInformation2PanelLayout = new javax.swing.GroupLayout(lbsInformation2Panel);
        lbsInformation2Panel.setLayout(lbsInformation2PanelLayout);
        lbsInformation2PanelLayout.setHorizontalGroup(
            lbsInformation2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbDateVinculation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbEps, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbIdentificationNum, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addComponent(lbSecondName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbSecondLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        dataInformation2Panel.setPreferredSize(new java.awt.Dimension(230, 300));

        txtSecondName.setPreferredSize(new java.awt.Dimension(75, 25));
        txtSecondName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSecondNameMouseClicked(evt);
            }
        });
        txtSecondName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSecondNameActionPerformed(evt);
            }
        });

        txtSecondLastName.setPreferredSize(new java.awt.Dimension(75, 25));
        txtSecondLastName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSecondLastNameMouseClicked(evt);
            }
        });
        txtSecondLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSecondLastNameActionPerformed(evt);
            }
        });

        dateVinculation.setDateFormatString("y/MM/d");
        dateVinculation.setPreferredSize(new java.awt.Dimension(75, 25));
        dateVinculation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dateVinculationMouseClicked(evt);
            }
        });

        txtIdentificationNum.setPreferredSize(new java.awt.Dimension(75, 25));
        txtIdentificationNum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIdentificationNumMouseClicked(evt);
            }
        });
        txtIdentificationNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdentificationNumActionPerformed(evt);
            }
        });

        sltEPS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE UNA ...", "NO POSEE", "ALIANSALUD EPS", "ANAS WAYUU EPSI", "ASMET SALUD", "ASOCIACION INDIGENA DEL CAUCA EPSI", "CAJACOPI ATLANTICO", "CAPRESOCA", "CAPITAL SALUD EPS-S", "COMFACHOCO", "COMFAORIENTE", "COMFENALCO VALLE", "COMPENSAR EPS", "COOSALUD EPS-S", "DUSAKAWI EPSI", "EMS SANITAS", "EMSSANAR E.S.S.", "EPS FAMILIAR DE COLOMBIA", "EPS SANITAS", "EPS SURA", "FAMISANAR", "FONDO DE PASIVO SOCIAL DE FERROCARRILES NACIONALES DE COLOMBIA", "MALLAMAS EPSI", "MUTUAL SER", "NUEVA EPS", "PIJAOS SALUD EPSI", "SALUD BÓLIVAR EPS SAS", "SALUD MIA", "SALUD TOTAL EPS S.A.", "SAVIA SALUD EPS EPSS40", "SERVICIO OCCIDENTAL DE SALUD EPS SOS", "OTRO" }));
        sltEPS.setPreferredSize(new java.awt.Dimension(75, 25));
        sltEPS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sltEPSMouseClicked(evt);
            }
        });
        sltEPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sltEPSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dataInformation2PanelLayout = new javax.swing.GroupLayout(dataInformation2Panel);
        dataInformation2Panel.setLayout(dataInformation2PanelLayout);
        dataInformation2PanelLayout.setHorizontalGroup(
            dataInformation2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataInformation2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataInformation2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSecondName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSecondLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIdentificationNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateVinculation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sltEPS, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout information2PanelLayout = new javax.swing.GroupLayout(information2Panel);
        information2Panel.setLayout(information2PanelLayout);
        information2PanelLayout.setHorizontalGroup(
            information2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(information2PanelLayout.createSequentialGroup()
                .addComponent(lbsInformation2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataInformation2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
        );
        information2PanelLayout.setVerticalGroup(
            information2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbsInformation2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addComponent(dataInformation2Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(information1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(information2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(information1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(information2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtFirstLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstLastNameActionPerformed

    private void txtSecondLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSecondLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSecondLastNameActionPerformed

    private void txtIdentificationNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdentificationNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdentificationNumActionPerformed

    private void btnCleanFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanFieldsActionPerformed
        // TODO add your handling code here:
        clearFields();
    }//GEN-LAST:event_btnCleanFieldsActionPerformed

    private void btnSaveWorkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveWorkerActionPerformed
            
            
            //Person information
            String personFirstName = checker.removeStringBlanks(txtFirstName.getText()); 
            String personSecondName = checker.removeStringBlanks(txtSecondName.getText());//
            String personFirstLastName = checker.removeStringBlanks(txtFirstLastName.getText());
            String personSecondLastName = checker.removeStringBlanks(txtSecondLastName.getText());//
            String personIdentificationType = sltIdentificationType.getSelectedItem().toString();
            String personIdentificationNumber = checker.removeStringBlanks(txtIdentificationNum.getText());
            Date personBirthdate = dateBirthdate.getDate();
            //Worker information
            String bloodType = sltBloodType.getSelectedItem().toString();
            String bloodTypeCmplt = sltBloodTypeCmplt.getSelectedItem().toString();
            String healthEntity = sltEPS.getSelectedItem().toString();
            Date dayLink = dateVinculation.getDate();
            String position = sltPosition.getSelectedItem().toString();
            
            
            
            if(changeColorRequiredField() && changeColorNoRequiredField()){
                try {
                    newRequestPerson.savePerson(personFirstName, personSecondName, personFirstLastName, personSecondLastName, personIdentificationType, personIdentificationNumber, personBirthdate);
                    newRequestWorker.saveWorker(personIdentificationNumber, bloodType, bloodTypeCmplt, healthEntity, dayLink, position);
                    personalizedMessage("Information", "El trabajador ha sido agregado correctamente", "Operación exitosa");
                    clearFields();
                    
                } catch (PreexistingEntityException ex) {
                    personalizedMessage("Error", "El numero de identificación ya está asociado a alguien.", "Identificación duplicada");
                    txtIdentificationNum.setBackground(colorRed);
                }  catch (Exception ex) {
                    Logger.getLogger(AddWorkerView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                personalizedMessage("Warning", "Asegurese de que los campos en rojo estén correctamente diligenciados", "Error en Campos");
            }
            
            
    }//GEN-LAST:event_btnSaveWorkerActionPerformed

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameActionPerformed

    private void sltPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sltPositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sltPositionActionPerformed

    private void sltEPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sltEPSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sltEPSActionPerformed

    private void sltBloodTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sltBloodTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sltBloodTypeActionPerformed

    private void sltBloodTypeCmpltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sltBloodTypeCmpltActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sltBloodTypeCmpltActionPerformed

    private void sltIdentificationTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sltIdentificationTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sltIdentificationTypeActionPerformed

    private void txtSecondNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSecondNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSecondNameActionPerformed

    private void txtFirstNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFirstNameMouseClicked
        // TODO add your handling code here:
        txtFirstName.setBackground(colorWhite);
    }//GEN-LAST:event_txtFirstNameMouseClicked

    private void txtSecondNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSecondNameMouseClicked
        // TODO add your handling code here:
        txtSecondName.setBackground(colorWhite);
    }//GEN-LAST:event_txtSecondNameMouseClicked

    private void txtFirstLastNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFirstLastNameMouseClicked
        // TODO add your handling code here:
        txtFirstLastName.setBackground(colorWhite);
    }//GEN-LAST:event_txtFirstLastNameMouseClicked

    private void txtSecondLastNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSecondLastNameMouseClicked
        // TODO add your handling code here:
        txtSecondLastName.setBackground(colorWhite);
    }//GEN-LAST:event_txtSecondLastNameMouseClicked

    private void sltIdentificationTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sltIdentificationTypeMouseClicked
        // TODO add your handling code here:
        sltIdentificationType.setBackground(colorWhite);
    }//GEN-LAST:event_sltIdentificationTypeMouseClicked

    private void txtIdentificationNumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdentificationNumMouseClicked
        // TODO add your handling code here:
        txtIdentificationNum.setBackground(colorWhite);
    }//GEN-LAST:event_txtIdentificationNumMouseClicked

    private void sltBloodTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sltBloodTypeMouseClicked
        // TODO add your handling code here:
        sltBloodType.setBackground(colorWhite);
    }//GEN-LAST:event_sltBloodTypeMouseClicked

    private void sltBloodTypeCmpltMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sltBloodTypeCmpltMouseClicked
        // TODO add your handling code here:
        sltBloodTypeCmplt.setBackground(colorWhite);
    }//GEN-LAST:event_sltBloodTypeCmpltMouseClicked

    private void sltEPSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sltEPSMouseClicked
        // TODO add your handling code here:
        sltEPS.setBackground(colorWhite);
    }//GEN-LAST:event_sltEPSMouseClicked

    private void dateVinculationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateVinculationMouseClicked
        // TODO add your handling code here:
        dateVinculation.setBackground(colorWhite);
    }//GEN-LAST:event_dateVinculationMouseClicked

    private void sltPositionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sltPositionMouseClicked
        // TODO add your handling code here:
        sltPosition.setBackground(colorWhite);
    }//GEN-LAST:event_sltPositionMouseClicked

    private void dateBirthdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateBirthdateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dateBirthdateMouseClicked


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
