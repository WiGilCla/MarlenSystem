/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.marlenproject.userinterface.panelViews.customerSection;

import com.mycompany.marlenproject.logic.CheckFields;
import com.mycompany.marlenproject.logic.Customer;
import com.mycompany.marlenproject.logic.Person;
import com.mycompany.marlenproject.logic.request.RequestCustomer;
import com.mycompany.marlenproject.logic.request.requestPerson;
import com.mycompany.marlenproject.persistence.exceptions.PreexistingEntityException;
import java.awt.Color;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AddCustomerView extends javax.swing.JPanel {

    private final requestPerson NEW_REQUEST_PERSON = new requestPerson();
    private final RequestCustomer NEW_REQUEST_CUSTOMER = new RequestCustomer();
    private final CheckFields CHECKER = new CheckFields();
    private final Color COLOR_RED = new Color(255, 0, 0);
    private final Color COLOR_WHITE = new Color(255, 255, 255);

    public AddCustomerView() {
        initComponents();
    }

    private void personalizedMessage(String type, String message, String title) {
        int typeMessage = 0;
        typeMessage = switch (type) {
            case "Error" ->
                0;
            case "Information" ->
                1;
            case "Warning" ->
                2;
            case "Question" ->
                3;
            default ->
                1;
        };
        JOptionPane.showMessageDialog(this, message, title, typeMessage);
    }

    private boolean changeColorRequiredField() {
        String personFirstName = CHECKER.removeStringBlanks(txtFirstName.getText());
        String personFirstLastName = CHECKER.removeStringBlanks(txtFirstLastName.getText());
        String personIdentificationType = sltIdentificationType.getSelectedItem().toString();
        String personIdentificationNumber = CHECKER.removeStringBlanks(txtIdentificationNum.getText());

        if (!CHECKER.checkStringField(personFirstName)) {
            txtFirstName.setBackground(COLOR_RED);
            return false;
        }
        if (!CHECKER.checkStringField(personFirstLastName)) {
            txtFirstLastName.setBackground(COLOR_RED);
            return false;
        }
        if (!CHECKER.checkComboBox(personIdentificationType)) {
            sltIdentificationType.setBackground(COLOR_RED);
            return false;
        }
        if (!CHECKER.checkNumberField(personIdentificationNumber)
                || !(personIdentificationNumber.length() <= 10
                && personIdentificationNumber.length() >= 8)) {
            txtIdentificationNum.setBackground(COLOR_RED);
            return false;
        }
        return true;
    }

    private boolean changeColorNoRequiredField() {
        String personSecondName = CHECKER.removeStringBlanks(txtSecondName.getText());
        String personSecondLastName = CHECKER.removeStringBlanks(txtSecondLastName.getText());
        String personEmail = txtEmail.getText();
        String personPhone = txtPhoneNumber.getText();
        String personAddress = txtAddress.getText();

        if (!CHECKER.checkStringField(personSecondName) && !personSecondName.equalsIgnoreCase("")) {
            txtSecondName.setBackground(COLOR_RED);
            return false;
        }

        if (!CHECKER.checkStringField(personSecondLastName) && !personSecondLastName.equalsIgnoreCase("")) {
            txtSecondLastName.setBackground(COLOR_RED);
            return false;
        }

        if (!CHECKER.checkEmail(personEmail) && !personEmail.equalsIgnoreCase("")) {
            txtEmail.setBackground(COLOR_RED);
            return false;
        }

        if (!CHECKER.checkNumberField(personPhone) && !personPhone.equalsIgnoreCase("")) {
            txtPhoneNumber.setBackground(COLOR_RED);
            return false;
        }

        return true;
    }

    private void clearFields() {
        txtFirstName.setText("");
        txtSecondName.setText("");
        txtFirstLastName.setText("");
        txtSecondLastName.setText("");
        sltIdentificationType.setSelectedIndex(0);
        txtIdentificationNum.setText("");
        dateBirthdate.setDate(null);
        txtEmail.setText("");
        txtAddress.setText("");
        txtPhoneNumber.setText("");
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
        lbEmail = new javax.swing.JLabel();
        lbAge = new javax.swing.JLabel();
        dataInformation1Panel = new javax.swing.JPanel();
        txtFirstName = new javax.swing.JTextField();
        txtFirstLastName = new javax.swing.JTextField();
        sltIdentificationType = new javax.swing.JComboBox<>();
        dateBirthdate = new com.toedter.calendar.JDateChooser();
        txtEmail = new javax.swing.JTextField();
        information2Panel = new javax.swing.JPanel();
        lbsInformation2Panel = new javax.swing.JPanel();
        lbSecondName = new javax.swing.JLabel();
        lbSecondLastName = new javax.swing.JLabel();
        lbIdentificationNum = new javax.swing.JLabel();
        lbEps = new javax.swing.JLabel();
        Dirección = new javax.swing.JLabel();
        dataInformation2Panel = new javax.swing.JPanel();
        txtSecondName = new javax.swing.JTextField();
        txtSecondLastName = new javax.swing.JTextField();
        txtIdentificationNum = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "AGREGAR NUEVO CLIENTE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
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

        lbEmail.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbEmail.setText("Correo electrónico:");
        lbEmail.setPreferredSize(new java.awt.Dimension(138, 25));

        lbAge.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbAge.setText("Fecha de nacimiento:");
        lbAge.setPreferredSize(new java.awt.Dimension(138, 25));

        javax.swing.GroupLayout lbsInformation1PanelLayout = new javax.swing.GroupLayout(lbsInformation1Panel);
        lbsInformation1Panel.setLayout(lbsInformation1PanelLayout);
        lbsInformation1PanelLayout.setHorizontalGroup(
            lbsInformation1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbsInformation1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lbsInformation1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAge, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbIdentificationType, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbFirstlastName, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbFirstName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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
                .addComponent(lbAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        dateBirthdate.setDateFormatString("dd/MM/yyyy");
        dateBirthdate.setMaxSelectableDate(new Date());
        dateBirthdate.setPreferredSize(new java.awt.Dimension(296, 25));

        txtEmail.setPreferredSize(new java.awt.Dimension(71, 25));

        javax.swing.GroupLayout dataInformation1PanelLayout = new javax.swing.GroupLayout(dataInformation1Panel);
        dataInformation1Panel.setLayout(dataInformation1PanelLayout);
        dataInformation1PanelLayout.setHorizontalGroup(
            dataInformation1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataInformation1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataInformation1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sltIdentificationType, 0, 293, Short.MAX_VALUE)
                    .addComponent(txtFirstLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(dateBirthdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        dataInformation1PanelLayout.setVerticalGroup(
            dataInformation1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataInformation1PanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFirstLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sltIdentificationType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
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
        lbEps.setText("Teléfono / Celular:");
        lbEps.setPreferredSize(new java.awt.Dimension(138, 25));

        Dirección.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        Dirección.setText("Dirección:");
        Dirección.setPreferredSize(new java.awt.Dimension(138, 25));

        javax.swing.GroupLayout lbsInformation2PanelLayout = new javax.swing.GroupLayout(lbsInformation2Panel);
        lbsInformation2Panel.setLayout(lbsInformation2PanelLayout);
        lbsInformation2PanelLayout.setHorizontalGroup(
            lbsInformation2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbsInformation2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lbsInformation2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Dirección, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
                .addComponent(Dirección, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        txtIdentificationNum.setPreferredSize(new java.awt.Dimension(296, 25));
        txtIdentificationNum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIdentificationNumMouseClicked(evt);
            }
        });

        txtPhoneNumber.setPreferredSize(new java.awt.Dimension(71, 25));

        txtAddress.setPreferredSize(new java.awt.Dimension(71, 25));

        javax.swing.GroupLayout dataInformation2PanelLayout = new javax.swing.GroupLayout(dataInformation2Panel);
        dataInformation2Panel.setLayout(dataInformation2PanelLayout);
        dataInformation2PanelLayout.setHorizontalGroup(
            dataInformation2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataInformation2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataInformation2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSecondName, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                    .addComponent(txtSecondLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtIdentificationNum, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        Date personBirthdate = (dateBirthdate.getDate() != null) ? dateBirthdate.getDate() : null;
        //Customer information
        String customerPhone = CHECKER.removeStringBlanks(txtPhoneNumber.getText());
        String customerAddress = txtAddress.getText();
        String customerEmail = txtEmail.getText();
        
        try {
            if (changeColorRequiredField() && changeColorNoRequiredField()) {
                Customer findCustomer = NEW_REQUEST_CUSTOMER.getCustomerByDNI(personIdentificationNumber);
                
                if (findCustomer != null && findCustomer.isIsDelete()) {
                    NEW_REQUEST_PERSON.editPerson(personIdentificationNumber, personFirstName, personSecondName,
                            personFirstLastName, personSecondLastName, personIdentificationType, personBirthdate);
                    
                    Person editPerson = new Person(personFirstName, personSecondName,
                            personFirstLastName, personSecondLastName,
                            personIdentificationType, personIdentificationNumber, personBirthdate);
                    
                    Customer editCustomer = new Customer(customerPhone, customerAddress, customerEmail, false, editPerson);
                    editCustomer.setCustomerId(findCustomer.getCustomerId());
                    
                    NEW_REQUEST_CUSTOMER.editCustomer(editCustomer);

                } else if (findCustomer != null && !findCustomer.isIsDelete()) {
                    personalizedMessage("Error", "El numero de identificación ya está asociado a alguien.",
                            "Identificación duplicada");
                    return;
                } else {
                    NEW_REQUEST_PERSON.savePerson(personFirstName, personSecondName, personFirstLastName,
                            personSecondLastName, personIdentificationType, personIdentificationNumber, personBirthdate);

                    Person person = new Person(personFirstName, personSecondName,
                            personFirstLastName, personSecondLastName,
                            personIdentificationType, personIdentificationNumber, personBirthdate);
                    Customer customer = new Customer(customerPhone, customerAddress, customerEmail, false, person);

                    NEW_REQUEST_CUSTOMER.saveCustomer(customer);
                }

                personalizedMessage("Information", "El cliente ha sido agregado correctamente", "Operación exitosa");
                clearFields();
            }

        } catch (PreexistingEntityException ex) {
            personalizedMessage("Error", "El numero de identificación ya está asociado a alguien.",
                    "Identificación duplicada");
            txtIdentificationNum.setBackground(COLOR_RED);
        } catch (Exception e) {
            Logger.getLogger(AddCustomerView.class.getName()).log(Level.SEVERE, null, e);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Dirección;
    private javax.swing.JButton btnCleanFields;
    private javax.swing.JButton btnSaveWorker;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JPanel dataInformation1Panel;
    private javax.swing.JPanel dataInformation2Panel;
    private com.toedter.calendar.JDateChooser dateBirthdate;
    private javax.swing.JPanel information1Panel;
    private javax.swing.JPanel information2Panel;
    private javax.swing.JLabel lbAge;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbEps;
    private javax.swing.JLabel lbFirstName;
    private javax.swing.JLabel lbFirstlastName;
    private javax.swing.JLabel lbIdentificationNum;
    private javax.swing.JLabel lbIdentificationType;
    private javax.swing.JLabel lbSecondLastName;
    private javax.swing.JLabel lbSecondName;
    private javax.swing.JPanel lbsInformation1Panel;
    private javax.swing.JPanel lbsInformation2Panel;
    private javax.swing.JComboBox<String> sltIdentificationType;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstLastName;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtIdentificationNum;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtSecondLastName;
    private javax.swing.JTextField txtSecondName;
    // End of variables declaration//GEN-END:variables
}
