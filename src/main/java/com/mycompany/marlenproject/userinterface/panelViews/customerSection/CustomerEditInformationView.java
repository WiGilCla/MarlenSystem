/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.marlenproject.userinterface.panelViews.customerSection;

import com.mycompany.marlenproject.userinterface.panelViews.workersSection.*;
import com.mycompany.marlenproject.logic.CheckFields;
import com.mycompany.marlenproject.logic.Customer;
import com.mycompany.marlenproject.logic.Person;
import com.mycompany.marlenproject.logic.request.RequestCustomer;
import com.mycompany.marlenproject.logic.request.requestPerson;
import com.mycompany.marlenproject.persistence.exceptions.NonexistentEntityException;
import com.mycompany.marlenproject.persistence.exceptions.PreexistingEntityException;
import com.mycompany.marlenproject.userinterface.AdminHome;
import java.awt.Color;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CustomerEditInformationView extends javax.swing.JFrame {

    private final ComboBoxWorkerOptions COMBO_BOX_OPTION = new ComboBoxWorkerOptions();
    private Customer customer;
    private final requestPerson NEW_REQUEST_PERSON = new requestPerson();
    private final RequestCustomer NEW_REQUEST_CUSTOMER = new RequestCustomer();
    private final CheckFields CHECKER = new CheckFields();
    private final Color COLOR_RED = new Color(255, 0, 0);
    private final Color COLOR_WHITE = new Color(255, 255, 255);
    private final AdminHome PRINCIPALJFRAME;

    private void backView(String personIdentificationNumber) {
        List<Customer> CustomerList = NEW_REQUEST_CUSTOMER.getNoDeleteCustomer();

        if (!CustomerList.isEmpty()) {

            int customerIndex = findWorkerByDni(personIdentificationNumber, CustomerList);
            CustomerInformationView customerInformationView = new CustomerInformationView(PRINCIPALJFRAME, CustomerList, customerIndex);
            PRINCIPALJFRAME.replacePanel(customerInformationView);
            PRINCIPALJFRAME.setVisible(true);

        } else {

            WorkersFirstView workersFirstView = new WorkersFirstView(PRINCIPALJFRAME);
            PRINCIPALJFRAME.replacePanel(workersFirstView);
            PRINCIPALJFRAME.setVisible(true);
        }
    }

    private void setActualInformation(Customer customer) {

        txtCustomerFirstName.setText(customer.getPerson().getFirstName());

        txtCustomerSecondName.setText(customer.getPerson().getSecondName());

        txtCustomerFirstLastName.setText(customer.getPerson().getFirstLastName());

        txtCustomerSecondLastName.setText(customer.getPerson().getSecondLastName());

        sltCustomerIdentificationType.setSelectedIndex(COMBO_BOX_OPTION
                .findIndexSelected(COMBO_BOX_OPTION.getIdentificationTypeOptions(), customer.getPerson().getIdentificationType()));

        txtCustomerIdentificationNumber.setText(customer.getPerson().getIdentificationNumber());

        dtCustomerBirthdate.setDate(customer.getPerson().getBirthdate());

        txtCustomerEmail.setText(customer.getEmail());

        txtCustomerPhone.setText(customer.getPhone());

        txtCustomerAddress.setText(customer.getAddress());
    }

    private boolean changeColorRequiredField() {
        String personFirstName = CHECKER.removeStringBlanks(txtCustomerFirstName.getText());
        String personFirstLastName = CHECKER.removeStringBlanks(txtCustomerFirstLastName.getText());
        String personIdentificationType = sltCustomerIdentificationType.getSelectedItem().toString();
        String personIdentificationNumber = CHECKER.removeStringBlanks(txtCustomerIdentificationNumber.getText());

        if (!CHECKER.checkStringField(personFirstName)) {
            txtCustomerFirstName.setBackground(COLOR_RED);
            return false;
        }

        if (!CHECKER.checkStringField(personFirstLastName)) {
            txtCustomerFirstLastName.setBackground(COLOR_RED);
            return false;
        }

        if (!CHECKER.checkComboBox(personIdentificationType)) {
            sltCustomerIdentificationType.setBackground(COLOR_RED);
            return false;
        }

        if (!CHECKER.checkNumberField(personIdentificationNumber)
                || !(personIdentificationNumber.length() <= 10
                && personIdentificationNumber.length() >= 8)) {
            txtCustomerIdentificationNumber.setBackground(COLOR_RED);
            return false;
        }

        return true;
    }

    private boolean changeColorNoRequiredField() {
        String personSecondName = CHECKER.removeStringBlanks(txtCustomerSecondName.getText());
        String personSecondLastName = CHECKER.removeStringBlanks(txtCustomerSecondLastName.getText());
        String customerPhone = CHECKER.removeStringBlanks(txtCustomerPhone.getText());
        String customerAddress = txtCustomerAddress.getText();
        String customerEmail = txtCustomerEmail.getText();

        if (!personSecondName.isBlank() && !CHECKER.checkStringField(personSecondName)) {
            txtCustomerSecondName.setBackground(COLOR_RED);
            return false;
        }

        if (!personSecondLastName.isBlank() && !CHECKER.checkStringField(personSecondLastName)) {
            txtCustomerSecondLastName.setBackground(COLOR_RED);
            return false;
        }

        if (!customerPhone.isBlank() && !CHECKER.checkNumberField(customerPhone)) {
            txtCustomerPhone.setBackground(COLOR_RED);
            return false;
        }

        if (!customerEmail.isBlank() && !CHECKER.checkEmail(customerEmail)) {
            txtCustomerEmail.setBackground(COLOR_RED);
            return false;
        }

        return true;
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
        JOptionPane.showMessageDialog(this.PRINCIPALJFRAME, message, title, typeMessage);
    }

    private void clearFields() {
        txtCustomerFirstName.setText("");
        txtCustomerSecondName.setText("");
        txtCustomerFirstLastName.setText("");
        txtCustomerSecondLastName.setText("");
        sltCustomerIdentificationType.setSelectedIndex(0);
        txtCustomerIdentificationNumber.setText("");
        dtCustomerBirthdate.setDate(null);
        txtCustomerEmail.setText("");
        txtCustomerPhone.setText("");
        txtCustomerAddress.setText("");
    }

    private int findWorkerByDni(String dni, List<Customer> customerList) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getPerson().getIdentificationNumber().equals(dni)) {
                return i;
            }
        }
        return 0;
    }

    public CustomerEditInformationView(Customer customer, AdminHome principalJFrame) {
        this.PRINCIPALJFRAME = principalJFrame;
        this.customer = customer;
        initComponents();
        setActualInformation(customer);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        defaultPanel = new javax.swing.JPanel();
        information1Panel = new javax.swing.JPanel();
        labelsPanel1 = new javax.swing.JPanel();
        lbCustomerFirstName = new javax.swing.JLabel();
        lbCustomerFirstLastName = new javax.swing.JLabel();
        lbCustomerIdentificationType = new javax.swing.JLabel();
        lbCustomerBirthdate = new javax.swing.JLabel();
        lbCustomerEmail = new javax.swing.JLabel();
        fields1Panel = new javax.swing.JPanel();
        txtCustomerFirstName = new javax.swing.JTextField();
        txtCustomerFirstLastName = new javax.swing.JTextField();
        sltCustomerIdentificationType = new javax.swing.JComboBox<>();
        dtCustomerBirthdate = new com.toedter.calendar.JDateChooser();
        txtCustomerEmail = new javax.swing.JTextField();
        information2Panel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbCustomerSecondName = new javax.swing.JLabel();
        lbCustomerSecondLastName = new javax.swing.JLabel();
        lbCustomerIdentificationNumber = new javax.swing.JLabel();
        lbCustomerPhone = new javax.swing.JLabel();
        lbCustomerAddress = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtCustomerIdentificationNumber = new javax.swing.JTextField();
        txtCustomerSecondLastName = new javax.swing.JTextField();
        txtCustomerSecondName = new javax.swing.JTextField();
        txtCustomerPhone = new javax.swing.JTextField();
        txtCustomerAddress = new javax.swing.JTextField();
        buttonsPanel = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(800, 400));

        defaultPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EDITAR INFORMACIÓN DE CLIENTE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        defaultPanel.setPreferredSize(new java.awt.Dimension(800, 400));

        information1Panel.setPreferredSize(new java.awt.Dimension(391, 282));
        information1Panel.setVerifyInputWhenFocusTarget(false);

        labelsPanel1.setPreferredSize(new java.awt.Dimension(150, 338));

        lbCustomerFirstName.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbCustomerFirstName.setText("Primer nombre:");
        lbCustomerFirstName.setPreferredSize(new java.awt.Dimension(138, 25));

        lbCustomerFirstLastName.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbCustomerFirstLastName.setText("Primer apellido:");
        lbCustomerFirstLastName.setPreferredSize(new java.awt.Dimension(138, 25));

        lbCustomerIdentificationType.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbCustomerIdentificationType.setText("Tipo de identificación:");
        lbCustomerIdentificationType.setPreferredSize(new java.awt.Dimension(138, 25));

        lbCustomerBirthdate.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbCustomerBirthdate.setText("Fecha de nacimiento:");
        lbCustomerBirthdate.setPreferredSize(new java.awt.Dimension(138, 25));

        lbCustomerEmail.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbCustomerEmail.setText("Correo electrónico:");
        lbCustomerEmail.setPreferredSize(new java.awt.Dimension(138, 25));

        javax.swing.GroupLayout labelsPanel1Layout = new javax.swing.GroupLayout(labelsPanel1);
        labelsPanel1.setLayout(labelsPanel1Layout);
        labelsPanel1Layout.setHorizontalGroup(
            labelsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, labelsPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(labelsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbCustomerIdentificationType, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(lbCustomerBirthdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCustomerEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCustomerFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCustomerFirstLastName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        labelsPanel1Layout.setVerticalGroup(
            labelsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(labelsPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCustomerFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCustomerFirstLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCustomerIdentificationType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCustomerBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCustomerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        fields1Panel.setPreferredSize(new java.awt.Dimension(223, 338));

        txtCustomerFirstName.setPreferredSize(new java.awt.Dimension(211, 25));
        txtCustomerFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerFirstNameActionPerformed(evt);
            }
        });

        txtCustomerFirstLastName.setPreferredSize(new java.awt.Dimension(211, 25));
        txtCustomerFirstLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerFirstLastNameActionPerformed(evt);
            }
        });

        sltCustomerIdentificationType.setModel(new javax.swing.DefaultComboBoxModel<>(COMBO_BOX_OPTION.getIdentificationTypeOptions()));
        sltCustomerIdentificationType.setPreferredSize(new java.awt.Dimension(211, 25));
        sltCustomerIdentificationType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sltCustomerIdentificationTypeActionPerformed(evt);
            }
        });

        dtCustomerBirthdate.setPreferredSize(new java.awt.Dimension(0, 25));

        txtCustomerEmail.setPreferredSize(new java.awt.Dimension(0, 25));

        javax.swing.GroupLayout fields1PanelLayout = new javax.swing.GroupLayout(fields1Panel);
        fields1Panel.setLayout(fields1PanelLayout);
        fields1PanelLayout.setHorizontalGroup(
            fields1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fields1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fields1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sltCustomerIdentificationType, 0, 214, Short.MAX_VALUE)
                    .addComponent(txtCustomerFirstLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCustomerFirstName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtCustomerBirthdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCustomerEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        fields1PanelLayout.setVerticalGroup(
            fields1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fields1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCustomerFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCustomerFirstLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sltCustomerIdentificationType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dtCustomerBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCustomerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        lbCustomerSecondName.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbCustomerSecondName.setText("Segundo nombre:");
        lbCustomerSecondName.setPreferredSize(new java.awt.Dimension(138, 25));

        lbCustomerSecondLastName.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbCustomerSecondLastName.setText("Segundo apellido:");
        lbCustomerSecondLastName.setPreferredSize(new java.awt.Dimension(138, 25));

        lbCustomerIdentificationNumber.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbCustomerIdentificationNumber.setText("Numero de identificación:");
        lbCustomerIdentificationNumber.setPreferredSize(new java.awt.Dimension(138, 25));

        lbCustomerPhone.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbCustomerPhone.setText("Teléfono / Celular:");
        lbCustomerPhone.setPreferredSize(new java.awt.Dimension(138, 25));

        lbCustomerAddress.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbCustomerAddress.setText("Dirección:");
        lbCustomerAddress.setPreferredSize(new java.awt.Dimension(138, 25));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCustomerSecondLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(lbCustomerIdentificationNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCustomerPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCustomerAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCustomerSecondName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCustomerSecondName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCustomerSecondLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCustomerIdentificationNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCustomerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(223, 338));

        txtCustomerIdentificationNumber.setPreferredSize(new java.awt.Dimension(211, 25));
        txtCustomerIdentificationNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerIdentificationNumberActionPerformed(evt);
            }
        });

        txtCustomerSecondLastName.setPreferredSize(new java.awt.Dimension(211, 25));
        txtCustomerSecondLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerSecondLastNameActionPerformed(evt);
            }
        });

        txtCustomerSecondName.setPreferredSize(new java.awt.Dimension(211, 25));
        txtCustomerSecondName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerSecondNameActionPerformed(evt);
            }
        });

        txtCustomerPhone.setPreferredSize(new java.awt.Dimension(0, 25));

        txtCustomerAddress.setPreferredSize(new java.awt.Dimension(0, 25));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCustomerIdentificationNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCustomerSecondLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCustomerSecondName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCustomerPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCustomerAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCustomerSecondName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCustomerSecondLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCustomerIdentificationNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCustomerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconCancel.png"))); // NOI18N
        btnCancel.setText("Cancelar");
        btnCancel.setPreferredSize(new java.awt.Dimension(180, 60));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnClean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconDelete.png"))); // NOI18N
        btnClean.setText("Limpiar campos");
        btnClean.setPreferredSize(new java.awt.Dimension(180, 60));
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconSave.png"))); // NOI18N
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
                .addContainerGap(14, Short.MAX_VALUE))
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

    private void txtCustomerFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerFirstNameActionPerformed
        txtCustomerFirstName.setBackground(COLOR_WHITE);
    }//GEN-LAST:event_txtCustomerFirstNameActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        if (changeColorRequiredField() && changeColorNoRequiredField()) {
            String personFirstName = CHECKER.removeStringBlanks(txtCustomerFirstName.getText());
            String personSecondName = CHECKER.removeStringBlanks(txtCustomerSecondName.getText());//
            String personFirstLastName = CHECKER.removeStringBlanks(txtCustomerFirstLastName.getText());
            String personSecondLastName = CHECKER.removeStringBlanks(txtCustomerSecondLastName.getText());//
            String personIdentificationType = sltCustomerIdentificationType.getSelectedItem().toString();
            String personIdentificationNumber = CHECKER.removeStringBlanks(txtCustomerIdentificationNumber.getText());
            Date personBirthdate = dtCustomerBirthdate.getDate();
            
            String customerPhone = CHECKER.removeStringBlanks(txtCustomerPhone.getText());
            String customerAddress = txtCustomerAddress.getText();
            String customerEmail = txtCustomerEmail.getText();
            
            Person person = new Person(personFirstName, personSecondName, personFirstLastName, personSecondLastName, personIdentificationType, personIdentificationNumber, personBirthdate);

            try {
                
                Customer editCustomer = new Customer(customerPhone, customerAddress, customerEmail,
                        customer.isIsDelete(), person);
                editCustomer.setCustomerId(this.customer.getCustomerId());

                if (this.customer.getPerson().getIdentificationNumber().equals(personIdentificationNumber)) {
                    NEW_REQUEST_PERSON.editPerson(person);
                    NEW_REQUEST_CUSTOMER.editCustomer(editCustomer);
                } else {
                    Customer findCustomer = NEW_REQUEST_CUSTOMER.getCustomerByDNI(personIdentificationNumber);

                    if(findCustomer == null){
                        NEW_REQUEST_PERSON.savePerson(person);
                        NEW_REQUEST_CUSTOMER.editCustomer(editCustomer);
                        
                        NEW_REQUEST_PERSON.deletePerson(customer.getPerson().getIdentificationNumber());
                    }else if (!findCustomer.isIsDelete()) {
                        personalizedMessage("Error",
                                "Esta identificación ya está asociada a un cliente, ve y corrigelo para intentarlo nuevamente",
                                "Registro ya existente");
                        txtCustomerIdentificationNumber.setBackground(COLOR_RED);
                        return;
                    } else if (findCustomer.isIsDelete()) {
                        NEW_REQUEST_CUSTOMER.deleteCustomer(this.customer.getCustomerId());
                        NEW_REQUEST_PERSON.deletePerson(this.customer.getPerson().getIdentificationNumber());
                        
                        NEW_REQUEST_PERSON.editPerson(person);
                        editCustomer.setCustomerId(findCustomer.getCustomerId());
                        NEW_REQUEST_CUSTOMER.editCustomer(editCustomer);
                    }
                }

                personalizedMessage("Information", "La información ha sido cambiada correctamente", "Operación exitosa");
                backView(personIdentificationNumber);
            } catch (PreexistingEntityException ex) {

                personalizedMessage("Error", "El numero de identificación ya está asociado a alguien.", "Identificación duplicada");
                txtCustomerIdentificationNumber.setBackground(COLOR_RED);

            } catch (NonexistentEntityException ex) {

                personalizedMessage("Error", "El numero de identificación no existe", "Identificación no existente");
                txtCustomerIdentificationNumber.setBackground(COLOR_RED);

            } catch (Exception ex) {
                Logger.getLogger(AddWorkerView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            personalizedMessage("Warning", "Asegurese de que los campos en rojo estén correctamente diligenciados", "Error en Campos");
            return;
        }

        this.dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        clearFields();
    }//GEN-LAST:event_btnCleanActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
        this.PRINCIPALJFRAME.setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtCustomerFirstLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerFirstLastNameActionPerformed
        txtCustomerFirstLastName.setBackground(COLOR_WHITE);
    }//GEN-LAST:event_txtCustomerFirstLastNameActionPerformed

    private void sltCustomerIdentificationTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sltCustomerIdentificationTypeActionPerformed
        sltCustomerIdentificationType.setBackground(COLOR_WHITE);
    }//GEN-LAST:event_sltCustomerIdentificationTypeActionPerformed

    private void txtCustomerSecondNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerSecondNameActionPerformed
        txtCustomerSecondName.setBackground(COLOR_WHITE);
    }//GEN-LAST:event_txtCustomerSecondNameActionPerformed

    private void txtCustomerSecondLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerSecondLastNameActionPerformed
        txtCustomerSecondLastName.setBackground(COLOR_WHITE);
    }//GEN-LAST:event_txtCustomerSecondLastNameActionPerformed

    private void txtCustomerIdentificationNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerIdentificationNumberActionPerformed
        txtCustomerIdentificationNumber.setBackground(COLOR_WHITE);
    }//GEN-LAST:event_txtCustomerIdentificationNumberActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JPanel defaultPanel;
    private com.toedter.calendar.JDateChooser dtCustomerBirthdate;
    private javax.swing.JPanel fields1Panel;
    private javax.swing.JPanel information1Panel;
    private javax.swing.JPanel information2Panel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel labelsPanel1;
    private javax.swing.JLabel lbCustomerAddress;
    private javax.swing.JLabel lbCustomerBirthdate;
    private javax.swing.JLabel lbCustomerEmail;
    private javax.swing.JLabel lbCustomerFirstLastName;
    private javax.swing.JLabel lbCustomerFirstName;
    private javax.swing.JLabel lbCustomerIdentificationNumber;
    private javax.swing.JLabel lbCustomerIdentificationType;
    private javax.swing.JLabel lbCustomerPhone;
    private javax.swing.JLabel lbCustomerSecondLastName;
    private javax.swing.JLabel lbCustomerSecondName;
    private javax.swing.JComboBox<String> sltCustomerIdentificationType;
    private javax.swing.JTextField txtCustomerAddress;
    private javax.swing.JTextField txtCustomerEmail;
    private javax.swing.JTextField txtCustomerFirstLastName;
    private javax.swing.JTextField txtCustomerFirstName;
    private javax.swing.JTextField txtCustomerIdentificationNumber;
    private javax.swing.JTextField txtCustomerPhone;
    private javax.swing.JTextField txtCustomerSecondLastName;
    private javax.swing.JTextField txtCustomerSecondName;
    // End of variables declaration//GEN-END:variables
}
