/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.marlenproject.userinterface.panelViews.customerSection;

import com.mycompany.marlenproject.userinterface.PeopleManagementView;
import com.mycompany.marlenproject.userinterface.panelViews.workersSection.*;
import com.mycompany.marlenproject.utils.fields.InputValidator;
import com.mycompany.marlenproject.logic.Customer;
import com.mycompany.marlenproject.logic.request.RequestCustomer;
import com.mycompany.marlenproject.userinterface.AdminHome;
import com.mycompany.marlenproject.utils.message.JPaneMessage;
import com.mycompany.marlenproject.utils.colors.Colors;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerInformationView extends javax.swing.JPanel {

    private final RequestCustomer REQUEST_CUSTOMER = new RequestCustomer();
    private List<Customer> CUSTOMER_LIST = new ArrayList<>();
    private int customerIndex = 0;

    private final AdminHome PRINCIPALJFRAME;

    private void viewWorkerInformation(int index) {
        Customer customer = this.CUSTOMER_LIST.get(index);
        txtCustomerFirstName.setText(customer.getPerson().getFirstName());
        txtCustomerSecondName.setText(customer.getPerson().getSecondName());
        txtCustomerFirstLastName.setText(customer.getPerson().getFirstLastName());
        txtCustomerSecondLastName.setText(customer.getPerson().getSecondLastName());
        txtCustomerIdentificationType.setText(customer.getPerson().getIdentificationType());
        txtCustomerIdentificationNum.setText(String.valueOf(customer.getPerson().getIdentificationNumber()));
        txtCustomerPhone.setText(customer.getPhone());
        txtCustomerBirthdate.setText((customer.getPerson().getBirthdate() != null)
                ? String.valueOf(InputValidator.timeElapsed(customer.getPerson().getBirthdate(), new Date())) : "No registra");
        txtCustomerEmail.setText(customer.getEmail());
        txtCustomerAddress.setText(customer.getAddress());
    }

    public CustomerInformationView(AdminHome principalJFrame, List<Customer> CustomerList, int index) {
        this.CUSTOMER_LIST = CustomerList;
        this.customerIndex = index;
        this.PRINCIPALJFRAME = principalJFrame;
        initComponents();
        viewWorkerInformation(customerIndex);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonsPanel = new javax.swing.JPanel();
        btnDeleteCustomer = new javax.swing.JButton();
        btnEditCustomer = new javax.swing.JButton();
        btnNextWorker = new javax.swing.JButton();
        btnPreviousWorker = new javax.swing.JButton();
        information1Panel = new javax.swing.JPanel();
        lbsInformation1Panel = new javax.swing.JPanel();
        lbCustomerFirstName = new javax.swing.JLabel();
        lbCustomerFirstlastName = new javax.swing.JLabel();
        lbCustomerIdentificationType = new javax.swing.JLabel();
        lbCustomerBirthdate = new javax.swing.JLabel();
        lbCustomerEmail = new javax.swing.JLabel();
        dataInformation1Panel = new javax.swing.JPanel();
        txtCustomerFirstName = new javax.swing.JTextField();
        txtCustomerFirstLastName = new javax.swing.JTextField();
        txtCustomerEmail = new javax.swing.JTextField();
        txtCustomerIdentificationType = new javax.swing.JTextField();
        txtCustomerBirthdate = new javax.swing.JTextField();
        information2Panel = new javax.swing.JPanel();
        lbsInformation2Panel = new javax.swing.JPanel();
        lbCustomerSecondName = new javax.swing.JLabel();
        lbCustomerSecondLastName = new javax.swing.JLabel();
        lbCustomerIdentificationNum = new javax.swing.JLabel();
        lbCustomerPhone = new javax.swing.JLabel();
        lbCustomerAddress = new javax.swing.JLabel();
        dataInformation2Panel = new javax.swing.JPanel();
        txtCustomerSecondName = new javax.swing.JTextField();
        txtCustomerSecondLastName = new javax.swing.JTextField();
        txtCustomerPhone = new javax.swing.JTextField();
        txtCustomerIdentificationNum = new javax.swing.JTextField();
        txtCustomerAddress = new javax.swing.JTextField();
        buttonListWorkersPanel = new javax.swing.JPanel();
        btnSeeAllCustomers = new javax.swing.JButton();

        setBackground(Colors.PRIMARY_200);
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INFORMACIÓN DEL CLIENTE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 1, 18), Colors.PRIMARY_950)); // NOI18N
        setPreferredSize(new java.awt.Dimension(970, 576));

        buttonsPanel.setBackground(Colors.PRIMARY_200);
        buttonsPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonsPanel.setPreferredSize(new java.awt.Dimension(958, 150));

        btnDeleteCustomer.setBackground(Colors.PRIMARY_400);
        btnDeleteCustomer.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnDeleteCustomer.setForeground(Colors.PRIMARY_950);
        btnDeleteCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconTrash.png"))); // NOI18N
        btnDeleteCustomer.setText("Eliminar");
        btnDeleteCustomer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeleteCustomer.setPreferredSize(new java.awt.Dimension(180, 60));
        btnDeleteCustomer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeleteCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCustomerActionPerformed(evt);
            }
        });

        btnEditCustomer.setBackground(Colors.PRIMARY_400);
        btnEditCustomer.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnEditCustomer.setForeground(Colors.PRIMARY_950);
        btnEditCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconEdit.png"))); // NOI18N
        btnEditCustomer.setText("Editar");
        btnEditCustomer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditCustomer.setPreferredSize(new java.awt.Dimension(180, 60));
        btnEditCustomer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCustomerActionPerformed(evt);
            }
        });

        btnNextWorker.setBackground(Colors.PRIMARY_500);
        btnNextWorker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images32x32/iconNext.png"))); // NOI18N
        btnNextWorker.setPreferredSize(new java.awt.Dimension(38, 38));
        btnNextWorker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextWorkerActionPerformed(evt);
            }
        });

        btnPreviousWorker.setBackground(Colors.PRIMARY_500);
        btnPreviousWorker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images32x32/iconPrevious.png"))); // NOI18N
        btnPreviousWorker.setPreferredSize(new java.awt.Dimension(38, 38));
        btnPreviousWorker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousWorkerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonsPanelLayout = new javax.swing.GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(buttonsPanelLayout);
        buttonsPanelLayout.setHorizontalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPreviousWorker, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(btnDeleteCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(btnEditCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(btnNextWorker, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buttonsPanelLayout.setVerticalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnPreviousWorker, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNextWorker, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonsPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDeleteCustomer, btnEditCustomer});

        information1Panel.setBackground(Colors.PRIMARY_200);
        information1Panel.setPreferredSize(new java.awt.Dimension(476, 300));

        lbsInformation1Panel.setBackground(Colors.PRIMARY_200);
        lbsInformation1Panel.setPreferredSize(new java.awt.Dimension(150, 288));

        lbCustomerFirstName.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbCustomerFirstName.setForeground(Colors.PRIMARY_950);
        lbCustomerFirstName.setText("Primer nombre:");
        lbCustomerFirstName.setPreferredSize(new java.awt.Dimension(138, 30));

        lbCustomerFirstlastName.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbCustomerFirstlastName.setForeground(Colors.PRIMARY_950);
        lbCustomerFirstlastName.setText("Primer apellido:");
        lbCustomerFirstlastName.setPreferredSize(new java.awt.Dimension(138, 30));

        lbCustomerIdentificationType.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbCustomerIdentificationType.setForeground(Colors.PRIMARY_950);
        lbCustomerIdentificationType.setText("Tipo de identificación:");
        lbCustomerIdentificationType.setPreferredSize(new java.awt.Dimension(138, 30));

        lbCustomerBirthdate.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbCustomerBirthdate.setForeground(Colors.PRIMARY_950);
        lbCustomerBirthdate.setText("Edad");
        lbCustomerBirthdate.setPreferredSize(new java.awt.Dimension(138, 30));

        lbCustomerEmail.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbCustomerEmail.setForeground(Colors.PRIMARY_950);
        lbCustomerEmail.setText("Correo electrónico:");
        lbCustomerEmail.setPreferredSize(new java.awt.Dimension(138, 30));

        javax.swing.GroupLayout lbsInformation1PanelLayout = new javax.swing.GroupLayout(lbsInformation1Panel);
        lbsInformation1Panel.setLayout(lbsInformation1PanelLayout);
        lbsInformation1PanelLayout.setHorizontalGroup(
            lbsInformation1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbsInformation1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lbsInformation1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbCustomerIdentificationType, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(lbCustomerFirstName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbCustomerFirstlastName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbCustomerEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbCustomerBirthdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        lbsInformation1PanelLayout.setVerticalGroup(
            lbsInformation1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbsInformation1PanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lbCustomerFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCustomerFirstlastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCustomerIdentificationType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCustomerBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCustomerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dataInformation1Panel.setBackground(Colors.PRIMARY_200);
        dataInformation1Panel.setPreferredSize(new java.awt.Dimension(308, 288));

        txtCustomerFirstName.setEditable(false);
        txtCustomerFirstName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtCustomerFirstName.setPreferredSize(new java.awt.Dimension(296, 30));

        txtCustomerFirstLastName.setEditable(false);
        txtCustomerFirstLastName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtCustomerFirstLastName.setPreferredSize(new java.awt.Dimension(296, 30));

        txtCustomerEmail.setEditable(false);
        txtCustomerEmail.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtCustomerEmail.setPreferredSize(new java.awt.Dimension(296, 30));

        txtCustomerIdentificationType.setEditable(false);
        txtCustomerIdentificationType.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtCustomerIdentificationType.setPreferredSize(new java.awt.Dimension(296, 30));

        txtCustomerBirthdate.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtCustomerBirthdate.setPreferredSize(new java.awt.Dimension(296, 30));

        javax.swing.GroupLayout dataInformation1PanelLayout = new javax.swing.GroupLayout(dataInformation1Panel);
        dataInformation1Panel.setLayout(dataInformation1PanelLayout);
        dataInformation1PanelLayout.setHorizontalGroup(
            dataInformation1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataInformation1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataInformation1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCustomerEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                    .addComponent(txtCustomerFirstLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtCustomerFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtCustomerIdentificationType, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtCustomerBirthdate, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
                .addContainerGap())
        );
        dataInformation1PanelLayout.setVerticalGroup(
            dataInformation1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataInformation1PanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(txtCustomerFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCustomerFirstLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCustomerIdentificationType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCustomerBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(txtCustomerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout information1PanelLayout = new javax.swing.GroupLayout(information1Panel);
        information1Panel.setLayout(information1PanelLayout);
        information1PanelLayout.setHorizontalGroup(
            information1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(information1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbsInformation1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataInformation1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );
        information1PanelLayout.setVerticalGroup(
            information1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(information1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(information1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataInformation1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(lbsInformation1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                .addContainerGap())
        );

        information2Panel.setBackground(Colors.PRIMARY_200);
        information2Panel.setPreferredSize(new java.awt.Dimension(476, 300));

        lbsInformation2Panel.setBackground(Colors.PRIMARY_200);
        lbsInformation2Panel.setPreferredSize(new java.awt.Dimension(150, 288));

        lbCustomerSecondName.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbCustomerSecondName.setForeground(Colors.PRIMARY_950);
        lbCustomerSecondName.setText("Segundo nombre:");
        lbCustomerSecondName.setPreferredSize(new java.awt.Dimension(138, 30));

        lbCustomerSecondLastName.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbCustomerSecondLastName.setForeground(Colors.PRIMARY_950);
        lbCustomerSecondLastName.setText("Segundo apellido:");
        lbCustomerSecondLastName.setPreferredSize(new java.awt.Dimension(138, 30));

        lbCustomerIdentificationNum.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbCustomerIdentificationNum.setForeground(Colors.PRIMARY_950);
        lbCustomerIdentificationNum.setText("Num. de identificación:");
        lbCustomerIdentificationNum.setPreferredSize(new java.awt.Dimension(138, 30));

        lbCustomerPhone.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbCustomerPhone.setForeground(Colors.PRIMARY_950);
        lbCustomerPhone.setText("Teléfono / Celular:");
        lbCustomerPhone.setPreferredSize(new java.awt.Dimension(138, 30));

        lbCustomerAddress.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbCustomerAddress.setForeground(Colors.PRIMARY_950);
        lbCustomerAddress.setText("Dirección:");
        lbCustomerAddress.setPreferredSize(new java.awt.Dimension(138, 30));

        javax.swing.GroupLayout lbsInformation2PanelLayout = new javax.swing.GroupLayout(lbsInformation2Panel);
        lbsInformation2Panel.setLayout(lbsInformation2PanelLayout);
        lbsInformation2PanelLayout.setHorizontalGroup(
            lbsInformation2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbsInformation2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lbsInformation2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCustomerSecondLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCustomerIdentificationNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCustomerPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCustomerAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCustomerSecondName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        lbsInformation2PanelLayout.setVerticalGroup(
            lbsInformation2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbsInformation2PanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lbCustomerSecondName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCustomerSecondLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCustomerIdentificationNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCustomerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dataInformation2Panel.setBackground(Colors.PRIMARY_200);
        dataInformation2Panel.setPreferredSize(new java.awt.Dimension(308, 288));

        txtCustomerSecondName.setEditable(false);
        txtCustomerSecondName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtCustomerSecondName.setPreferredSize(new java.awt.Dimension(296, 30));

        txtCustomerSecondLastName.setEditable(false);
        txtCustomerSecondLastName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtCustomerSecondLastName.setPreferredSize(new java.awt.Dimension(296, 30));

        txtCustomerPhone.setEditable(false);
        txtCustomerPhone.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtCustomerPhone.setPreferredSize(new java.awt.Dimension(296, 30));

        txtCustomerIdentificationNum.setEditable(false);
        txtCustomerIdentificationNum.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtCustomerIdentificationNum.setPreferredSize(new java.awt.Dimension(296, 30));

        txtCustomerAddress.setEditable(false);
        txtCustomerAddress.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtCustomerAddress.setPreferredSize(new java.awt.Dimension(296, 30));

        javax.swing.GroupLayout dataInformation2PanelLayout = new javax.swing.GroupLayout(dataInformation2Panel);
        dataInformation2Panel.setLayout(dataInformation2PanelLayout);
        dataInformation2PanelLayout.setHorizontalGroup(
            dataInformation2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataInformation2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataInformation2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCustomerSecondName, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                    .addComponent(txtCustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtCustomerSecondLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtCustomerIdentificationNum, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtCustomerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        dataInformation2PanelLayout.setVerticalGroup(
            dataInformation2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataInformation2PanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(txtCustomerSecondName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCustomerSecondLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(txtCustomerIdentificationNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCustomerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout information2PanelLayout = new javax.swing.GroupLayout(information2Panel);
        information2Panel.setLayout(information2PanelLayout);
        information2PanelLayout.setHorizontalGroup(
            information2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(information2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbsInformation2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataInformation2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addContainerGap())
        );
        information2PanelLayout.setVerticalGroup(
            information2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(information2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(information2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataInformation2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(lbsInformation2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                .addContainerGap())
        );

        buttonListWorkersPanel.setBackground(Colors.PRIMARY_200);
        buttonListWorkersPanel.setPreferredSize(new java.awt.Dimension(958, 102));

        btnSeeAllCustomers.setBackground(Colors.PRIMARY_400);
        btnSeeAllCustomers.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnSeeAllCustomers.setText("VER COMO LISTADO");
        btnSeeAllCustomers.setPreferredSize(new java.awt.Dimension(180, 60));
        btnSeeAllCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeAllCustomersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonListWorkersPanelLayout = new javax.swing.GroupLayout(buttonListWorkersPanel);
        buttonListWorkersPanel.setLayout(buttonListWorkersPanelLayout);
        buttonListWorkersPanelLayout.setHorizontalGroup(
            buttonListWorkersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonListWorkersPanelLayout.createSequentialGroup()
                .addContainerGap(353, Short.MAX_VALUE)
                .addComponent(btnSeeAllCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(351, Short.MAX_VALUE))
        );
        buttonListWorkersPanelLayout.setVerticalGroup(
            buttonListWorkersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonListWorkersPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSeeAllCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(information1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(information2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
                    .addComponent(buttonListWorkersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(information1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(information2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonListWorkersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextWorkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextWorkerActionPerformed
        if (this.customerIndex < this.CUSTOMER_LIST.size() - 1) {
            this.customerIndex++;
            viewWorkerInformation(customerIndex);
        }
    }//GEN-LAST:event_btnNextWorkerActionPerformed

    private void btnPreviousWorkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousWorkerActionPerformed
        if (this.customerIndex > 0) {
            customerIndex--;
            viewWorkerInformation(customerIndex);
        }
    }//GEN-LAST:event_btnPreviousWorkerActionPerformed

    private void btnDeleteCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCustomerActionPerformed
        int userAnswer = JPaneMessage.MessageOptionDialog(this, 
               "¿Está seguro que desea eliminar este cliente?", 
               "Eliminar cliente", new String[]{"Eliminar", "Volver"}, 2);
        if(userAnswer == 1){
            return;
        }
        try {
            Customer customer = this.CUSTOMER_LIST.get(customerIndex);
            customer.setIsDelete(true);
            
            REQUEST_CUSTOMER.editCustomer(this.CUSTOMER_LIST.get(customerIndex));
            this.CUSTOMER_LIST.remove(customerIndex);
            JPaneMessage.messageDialog(this, "El cliente ha sido eliminado exitosamente", "Eliminación exitosa", 1);

            if (this.CUSTOMER_LIST.isEmpty()) {
                PeopleManagementView workersFirstView = new PeopleManagementView(this.PRINCIPALJFRAME);
                this.PRINCIPALJFRAME.replacePanel(workersFirstView);
                return;
            }

            if (customerIndex == (this.CUSTOMER_LIST.size())) {
                customerIndex--;
            }

            viewWorkerInformation(customerIndex);
            

        } catch (Exception ex) {
            Logger.getLogger(WorkersInformationView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteCustomerActionPerformed

    private void btnEditCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditCustomerActionPerformed
        CustomerEditInformationView customerEditInformation = new CustomerEditInformationView(this.CUSTOMER_LIST.get(customerIndex), this.PRINCIPALJFRAME);
        customerEditInformation.setVisible(true);
        this.PRINCIPALJFRAME.setVisible(false);
    }//GEN-LAST:event_btnEditCustomerActionPerformed

    private void btnSeeAllCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeAllCustomersActionPerformed
        List<Customer> customerList = REQUEST_CUSTOMER.getNoDeleteCustomer();

        if (!customerList.isEmpty()) {
            CustomerListView customerListView = new CustomerListView(PRINCIPALJFRAME, customerList);
            this.PRINCIPALJFRAME.replacePanel(customerListView);
        } else {
            JPaneMessage.messageDialog(this, "No tiene clientes registrados", "Sin registros", 0);
            PeopleManagementView workersFirstView = new PeopleManagementView(this.PRINCIPALJFRAME);
            this.PRINCIPALJFRAME.replacePanel(workersFirstView);
        }
    }//GEN-LAST:event_btnSeeAllCustomersActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteCustomer;
    private javax.swing.JButton btnEditCustomer;
    private javax.swing.JButton btnNextWorker;
    private javax.swing.JButton btnPreviousWorker;
    private javax.swing.JButton btnSeeAllCustomers;
    private javax.swing.JPanel buttonListWorkersPanel;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JPanel dataInformation1Panel;
    private javax.swing.JPanel dataInformation2Panel;
    private javax.swing.JPanel information1Panel;
    private javax.swing.JPanel information2Panel;
    private javax.swing.JLabel lbCustomerAddress;
    private javax.swing.JLabel lbCustomerBirthdate;
    private javax.swing.JLabel lbCustomerEmail;
    private javax.swing.JLabel lbCustomerFirstName;
    private javax.swing.JLabel lbCustomerFirstlastName;
    private javax.swing.JLabel lbCustomerIdentificationNum;
    private javax.swing.JLabel lbCustomerIdentificationType;
    private javax.swing.JLabel lbCustomerPhone;
    private javax.swing.JLabel lbCustomerSecondLastName;
    private javax.swing.JLabel lbCustomerSecondName;
    private javax.swing.JPanel lbsInformation1Panel;
    private javax.swing.JPanel lbsInformation2Panel;
    private javax.swing.JTextField txtCustomerAddress;
    private javax.swing.JTextField txtCustomerBirthdate;
    private javax.swing.JTextField txtCustomerEmail;
    private javax.swing.JTextField txtCustomerFirstLastName;
    private javax.swing.JTextField txtCustomerFirstName;
    private javax.swing.JTextField txtCustomerIdentificationNum;
    private javax.swing.JTextField txtCustomerIdentificationType;
    private javax.swing.JTextField txtCustomerPhone;
    private javax.swing.JTextField txtCustomerSecondLastName;
    private javax.swing.JTextField txtCustomerSecondName;
    // End of variables declaration//GEN-END:variables
}
