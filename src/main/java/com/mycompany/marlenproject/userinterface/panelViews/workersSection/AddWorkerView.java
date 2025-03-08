/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.marlenproject.userinterface.panelViews.workersSection;

import com.mycompany.marlenproject.logic.Person;
import com.mycompany.marlenproject.logic.Worker;
import com.mycompany.marlenproject.logic.request.requestPerson;
import com.mycompany.marlenproject.logic.request.requestWorker;
import com.mycompany.marlenproject.persistence.exceptions.PreexistingEntityException;
import com.mycompany.marlenproject.utils.colors.Colors;
import com.mycompany.marlenproject.data.forms.worker.dataFormsWorker;
import com.mycompany.marlenproject.data.forms.person.dataFormsPerson;
import com.mycompany.marlenproject.utils.fields.InputValidator;
import com.mycompany.marlenproject.utils.message.JPaneMessage;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddWorkerView extends javax.swing.JPanel {

    private final requestPerson NEW_REQUEST_PERSON = new requestPerson();
    private final requestWorker NEW_REQUEST_WORKER = new requestWorker();

    public AddWorkerView() {
        initComponents();
    }

    private boolean changeColorRequiredField() {
        String personFirstName = InputValidator.removeStringBlanks(txtFirstName.getText());
        String personFirstLastName = InputValidator.removeStringBlanks(txtFirstLastName.getText());
        String personIdentificationType = sltIdentificationType.getSelectedItem().toString();
        String personIdentificationNumber = InputValidator.removeStringBlanks(txtIdentificationNum.getText());
        //Worker information
        String bloodType = sltBloodType.getSelectedItem().toString();
        String bloodTypeCmplt = sltBloodTypeCmplt.getSelectedItem().toString();
        String healthEntity = sltEPS.getSelectedItem().toString();
        String position = sltPosition.getSelectedItem().toString();

        if (personFirstName.isBlank()) {
            txtFirstName.setBackground(Colors.IncorrectColorFields());
            JPaneMessage.messageDialog(this, "Debe tener un primer nombre.", "Campo requerido", 1);
            return false;
        }
        if (!InputValidator.checkStringField(personFirstName)) {
            txtFirstName.setBackground(Colors.IncorrectColorFields());
            JPaneMessage.incorrectTxtField(this, null, null, null);
            return false;
        }
        
        if (personFirstLastName.isBlank()) {
            txtFirstLastName.setBackground(Colors.IncorrectColorFields());
            JPaneMessage.messageDialog(this, "Debe tener un primer apellido.", "Campo requerido", 1);
            return false;
        }
        if (!InputValidator.checkStringField(personFirstLastName)) {
            txtFirstLastName.setBackground(Colors.IncorrectColorFields());
            JPaneMessage.incorrectTxtField(this, null, null, null);
            return false;
        }
        
        if (!InputValidator.checkComboBox(personIdentificationType)) {
            sltIdentificationType.setBackground(Colors.IncorrectColorFields());
            JPaneMessage.noSelectedBox(this, "Debe escoger un tipo de identificación.", null);
            return false;
        }
        
        if (personIdentificationNumber.isBlank()) {
            txtIdentificationNum.setBackground(Colors.IncorrectColorFields());
            JPaneMessage.messageDialog(this, "Debe tener un número de identificación.", "Campo requerido", 1);
            return false;
        }
        if (!InputValidator.checkIdentification(sltIdentificationType.getSelectedIndex(),personIdentificationNumber)) {
            txtIdentificationNum.setBackground(Colors.IncorrectColorFields());
            JPaneMessage.incorrectIdentification(this, sltIdentificationType.getSelectedIndex(),null, null, null);
            return false;
        }
        
        if (!InputValidator.checkComboBox(bloodType)) {
            sltBloodType.setBackground(Colors.IncorrectColorFields());
            JPaneMessage.noSelectedBox(this, "Debe escoger un grupo AOB.", null);
            return false;
        }
        if (!InputValidator.checkComboBox(bloodTypeCmplt)) {
            sltBloodTypeCmplt.setBackground(Colors.IncorrectColorFields());
            JPaneMessage.noSelectedBox(this, "Debe escoger un factor Rh.", null);
            return false;
        }
        if (!InputValidator.checkComboBox(healthEntity)) {
            sltEPS.setBackground(Colors.IncorrectColorFields());
            JPaneMessage.noSelectedBox(this, "Debe escoger una entidad de salud.", null);
            return false;
        }
        if (null == dateBirthdate.getDate()) {
            dateBirthdate.setBackground(Colors.IncorrectColorFields());
            JPaneMessage.messageDialog(this, "Debe seleccionar una fecha.", "Campo requerido", 1);
            return false;
        }
        if (null == dateVinculation.getDate()) {
            dateVinculation.setBackground(Colors.IncorrectColorFields());
            JPaneMessage.messageDialog(this, "Debe seleccionar una fecha.", "Campo requerido", 1);
            return false;
        }
        if (!InputValidator.checkComboBox(position)) {
            sltPosition.setBackground(Colors.IncorrectColorFields());
            JPaneMessage.noSelectedBox(this, "Debe escoger una posición.", null);
            return false;
        }

        return true;
    }

    private boolean changeColorNoRequiredField() {
        String personSecondName = InputValidator.removeStringBlanks(txtSecondName.getText());
        String personSecondLastName = InputValidator.removeStringBlanks(txtSecondLastName.getText());

        if (!InputValidator.checkStringField(personSecondName) && !personSecondName.equalsIgnoreCase("")) {
            txtSecondName.setBackground(Colors.IncorrectColorFields());
            JPaneMessage.incorrectTxtField(this, null, null, null);
            return false;
        }

        if (!InputValidator.checkStringField(personSecondLastName) && !personSecondLastName.equalsIgnoreCase("")) {
            txtSecondLastName.setBackground(Colors.IncorrectColorFields());
            JPaneMessage.incorrectTxtField(this, null, null, null);
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
        sltBloodType.setSelectedIndex(0);
        sltBloodTypeCmplt.setSelectedIndex(0);
        sltEPS.setSelectedIndex(0);
        dateBirthdate.setDate(null);
        dateVinculation.setDate(null);
        sltPosition.setSelectedIndex(0);
        
        txtFirstName.setBackground(Colors.NormalColorFields());
        txtSecondName.setBackground(Colors.NormalColorFields());
        txtFirstLastName.setBackground(Colors.NormalColorFields());
        txtSecondLastName.setBackground(Colors.NormalColorFields());
        sltIdentificationType.setBackground(Colors.NormalColorFields());
        txtIdentificationNum.setBackground(Colors.NormalColorFields());
        sltBloodType.setBackground(Colors.NormalColorFields());
        sltBloodTypeCmplt.setBackground(Colors.NormalColorFields());
        sltEPS.setBackground(Colors.NormalColorFields());
        dateBirthdate.setBackground(Colors.NormalColorFields());
        dateVinculation.setBackground(Colors.NormalColorFields());
        sltPosition.setBackground(Colors.NormalColorFields());
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

        setBackground(Colors.PRIMARY_200);
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "AGREGAR NUEVO TRABAJADOR", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 1, 18), Colors.PRIMARY_950)); // NOI18N
        setPreferredSize(new java.awt.Dimension(970, 576));

        buttonsPanel.setBackground(Colors.PRIMARY_200);
        buttonsPanel.setPreferredSize(new java.awt.Dimension(958, 208));

        btnCleanFields.setBackground(Colors.PRIMARY_400);
        btnCleanFields.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnCleanFields.setForeground(Colors.PRIMARY_950);
        btnCleanFields.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconDelete.png"))); // NOI18N
        btnCleanFields.setText("Limpiar campos");
        btnCleanFields.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCleanFields.setPreferredSize(new java.awt.Dimension(180, 60));
        btnCleanFields.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCleanFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanFieldsActionPerformed(evt);
            }
        });

        btnSaveWorker.setBackground(Colors.PRIMARY_400);
        btnSaveWorker.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnSaveWorker.setForeground(Colors.PRIMARY_950);
        btnSaveWorker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconSave.png"))); // NOI18N
        btnSaveWorker.setText("Guardar");
        btnSaveWorker.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSaveWorker.setPreferredSize(new java.awt.Dimension(180, 60));
        btnSaveWorker.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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
                    .addComponent(btnCleanFields, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveWorker, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        information1Panel.setBackground(Colors.PRIMARY_200);
        information1Panel.setPreferredSize(new java.awt.Dimension(476, 350));

        lbsInformation1Panel.setBackground(Colors.PRIMARY_200);
        lbsInformation1Panel.setPreferredSize(new java.awt.Dimension(150, 338));

        lbFirstName.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbFirstName.setForeground(Colors.PRIMARY_950);
        lbFirstName.setText("Primer nombre:");
        lbFirstName.setPreferredSize(new java.awt.Dimension(138, 30));

        lbFirstlastName.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbFirstlastName.setForeground(Colors.PRIMARY_950);
        lbFirstlastName.setText("Primer apellido:");
        lbFirstlastName.setPreferredSize(new java.awt.Dimension(138, 30));

        lbIdentificationType.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbIdentificationType.setForeground(Colors.PRIMARY_950);
        lbIdentificationType.setText("Tipo de documento:");
        lbIdentificationType.setPreferredSize(new java.awt.Dimension(138, 30));

        lbBloodType.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbBloodType.setForeground(Colors.PRIMARY_950);
        lbBloodType.setText("Tipo de sangre:");
        lbBloodType.setPreferredSize(new java.awt.Dimension(138, 30));

        lbAge.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbAge.setForeground(Colors.PRIMARY_950);
        lbAge.setText("Fecha de nacimiento:");
        lbAge.setPreferredSize(new java.awt.Dimension(138, 30));

        lbPosition.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbPosition.setForeground(Colors.PRIMARY_950);
        lbPosition.setText("Cargo:");
        lbPosition.setPreferredSize(new java.awt.Dimension(138, 30));

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
                .addComponent(lbBloodType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(lbAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dataInformation1Panel.setBackground(Colors.PRIMARY_200);
        dataInformation1Panel.setPreferredSize(new java.awt.Dimension(308, 338));

        txtFirstName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtFirstName.setPreferredSize(new java.awt.Dimension(296, 30));
        txtFirstName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFirstNameFocusGained(evt);
            }
        });

        txtFirstLastName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtFirstLastName.setPreferredSize(new java.awt.Dimension(296, 30));
        txtFirstLastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFirstLastNameFocusGained(evt);
            }
        });

        sltIdentificationType.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        sltIdentificationType.setModel(new javax.swing.DefaultComboBoxModel<>(dataFormsPerson.IDENTIFICATION_TYPE));
        sltIdentificationType.setPreferredSize(new java.awt.Dimension(296, 30));
        sltIdentificationType.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sltIdentificationTypeFocusGained(evt);
            }
        });

        sltPosition.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        sltPosition.setModel(new javax.swing.DefaultComboBoxModel<>(dataFormsWorker.JOB_TITLE));
        sltPosition.setPreferredSize(new java.awt.Dimension(296, 30));
        sltPosition.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sltPositionFocusGained(evt);
            }
        });

        sltBloodType.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        sltBloodType.setModel(new javax.swing.DefaultComboBoxModel<>(dataFormsWorker.BLOOD_GROUP));
        sltBloodType.setPreferredSize(new java.awt.Dimension(136, 30));
        sltBloodType.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sltBloodTypeFocusGained(evt);
            }
        });

        sltBloodTypeCmplt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        sltBloodTypeCmplt.setModel(new javax.swing.DefaultComboBoxModel<>(dataFormsWorker.BLOOD_GROUP_RHD));
        sltBloodTypeCmplt.setPreferredSize(new java.awt.Dimension(136, 30));
        sltBloodTypeCmplt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sltBloodTypeCmpltFocusGained(evt);
            }
        });

        dateBirthdate.setDateFormatString("dd/MM/yyyy");
        dateBirthdate.setMaxSelectableDate(new Date());
        dateBirthdate.setPreferredSize(new java.awt.Dimension(296, 30));
        this.dateBirthdate.getDateEditor().getUiComponent().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(evt.getClickCount()==1){
                    dateBirthdateMouseClicked();
                }
            }
        });

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
                .addContainerGap(7, Short.MAX_VALUE))
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
                    .addComponent(dataInformation1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                    .addComponent(lbsInformation1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
                .addContainerGap())
        );

        information2Panel.setBackground(Colors.PRIMARY_200);
        information2Panel.setPreferredSize(new java.awt.Dimension(476, 350));

        lbsInformation2Panel.setBackground(Colors.PRIMARY_200);
        lbsInformation2Panel.setPreferredSize(new java.awt.Dimension(150, 338));

        lbSecondName.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbSecondName.setForeground(Colors.PRIMARY_950);
        lbSecondName.setText("Segundo nombre:");
        lbSecondName.setPreferredSize(new java.awt.Dimension(138, 30));

        lbSecondLastName.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbSecondLastName.setForeground(Colors.PRIMARY_950);
        lbSecondLastName.setText("Segundo apellido:");
        lbSecondLastName.setPreferredSize(new java.awt.Dimension(138, 30));

        lbIdentificationNum.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbIdentificationNum.setForeground(Colors.PRIMARY_950);
        lbIdentificationNum.setText("Num. de documento:");
        lbIdentificationNum.setPreferredSize(new java.awt.Dimension(138, 30));

        lbEps.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbEps.setForeground(Colors.PRIMARY_950);
        lbEps.setText("Entidad de salud:");
        lbEps.setPreferredSize(new java.awt.Dimension(138, 30));

        lbDateVinculation.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbDateVinculation.setForeground(Colors.PRIMARY_950);
        lbDateVinculation.setText("Fecha vinculación:");
        lbDateVinculation.setPreferredSize(new java.awt.Dimension(138, 30));

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
                .addContainerGap(47, Short.MAX_VALUE))
        );

        dataInformation2Panel.setBackground(Colors.PRIMARY_200);
        dataInformation2Panel.setPreferredSize(new java.awt.Dimension(308, 338));

        txtSecondName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtSecondName.setPreferredSize(new java.awt.Dimension(296, 30));
        txtSecondName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSecondNameFocusGained(evt);
            }
        });

        txtSecondLastName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtSecondLastName.setPreferredSize(new java.awt.Dimension(296, 30));
        txtSecondLastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSecondLastNameFocusGained(evt);
            }
        });

        dateVinculation.setDateFormatString("dd/MM/yyyy");
        dateVinculation.setPreferredSize(new java.awt.Dimension(296, 30));
        this.dateVinculation.getDateEditor().getUiComponent().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(evt.getClickCount()==1){
                    dateVinculationMouseClicked();
                }
            }
        });

        txtIdentificationNum.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtIdentificationNum.setPreferredSize(new java.awt.Dimension(296, 30));
        txtIdentificationNum.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIdentificationNumFocusGained(evt);
            }
        });

        sltEPS.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        sltEPS.setModel(new javax.swing.DefaultComboBoxModel<>(dataFormsWorker.HEALTH_ENTITY));
        sltEPS.setPreferredSize(new java.awt.Dimension(296, 30));
        sltEPS.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sltEPSFocusGained(evt);
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
                    .addComponent(dataInformation2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                    .addComponent(lbsInformation2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
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
                    .addComponent(information1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(information2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCleanFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanFieldsActionPerformed
        clearFields();
    }//GEN-LAST:event_btnCleanFieldsActionPerformed

    private void btnSaveWorkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveWorkerActionPerformed

        if (changeColorRequiredField() && changeColorNoRequiredField()) {
            String personFirstName = InputValidator.removeStringBlanks(txtFirstName.getText());
            String personSecondName = InputValidator.removeStringBlanks(txtSecondName.getText());//
            String personFirstLastName = InputValidator.removeStringBlanks(txtFirstLastName.getText());
            String personSecondLastName = InputValidator.removeStringBlanks(txtSecondLastName.getText());//
            String personIdentificationType = sltIdentificationType.getSelectedItem().toString();
            String personIdentificationNumber = InputValidator.removeStringBlanks(txtIdentificationNum.getText());
            Date personBirthdate = dateBirthdate.getDate();
            
            //Worker information
            String bloodType = sltBloodType.getSelectedItem().toString();
            String bloodTypeCmplt = sltBloodTypeCmplt.getSelectedItem().toString();
            String healthEntity = sltEPS.getSelectedItem().toString();
            Date dayLink = dateVinculation.getDate();
            String position = sltPosition.getSelectedItem().toString();
            boolean state = true;
            boolean is_delete = false;

            Person person = new Person(personFirstName, personSecondName, personFirstLastName, personSecondLastName, personIdentificationType, personIdentificationNumber, personBirthdate);
            Worker worker = new Worker(bloodType.concat(bloodTypeCmplt), healthEntity, dayLink, position, state, is_delete, person);
            
            try {
                
                
                Worker existingWorker = NEW_REQUEST_WORKER.findWorkerByDNI(personIdentificationNumber);
                Person existingPerson = NEW_REQUEST_PERSON.getPersonByDNI(personIdentificationNumber);
                
                if(existingPerson == null){
                    NEW_REQUEST_PERSON.savePerson(person);
                    NEW_REQUEST_WORKER.saveWorker(worker);
                }else if(existingWorker != null && existingWorker.isIsDelete()) {
                    worker.setWorkerId(existingWorker.getWorkerId());
                    NEW_REQUEST_PERSON.editPerson(person);
                    NEW_REQUEST_WORKER.editWorker(worker);
                } else if (existingWorker != null && !existingWorker.isIsDelete()) {
                    String Message = "          Esta cédula YA PERTENECE A UN TRABAJADOR.";
                    String suggest = "\n\n Por favor revise la lista de trabajadores y actualice los datos.";
                    JPaneMessage.messageDialog(this, Message.concat(suggest) , "Identificación duplicada", 0);
                    return;
                }else{
                    NEW_REQUEST_PERSON.editPerson(person);
                    NEW_REQUEST_WORKER.saveWorker(worker);
                }
                
                JPaneMessage.messageDialog(this, "El trabajador ha sido agregado correctamente", "Information", 1);
                clearFields();
            } catch (PreexistingEntityException ex) {
                JPaneMessage.messageDialog(this, "El numero de identificación ya está asociado a alguien.", "Identificación duplicada", 0);
                txtIdentificationNum.setBackground(Colors.IncorrectColorFields());
            } catch (Exception ex) {
                Logger.getLogger(AddWorkerView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSaveWorkerActionPerformed

    private void sltBloodTypeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sltBloodTypeFocusGained
        sltBloodType.setBackground(Colors.NormalColorFields());
    }//GEN-LAST:event_sltBloodTypeFocusGained

    private void txtFirstNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFirstNameFocusGained
        txtFirstName.setBackground(Colors.NormalColorFields());
    }//GEN-LAST:event_txtFirstNameFocusGained

    private void txtFirstLastNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFirstLastNameFocusGained
        txtFirstLastName.setBackground(Colors.NormalColorFields());
    }//GEN-LAST:event_txtFirstLastNameFocusGained

    private void sltIdentificationTypeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sltIdentificationTypeFocusGained
        sltIdentificationType.setBackground(Colors.NormalColorFields());
    }//GEN-LAST:event_sltIdentificationTypeFocusGained

    private void sltBloodTypeCmpltFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sltBloodTypeCmpltFocusGained
        sltBloodTypeCmplt.setBackground(Colors.NormalColorFields());
    }//GEN-LAST:event_sltBloodTypeCmpltFocusGained

    private void sltPositionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sltPositionFocusGained
        sltPosition.setBackground(Colors.NormalColorFields());
    }//GEN-LAST:event_sltPositionFocusGained

    private void txtSecondNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSecondNameFocusGained
        txtSecondName.setBackground(Colors.NormalColorFields());
    }//GEN-LAST:event_txtSecondNameFocusGained

    private void txtSecondLastNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSecondLastNameFocusGained
        txtSecondLastName.setBackground(Colors.NormalColorFields());
    }//GEN-LAST:event_txtSecondLastNameFocusGained

    private void txtIdentificationNumFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdentificationNumFocusGained
        txtIdentificationNum.setBackground(Colors.NormalColorFields());
    }//GEN-LAST:event_txtIdentificationNumFocusGained

    private void sltEPSFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sltEPSFocusGained
        sltEPS.setBackground(Colors.NormalColorFields());
    }//GEN-LAST:event_sltEPSFocusGained

    private void dateBirthdateMouseClicked() { 
        dateBirthdate.setBackground(Colors.NormalColorFields());
    }
    
    private void dateVinculationMouseClicked() { 
        dateVinculation.setBackground(Colors.NormalColorFields());
    }

    
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
