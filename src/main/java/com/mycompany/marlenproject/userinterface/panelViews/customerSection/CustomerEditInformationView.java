/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.marlenproject.userinterface.panelViews.customerSection;

import com.mycompany.marlenproject.data.forms.person.dataFormsPerson;
import com.mycompany.marlenproject.userinterface.panelViews.workersSection.*;
import com.mycompany.marlenproject.utils.fields.InputValidator;
import com.mycompany.marlenproject.logic.Customer;
import com.mycompany.marlenproject.logic.Person;
import com.mycompany.marlenproject.logic.request.RequestCustomer;
import com.mycompany.marlenproject.logic.request.requestPerson;
import com.mycompany.marlenproject.persistence.exceptions.NonexistentEntityException;
import com.mycompany.marlenproject.persistence.exceptions.PreexistingEntityException;
import com.mycompany.marlenproject.utils.colors.Colors;
import com.mycompany.marlenproject.userinterface.AdminHome;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CustomerEditInformationView extends javax.swing.JFrame {

    private final requestPerson NEW_REQUEST_PERSON = new requestPerson();
    private final RequestCustomer NEW_REQUEST_CUSTOMER = new RequestCustomer();
    private final Customer customerInfo;
    private final AdminHome PRINCIPALJFRAME;

    private void returnCustomerList(String personIdentificationNumber) {
        List<Customer> CustomerList = NEW_REQUEST_CUSTOMER.getNoDeleteCustomer();

        if (!CustomerList.isEmpty()) {
            int indexActualCustomer = findWorkerByDni(personIdentificationNumber, CustomerList);
            CustomerInformationView customerInformationView = new CustomerInformationView(PRINCIPALJFRAME, CustomerList, indexActualCustomer);
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

        sltCustomerIdentificationType.setSelectedIndex(dataFormsPerson
                .findIndexSelected(dataFormsPerson.IDENTIFICATION_TYPE, customer.getPerson().getIdentificationType()));

        txtCustomerIdentificationNumber.setText(customer.getPerson().getIdentificationNumber());

        dtCustomerBirthdate.setDate(customer.getPerson().getBirthdate());

        txtCustomerEmail.setText(customer.getEmail());

        txtCustomerPhone.setText(customer.getPhone());

        txtCustomerAddress.setText(customer.getAddress());
    }

    private boolean changeColorRequiredField() {
        String personFirstName = InputValidator.removeStringBlanks(txtCustomerFirstName.getText());
        String personFirstLastName = InputValidator.removeStringBlanks(txtCustomerFirstLastName.getText());
        String personIdentificationType = sltCustomerIdentificationType.getSelectedItem().toString();
        String personIdentificationNumber = InputValidator.removeStringBlanks(txtCustomerIdentificationNumber.getText());

        if (!InputValidator.checkStringField(personFirstName)) {
            txtCustomerFirstName.setBackground(Colors.IncorrectColorFields());
            return false;
        }

        if (!InputValidator.checkStringField(personFirstLastName)) {
            txtCustomerFirstLastName.setBackground(Colors.IncorrectColorFields());
            return false;
        }

        if (!InputValidator.checkComboBox(personIdentificationType)) {
            sltCustomerIdentificationType.setBackground(Colors.IncorrectColorFields());
            return false;
        }

        if (!InputValidator.checkIdentification(sltCustomerIdentificationType.getSelectedIndex(),personIdentificationNumber)) {
            txtCustomerIdentificationNumber.setBackground(Colors.IncorrectColorFields());
            return false;
        }

        return true;
    }

    private boolean changeColorNoRequiredField() {
        String personSecondName = InputValidator.removeStringBlanks(txtCustomerSecondName.getText());
        String personSecondLastName = InputValidator.removeStringBlanks(txtCustomerSecondLastName.getText());
        String customerPhone = InputValidator.removeStringBlanks(txtCustomerPhone.getText());
        String customerAddress = txtCustomerAddress.getText();
        String customerEmail = txtCustomerEmail.getText();

        if (!personSecondName.isBlank() && !InputValidator.checkStringField(personSecondName)) {
            txtCustomerSecondName.setBackground(Colors.IncorrectColorFields());
            return false;
        }

        if (!personSecondLastName.isBlank() && !InputValidator.checkStringField(personSecondLastName)) {
            txtCustomerSecondLastName.setBackground(Colors.IncorrectColorFields());
            return false;
        }

        if (!customerPhone.isBlank() && !InputValidator.checkNumberField(customerPhone)) {
            txtCustomerPhone.setBackground(Colors.IncorrectColorFields());
            return false;
        }

        if (!customerEmail.isBlank() && !InputValidator.checkEmail(customerEmail)) {
            txtCustomerEmail.setBackground(Colors.IncorrectColorFields());
            return false;
        }

        if (!InputValidator.checkAddress(customerAddress) && !customerAddress.equalsIgnoreCase("")) {
            txtCustomerAddress.setBackground(Colors.IncorrectColorFields());
            return false;
        }

        return true;
    }

    private void clearFields() {
        txtCustomerFirstName.setText("");
        txtCustomerSecondName.setText("");
        txtCustomerFirstLastName.setText("");
        txtCustomerSecondLastName.setText("");
        sltCustomerIdentificationType.setSelectedIndex(0);
        dtCustomerBirthdate.setDate(null);
        txtCustomerEmail.setText("");
        txtCustomerPhone.setText("");
        txtCustomerAddress.setText("");

        txtCustomerFirstName.setBackground(Colors.NormalColorFields());
        txtCustomerSecondName.setBackground(Colors.NormalColorFields());
        txtCustomerFirstLastName.setBackground(Colors.NormalColorFields());
        txtCustomerSecondLastName.setBackground(Colors.NormalColorFields());
        sltCustomerIdentificationType.setBackground(Colors.NormalColorFields());
        dtCustomerBirthdate.setBackground(Colors.NormalColorFields());
        txtCustomerEmail.setBackground(Colors.NormalColorFields());
        txtCustomerPhone.setBackground(Colors.NormalColorFields());
        txtCustomerAddress.setBackground(Colors.NormalColorFields());
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
        this.customerInfo = customer;
        initComponents();
        setLocationRelativeTo(null);
        setActualInformation(customerInfo);
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
        txtCustomerFirstName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustomerFirstNameFocusGained(evt);
            }
        });

        txtCustomerFirstLastName.setPreferredSize(new java.awt.Dimension(211, 25));
        txtCustomerFirstLastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustomerFirstLastNameFocusGained(evt);
            }
        });

        sltCustomerIdentificationType.setModel(new javax.swing.DefaultComboBoxModel<>(dataFormsPerson.IDENTIFICATION_TYPE));
        sltCustomerIdentificationType.setPreferredSize(new java.awt.Dimension(211, 25));
        sltCustomerIdentificationType.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sltCustomerIdentificationTypeFocusGained(evt);
            }
        });

        dtCustomerBirthdate.setPreferredSize(new java.awt.Dimension(0, 25));
        this.dtCustomerBirthdate.getDateEditor().getUiComponent().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(evt.getClickCount()==1){
                    dtCustomerBirthdateMouseClicked();
                }
            }
        });

        txtCustomerEmail.setPreferredSize(new java.awt.Dimension(0, 25));
        txtCustomerEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustomerEmailFocusGained(evt);
            }
        });

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

        txtCustomerIdentificationNumber.setEnabled(false);
        txtCustomerIdentificationNumber.setPreferredSize(new java.awt.Dimension(211, 25));
        txtCustomerIdentificationNumber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCustomerIdentificationNumberMouseClicked(evt);
            }
        });

        txtCustomerSecondLastName.setPreferredSize(new java.awt.Dimension(211, 25));
        txtCustomerSecondLastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustomerSecondLastNameFocusGained(evt);
            }
        });

        txtCustomerSecondName.setPreferredSize(new java.awt.Dimension(211, 25));
        txtCustomerSecondName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustomerSecondNameFocusGained(evt);
            }
        });

        txtCustomerPhone.setPreferredSize(new java.awt.Dimension(0, 25));
        txtCustomerPhone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustomerPhoneFocusGained(evt);
            }
        });

        txtCustomerAddress.setPreferredSize(new java.awt.Dimension(0, 25));
        txtCustomerAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustomerAddressFocusGained(evt);
            }
        });

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

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        if (changeColorRequiredField() && changeColorNoRequiredField()) {
            String personFirstName = InputValidator.removeStringBlanks(txtCustomerFirstName.getText());
            String personSecondName = InputValidator.removeStringBlanks(txtCustomerSecondName.getText());//
            String personFirstLastName = InputValidator.removeStringBlanks(txtCustomerFirstLastName.getText());
            String personSecondLastName = InputValidator.removeStringBlanks(txtCustomerSecondLastName.getText());//
            String personIdentificationType = sltCustomerIdentificationType.getSelectedItem().toString();
            String personIdentificationNumber = txtCustomerIdentificationNumber.getText();
            Date personBirthdate = dtCustomerBirthdate.getDate();

            String customerPhone = InputValidator.removeStringBlanks(txtCustomerPhone.getText());
            String customerAddress = txtCustomerAddress.getText();
            String customerEmail = txtCustomerEmail.getText();

            Person person = new Person(personFirstName, personSecondName, personFirstLastName, personSecondLastName, personIdentificationType, personIdentificationNumber, personBirthdate);
            Customer editCustomer = new Customer(customerPhone, customerAddress, customerEmail, customerInfo.isIsDelete(), person);
            editCustomer.setCustomerId(this.customerInfo.getCustomerId());
            try {
                
                NEW_REQUEST_PERSON.editPerson(person);
                NEW_REQUEST_CUSTOMER.editCustomer(editCustomer);

                JOptionPane.showMessageDialog(this, "La información ha sido cambiada correctamente", "Operación exitosa", 1);
                returnCustomerList(personIdentificationNumber);
                
            } catch (PreexistingEntityException ex) {
                JOptionPane.showMessageDialog(this, "El numero de identificación ya está asociado a alguien.", "Identificación duplicada", 0);
                txtCustomerIdentificationNumber.setBackground(Colors.IncorrectColorFields());

            } catch (NonexistentEntityException ex) {
                JOptionPane.showMessageDialog(this, "El numero de identificación no existe", "Identificación no existente", 0);
                txtCustomerIdentificationNumber.setBackground(Colors.IncorrectColorFields());

            } catch (Exception ex) {
                Logger.getLogger(AddWorkerView.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Asegurese de que los campos en rojo estén correctamente diligenciados", "Error en Campos", 0);
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

    private void txtCustomerFirstNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomerFirstNameFocusGained
        txtCustomerFirstName.setBackground(Colors.NormalColorFields());
    }//GEN-LAST:event_txtCustomerFirstNameFocusGained

    private void txtCustomerFirstLastNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomerFirstLastNameFocusGained
        txtCustomerFirstLastName.setBackground(Colors.NormalColorFields());
    }//GEN-LAST:event_txtCustomerFirstLastNameFocusGained

    private void sltCustomerIdentificationTypeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sltCustomerIdentificationTypeFocusGained
        sltCustomerIdentificationType.setBackground(Colors.NormalColorFields());
    }//GEN-LAST:event_sltCustomerIdentificationTypeFocusGained

    private void txtCustomerEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomerEmailFocusGained
        txtCustomerEmail.setBackground(Colors.NormalColorFields());
    }//GEN-LAST:event_txtCustomerEmailFocusGained

    private void txtCustomerSecondNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomerSecondNameFocusGained
        txtCustomerSecondName.setBackground(Colors.NormalColorFields());
    }//GEN-LAST:event_txtCustomerSecondNameFocusGained

    private void txtCustomerSecondLastNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomerSecondLastNameFocusGained
        txtCustomerSecondLastName.setBackground(Colors.NormalColorFields());
    }//GEN-LAST:event_txtCustomerSecondLastNameFocusGained

    private void txtCustomerPhoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomerPhoneFocusGained
        txtCustomerPhone.setBackground(Colors.NormalColorFields());
    }//GEN-LAST:event_txtCustomerPhoneFocusGained

    private void txtCustomerAddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomerAddressFocusGained
        txtCustomerAddress.setBackground(Colors.NormalColorFields());
    }//GEN-LAST:event_txtCustomerAddressFocusGained

    private void txtCustomerIdentificationNumberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCustomerIdentificationNumberMouseClicked
        String Message = "                      Por razones de seguridad este campo no es editable.";
        String suggest = "\n\n Si el número de cédula es diferente, le recomendamos agregarla como un nuevo cliente.";
        
        JOptionPane.showMessageDialog(this, Message.concat(suggest) , "Acción invalida", 1);
    }//GEN-LAST:event_txtCustomerIdentificationNumberMouseClicked

    private void dtCustomerBirthdateMouseClicked() {
        dtCustomerBirthdate.setBackground(Colors.NormalColorFields());
    }

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
