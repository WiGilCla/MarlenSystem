/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.marlenproject.userinterface.panelViews.workersSection;

import com.mycompany.marlenproject.logic.CheckFields;
import com.mycompany.marlenproject.logic.Worker;
import com.mycompany.marlenproject.logic.request.requestPerson;
import com.mycompany.marlenproject.logic.request.requestWorker;
import com.mycompany.marlenproject.persistence.exceptions.NonexistentEntityException;
import com.mycompany.marlenproject.persistence.exceptions.PreexistingEntityException;
import com.mycompany.marlenproject.userinterface.AdminHome;
import java.awt.Color;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class WorkerEditInformationView extends javax.swing.JFrame {
    private final ComboBoxWorkerOptions comboBoxOptions = new ComboBoxWorkerOptions();
    private Worker worker;
    private final requestPerson newRequestPerson = new requestPerson();
    private final requestWorker newRequestWorker = new requestWorker();
    private final CheckFields checker = new CheckFields();
    private final Color colorRed = new Color(255,0,0);
    private final Color colorWhite = new Color(255,255,255);
    private final AdminHome principalJFrame; 

    private void setActualInformation(){
        String bloodGroup = (worker.getBloodType().length() == 3)? 
                worker.getBloodType().substring(0,2):worker.getBloodType().substring(0, 1);
        
        String bloodGroupRhd = (worker.getBloodType().length() == 3)? 
                worker.getBloodType().substring(2):worker.getBloodType().substring(1);
        
        
        txtFirstName.setText(worker.getPerson().getFirstName());
        
        txtSecondName.setText(worker.getPerson().getSecondName());
        
        txtFirstLastName.setText(worker.getPerson().getFirstLastName());
        
        txtSecondLastName.setText(worker.getPerson().getSecondLastName());
        
        sltIdentificationType.setSelectedIndex(comboBoxOptions
                .findIndexSelected(comboBoxOptions.getIdentificationTypeOptions(), worker.getPerson().getIdentificationType()));
        
        txtIdentificationNumber.setText(worker.getPerson().getIdentificationNumber());
        
        sltBloodType.setSelectedIndex(comboBoxOptions
                .findIndexSelected(comboBoxOptions.getBloodGroupOptions(), bloodGroup));
        
        sltBloodTypeCmpl.setSelectedIndex(comboBoxOptions.
                findIndexSelected(comboBoxOptions.getBloodGroupRhdOptions(), bloodGroupRhd));
        
        sltHealthEntity.setSelectedIndex(comboBoxOptions
                .findIndexSelected(comboBoxOptions.getHealthEntityOptions(), worker.getHealthEntity()));
        
        dateBirthdate.setDate(worker.getPerson().getBirthdate());
        
        dateDayLink.setDate(worker.getDayLink());
        
        sltPosition.setSelectedIndex(comboBoxOptions
                .findIndexSelected(comboBoxOptions.getPositionOptions(), worker.getPosition()));
        
        sltState.setSelectedIndex(worker.isIsActive()? 1:0);
    }
    
    private boolean changeColorRequiredField(){
        String personFirstName = checker.removeStringBlanks(txtFirstName.getText());
        String personFirstLastName = checker.removeStringBlanks(txtFirstLastName.getText());
        String personIdentificationType = sltIdentificationType.getSelectedItem().toString();
        String personIdentificationNumber = checker.removeStringBlanks(txtIdentificationNumber.getText());
        String bloodType = sltBloodType.getSelectedItem().toString();
        String bloodTypeCmplt = sltBloodTypeCmpl.getSelectedItem().toString();
        String healthEntity = sltHealthEntity.getSelectedItem().toString();
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
            txtIdentificationNumber.setBackground(colorRed);
            return false;
        }
        
        if(!checker.checkComboBox(bloodType)){
            sltBloodType.setBackground(colorRed);
            return false;
        }
        
        if(!checker.checkComboBox(bloodTypeCmplt)){
            sltBloodTypeCmpl.setBackground(colorRed);
            return false;
        }
        
        if(!checker.checkComboBox(healthEntity)){
            sltHealthEntity.setBackground(colorRed);
            return false;
        }
        
        if(null == dateBirthdate.getDate()){
            dateBirthdate.setBackground(colorRed);
            return false;
        }
        
        if(null == dateDayLink.getDate()){
            dateDayLink.setBackground(colorRed);
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
    
    private void personalizedMessage(String type, String message, String title){
        int typeMessage = 0;
        typeMessage = switch (type) {
            case "Error" -> 0;
            case "Information" -> 1;
            case "Warning" -> 2;
            case "Question" -> 3;
            default -> 1;
        };
        JOptionPane.showMessageDialog(this.principalJFrame, message,title,typeMessage);
    }
    
    private void clearFields(){
        txtFirstName.setText("");
        txtSecondName.setText("");
        txtFirstLastName.setText("");
        txtSecondLastName.setText("");
        sltIdentificationType.setSelectedIndex(0);
        txtIdentificationNumber.setText("");
        sltBloodType.setSelectedIndex(0);
        sltBloodTypeCmpl.setSelectedIndex(0);
        sltHealthEntity.setSelectedIndex(0);
        dateBirthdate.setDate(null);
        dateDayLink.setDate(null);
        sltPosition.setSelectedIndex(0);
        sltState.setSelectedIndex(worker.isIsActive()? 1:0);
    }
    
    private int findWorkerByDni(String dni, List<Worker> list){
        for(int i = 0; i < list.size();i++){
            if(list.get(i).getPerson().getIdentificationNumber().equals(dni)){
                return i;
            }
        }
        return 0;
    }
    
    public WorkerEditInformationView(Worker worker, AdminHome principalJFrame) {
        this.principalJFrame = principalJFrame;
        this.worker = worker;
        initComponents();
        setActualInformation();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        defaultPanel = new javax.swing.JPanel();
        information1Panel = new javax.swing.JPanel();
        labelsPanel1 = new javax.swing.JPanel();
        lbFirstName = new javax.swing.JLabel();
        lbFirstLastName = new javax.swing.JLabel();
        lbIdentificationType = new javax.swing.JLabel();
        lbBloodType = new javax.swing.JLabel();
        lbBirthdate = new javax.swing.JLabel();
        lbPosition = new javax.swing.JLabel();
        fields1Panel = new javax.swing.JPanel();
        txtFirstName = new javax.swing.JTextField();
        txtFirstLastName = new javax.swing.JTextField();
        sltIdentificationType = new javax.swing.JComboBox<>();
        sltBloodType = new javax.swing.JComboBox<>();
        sltBloodTypeCmpl = new javax.swing.JComboBox<>();
        dateBirthdate = new com.toedter.calendar.JDateChooser();
        sltPosition = new javax.swing.JComboBox<>();
        information2Panel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbSecondName = new javax.swing.JLabel();
        lbSecondLastName = new javax.swing.JLabel();
        lbIdentificationNumber = new javax.swing.JLabel();
        lbHealthEntity = new javax.swing.JLabel();
        lbDayLink = new javax.swing.JLabel();
        lbState = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        dateDayLink = new com.toedter.calendar.JDateChooser();
        sltHealthEntity = new javax.swing.JComboBox<>();
        txtIdentificationNumber = new javax.swing.JTextField();
        txtSecondLastName = new javax.swing.JTextField();
        txtSecondName = new javax.swing.JTextField();
        sltState = new javax.swing.JComboBox<>();
        buttonsPanel = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 468));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 400));

        defaultPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EDITAR INFORMACIÓN DE TRABAJADOR", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        defaultPanel.setPreferredSize(new java.awt.Dimension(800, 400));

        information1Panel.setPreferredSize(new java.awt.Dimension(391, 282));
        information1Panel.setVerifyInputWhenFocusTarget(false);

        labelsPanel1.setPreferredSize(new java.awt.Dimension(150, 338));

        lbFirstName.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbFirstName.setText("Primer nombre:");
        lbFirstName.setPreferredSize(new java.awt.Dimension(138, 25));

        lbFirstLastName.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbFirstLastName.setText("Primer apellido:");
        lbFirstLastName.setPreferredSize(new java.awt.Dimension(138, 25));

        lbIdentificationType.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbIdentificationType.setText("Tipo de identificación:");
        lbIdentificationType.setPreferredSize(new java.awt.Dimension(138, 25));

        lbBloodType.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbBloodType.setText("Tipo de sangre:");
        lbBloodType.setPreferredSize(new java.awt.Dimension(138, 25));

        lbBirthdate.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbBirthdate.setText("Fecha de nacimiento:");
        lbBirthdate.setPreferredSize(new java.awt.Dimension(138, 25));

        lbPosition.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbPosition.setText("Cargo:");
        lbPosition.setPreferredSize(new java.awt.Dimension(138, 25));

        javax.swing.GroupLayout labelsPanel1Layout = new javax.swing.GroupLayout(labelsPanel1);
        labelsPanel1.setLayout(labelsPanel1Layout);
        labelsPanel1Layout.setHorizontalGroup(
            labelsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, labelsPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(labelsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbIdentificationType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbBloodType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbBirthdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPosition, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbFirstLastName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        labelsPanel1Layout.setVerticalGroup(
            labelsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(labelsPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbFirstLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbIdentificationType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbBloodType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fields1Panel.setPreferredSize(new java.awt.Dimension(223, 338));

        txtFirstName.setPreferredSize(new java.awt.Dimension(211, 25));
        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });

        txtFirstLastName.setPreferredSize(new java.awt.Dimension(211, 25));
        txtFirstLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstLastNameActionPerformed(evt);
            }
        });

        sltIdentificationType.setModel(new javax.swing.DefaultComboBoxModel<>(comboBoxOptions.getIdentificationTypeOptions()));
        sltIdentificationType.setPreferredSize(new java.awt.Dimension(211, 25));
        sltIdentificationType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sltIdentificationTypeActionPerformed(evt);
            }
        });

        sltBloodType.setModel(new javax.swing.DefaultComboBoxModel<>(comboBoxOptions.getBloodGroupOptions()));
        sltBloodType.setPreferredSize(new java.awt.Dimension(102, 25));
        sltBloodType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sltBloodTypeActionPerformed(evt);
            }
        });

        sltBloodTypeCmpl.setModel(new javax.swing.DefaultComboBoxModel<>(comboBoxOptions.getBloodGroupRhdOptions()));
        sltBloodTypeCmpl.setPreferredSize(new java.awt.Dimension(102, 25));
        sltBloodTypeCmpl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sltBloodTypeCmplActionPerformed(evt);
            }
        });

        dateBirthdate.setMaxSelectableDate(new Date());
        dateBirthdate.setPreferredSize(new java.awt.Dimension(211, 25));

        sltPosition.setModel(new javax.swing.DefaultComboBoxModel<>(comboBoxOptions.getPositionOptions()));
        sltPosition.setPreferredSize(new java.awt.Dimension(211, 25));
        sltPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sltPositionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fields1PanelLayout = new javax.swing.GroupLayout(fields1Panel);
        fields1Panel.setLayout(fields1PanelLayout);
        fields1PanelLayout.setHorizontalGroup(
            fields1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fields1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fields1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateBirthdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sltPosition, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(fields1PanelLayout.createSequentialGroup()
                        .addComponent(sltBloodType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sltBloodTypeCmpl, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(sltIdentificationType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFirstLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        fields1PanelLayout.setVerticalGroup(
            fields1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fields1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFirstLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sltIdentificationType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fields1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sltBloodType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sltBloodTypeCmpl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sltPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout information1PanelLayout = new javax.swing.GroupLayout(information1Panel);
        information1Panel.setLayout(information1PanelLayout);
        information1PanelLayout.setHorizontalGroup(
            information1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(information1PanelLayout.createSequentialGroup()
                .addComponent(labelsPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fields1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
        );
        information1PanelLayout.setVerticalGroup(
            information1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelsPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
            .addComponent(fields1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
        );

        information2Panel.setPreferredSize(new java.awt.Dimension(391, 282));
        information2Panel.setVerifyInputWhenFocusTarget(false);

        jPanel2.setPreferredSize(new java.awt.Dimension(150, 338));

        lbSecondName.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbSecondName.setText("Segundo nombre:");
        lbSecondName.setPreferredSize(new java.awt.Dimension(138, 25));

        lbSecondLastName.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbSecondLastName.setText("Segundo apellido:");
        lbSecondLastName.setPreferredSize(new java.awt.Dimension(138, 25));

        lbIdentificationNumber.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbIdentificationNumber.setText("Numero de identificación:");
        lbIdentificationNumber.setPreferredSize(new java.awt.Dimension(138, 25));

        lbHealthEntity.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbHealthEntity.setText("Entidad de salud:");
        lbHealthEntity.setPreferredSize(new java.awt.Dimension(138, 25));

        lbDayLink.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbDayLink.setText("Fecha vinculación:");
        lbDayLink.setPreferredSize(new java.awt.Dimension(138, 25));

        lbState.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbState.setText("Estado de trabajador:");
        lbState.setPreferredSize(new java.awt.Dimension(138, 25));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSecondLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbIdentificationNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbHealthEntity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbDayLink, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSecondName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbState, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbSecondName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbSecondLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbIdentificationNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbHealthEntity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbDayLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(223, 338));

        dateDayLink.setPreferredSize(new java.awt.Dimension(211, 25));

        sltHealthEntity.setModel(new javax.swing.DefaultComboBoxModel<>(comboBoxOptions.getHealthEntityOptions()));
        sltHealthEntity.setPreferredSize(new java.awt.Dimension(211, 25));
        sltHealthEntity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sltHealthEntityActionPerformed(evt);
            }
        });

        txtIdentificationNumber.setPreferredSize(new java.awt.Dimension(211, 25));
        txtIdentificationNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdentificationNumberActionPerformed(evt);
            }
        });

        txtSecondLastName.setPreferredSize(new java.awt.Dimension(211, 25));
        txtSecondLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSecondLastNameActionPerformed(evt);
            }
        });

        txtSecondName.setPreferredSize(new java.awt.Dimension(211, 25));
        txtSecondName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSecondNameActionPerformed(evt);
            }
        });

        sltState.setModel(new javax.swing.DefaultComboBoxModel<>(comboBoxOptions.getStateOptions()));
        sltState.setPreferredSize(new java.awt.Dimension(211, 25));
        sltState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sltStateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sltHealthEntity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIdentificationNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSecondLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSecondName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateDayLink, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sltState, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSecondName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSecondLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIdentificationNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sltHealthEntity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateDayLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sltState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout information2PanelLayout = new javax.swing.GroupLayout(information2Panel);
        information2Panel.setLayout(information2PanelLayout);
        information2PanelLayout.setHorizontalGroup(
            information2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(information2PanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        information2PanelLayout.setVerticalGroup(
            information2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
        );

        buttonsPanel.setPreferredSize(new java.awt.Dimension(788, 100));

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconCancel.png"))); // NOI18N
        btnCancel.setText("Cancelar");
        btnCancel.setPreferredSize(new java.awt.Dimension(180, 60));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnClean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconDelete.png"))); // NOI18N
        btnClean.setText("Limpiar campos");
        btnClean.setPreferredSize(new java.awt.Dimension(180, 60));
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconSave.png"))); // NOI18N
        btnSave.setText("Guardar");
        btnSave.setPreferredSize(new java.awt.Dimension(180, 60));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonsPanelLayout = new javax.swing.GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(buttonsPanelLayout);
        buttonsPanelLayout.setHorizontalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(45, 45, 45)
                .addComponent(btnClean, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(35, 35, 35)
                .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(78, 78, 78))
        );
        buttonsPanelLayout.setVerticalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout defaultPanelLayout = new javax.swing.GroupLayout(defaultPanel);
        defaultPanel.setLayout(defaultPanelLayout);
        defaultPanelLayout.setHorizontalGroup(
            defaultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(defaultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
                    .addGroup(defaultPanelLayout.createSequentialGroup()
                        .addComponent(information1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(information2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)))
                .addContainerGap())
        );
        defaultPanelLayout.setVerticalGroup(
            defaultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultPanelLayout.createSequentialGroup()
                .addGroup(defaultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(information1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(information2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(defaultPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(defaultPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
        txtFirstName.setBackground(colorWhite);
    }//GEN-LAST:event_txtFirstNameActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
        String personFirstName = checker.removeStringBlanks(txtFirstName.getText()); 
        String personSecondName = checker.removeStringBlanks(txtSecondName.getText());//
        String personFirstLastName = checker.removeStringBlanks(txtFirstLastName.getText());
        String personSecondLastName = checker.removeStringBlanks(txtSecondLastName.getText());//
        String personIdentificationType = sltIdentificationType.getSelectedItem().toString();
        String personIdentificationNumber = checker.removeStringBlanks(txtIdentificationNumber.getText());
        Date personBirthdate = dateBirthdate.getDate();
        String bloodType = sltBloodType.getSelectedItem().toString();
        String bloodTypeCmplt = sltBloodTypeCmpl.getSelectedItem().toString();
        String healthEntity = sltHealthEntity.getSelectedItem().toString();
        Date dayLink = dateDayLink.getDate();
        String position = sltPosition.getSelectedItem().toString();
        boolean state = (sltState.getSelectedIndex() != 0);


        if(changeColorRequiredField() && changeColorNoRequiredField()){
            try {
                if(worker.getPerson().getIdentificationNumber().equals(personIdentificationNumber)){
                    newRequestPerson.editPerson(personIdentificationNumber,personFirstName, personSecondName, 
                            personFirstLastName, personSecondLastName, personIdentificationType, personBirthdate);
                    newRequestWorker.editWorker(worker.getWorkerId(),personIdentificationNumber, 
                            bloodType, bloodTypeCmplt, healthEntity, 
                            dayLink, position, state, false);
                }else{
                    
                    Worker existingWorker = newRequestWorker.findWorkerByDNI(personIdentificationNumber);
                    if (existingWorker != null) {
                        personalizedMessage("Error", 
                                "Esta identificación ya está asociada a un trabajador, ve y corrigelo para intentarlo nuevamente", 
                                "Registro ya existente");
                        txtIdentificationNumber.setBackground(colorRed);
                        return;
                    }else{
                        newRequestPerson.savePerson(personFirstName, personSecondName, personFirstLastName, 
                                personSecondLastName, personIdentificationType, personIdentificationNumber, personBirthdate);
                        newRequestWorker.editWorker(worker.getWorkerId(),personIdentificationNumber, 
                                bloodType, bloodTypeCmplt, healthEntity, dayLink, position, state, false);
                        newRequestPerson.deletePerson(worker.getPerson().getIdentificationNumber());
                    }
                }
                
                personalizedMessage("Information", "La información ha sido cambiada correctamente", "Operación exitosa");
            } catch (PreexistingEntityException ex) {
                
                personalizedMessage("Error", "El numero de identificación ya está asociado a alguien.", "Identificación duplicada");
                txtIdentificationNumber.setBackground(colorRed);
                
            }catch (NonexistentEntityException ex){
                
                personalizedMessage("Error", "El numero de identificación no existe", "Identificación no existente");
                txtIdentificationNumber.setBackground(colorRed);
                
            }
            catch (Exception ex) {
                Logger.getLogger(AddWorkerView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            personalizedMessage("Warning", "Asegurese de que los campos en rojo estén correctamente diligenciados", "Error en Campos");
            return;
        }
        
        this.dispose();
        List<Worker> newListworkers = new requestWorker().getNoDeletedWorker();
        
        if(!newListworkers.isEmpty()){
            
            int index = findWorkerByDni(personIdentificationNumber, newListworkers);
            WorkersInformationView workersInformationView = new WorkersInformationView(this.principalJFrame,newListworkers, index);
            workersInformationView.setSize(800, 500);
            workersInformationView.setLocation(0, 0);
            principalJFrame.replacePanel(workersInformationView);
            principalJFrame.setVisible(true);
            
        }else{
            
            WorkersFirstView workersFirstView = new WorkersFirstView(principalJFrame);
            workersFirstView.setSize(982, 588);
            workersFirstView.setLocation(0, 0);
            principalJFrame.replacePanel(workersFirstView);
            principalJFrame.setVisible(true);
        }
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        clearFields();
    }//GEN-LAST:event_btnCleanActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
        this.principalJFrame.setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtFirstLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstLastNameActionPerformed
        // TODO add your handling code here:
        txtFirstLastName.setBackground(colorWhite);
    }//GEN-LAST:event_txtFirstLastNameActionPerformed

    private void sltIdentificationTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sltIdentificationTypeActionPerformed
        // TODO add your handling code here:
        sltIdentificationType.setBackground(colorWhite);
    }//GEN-LAST:event_sltIdentificationTypeActionPerformed

    private void sltBloodTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sltBloodTypeActionPerformed
        // TODO add your handling code here:
        sltBloodType.setBackground(colorWhite);
    }//GEN-LAST:event_sltBloodTypeActionPerformed

    private void sltBloodTypeCmplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sltBloodTypeCmplActionPerformed
        // TODO add your handling code here:
        sltBloodTypeCmpl.setBackground(colorWhite);
    }//GEN-LAST:event_sltBloodTypeCmplActionPerformed

    private void sltPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sltPositionActionPerformed
        // TODO add your handling code here:
        sltPosition.setBackground(colorWhite);
    }//GEN-LAST:event_sltPositionActionPerformed

    private void txtSecondNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSecondNameActionPerformed
        // TODO add your handling code here:
        txtSecondName.setBackground(colorWhite);
    }//GEN-LAST:event_txtSecondNameActionPerformed

    private void txtSecondLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSecondLastNameActionPerformed
        // TODO add your handling code here:
        txtSecondLastName.setBackground(colorWhite);
    }//GEN-LAST:event_txtSecondLastNameActionPerformed

    private void txtIdentificationNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdentificationNumberActionPerformed
        // TODO add your handling code here:
        txtIdentificationNumber.setBackground(colorWhite);
    }//GEN-LAST:event_txtIdentificationNumberActionPerformed

    private void sltHealthEntityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sltHealthEntityActionPerformed
        // TODO add your handling code here:
        sltHealthEntity.setBackground(colorWhite);
    }//GEN-LAST:event_sltHealthEntityActionPerformed

    private void sltStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sltStateActionPerformed
        // TODO add your handling code here:
        sltState.setBackground(colorWhite);
    }//GEN-LAST:event_sltStateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel buttonsPanel;
    private com.toedter.calendar.JDateChooser dateBirthdate;
    private com.toedter.calendar.JDateChooser dateDayLink;
    private javax.swing.JPanel defaultPanel;
    private javax.swing.JPanel fields1Panel;
    private javax.swing.JPanel information1Panel;
    private javax.swing.JPanel information2Panel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel labelsPanel1;
    private javax.swing.JLabel lbBirthdate;
    private javax.swing.JLabel lbBloodType;
    private javax.swing.JLabel lbDayLink;
    private javax.swing.JLabel lbFirstLastName;
    private javax.swing.JLabel lbFirstName;
    private javax.swing.JLabel lbHealthEntity;
    private javax.swing.JLabel lbIdentificationNumber;
    private javax.swing.JLabel lbIdentificationType;
    private javax.swing.JLabel lbPosition;
    private javax.swing.JLabel lbSecondLastName;
    private javax.swing.JLabel lbSecondName;
    private javax.swing.JLabel lbState;
    private javax.swing.JComboBox<String> sltBloodType;
    private javax.swing.JComboBox<String> sltBloodTypeCmpl;
    private javax.swing.JComboBox<String> sltHealthEntity;
    private javax.swing.JComboBox<String> sltIdentificationType;
    private javax.swing.JComboBox<String> sltPosition;
    private javax.swing.JComboBox<String> sltState;
    private javax.swing.JTextField txtFirstLastName;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtIdentificationNumber;
    private javax.swing.JTextField txtSecondLastName;
    private javax.swing.JTextField txtSecondName;
    // End of variables declaration//GEN-END:variables
}
