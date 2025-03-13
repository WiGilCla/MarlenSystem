/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.marlenproject.userinterface.panelViews.workersSection;

import com.mycompany.marlenproject.userinterface.PeopleManagementView;
import com.mycompany.marlenproject.utils.fields.InputValidator;
import com.mycompany.marlenproject.logic.Worker;
import com.mycompany.marlenproject.logic.request.requestWorker;
import com.mycompany.marlenproject.userinterface.AdminHome;
import com.mycompany.marlenproject.utils.date.DateFunctions;
import com.mycompany.marlenproject.utils.message.JPaneMessage;
import com.mycompany.marlenproject.utils.colors.Colors;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WorkersInformationView extends javax.swing.JPanel {

    private int workerObserved = 0;
    private final AdminHome PRINCIPALJFRAME;
    private final List<Worker> WORKER_LIST;
    private final requestWorker REQUEST_WORKER = new requestWorker();

    private void viewWorkerInformation(int index) {
        Worker worker = this.WORKER_LIST.get(index);
        
        txtFirstName.setText(worker.getPerson().getFirstName());
        txtSecondName.setText(worker.getPerson().getSecondName());
        txtBloodType.setText(worker.getBloodType());
        txtEps.setText(worker.getHealthEntity());
        txtPosition.setText(worker.getPosition());
        lbWorkerState.setText((worker.isIsActive()) ? "Activo" : "Inactivo");
        txtSecondLastName.setText(worker.getPerson().getSecondLastName());
        txtIdentificationType.setText(worker.getPerson().getIdentificationType());
        txtFirstLastName.setText(worker.getPerson().getFirstLastName());
        txtDateVinculation.setText(DateFunctions.dateFormatDD_MM_YY(worker.getDayLink()));
        txtIdentificationNum.setText(String.valueOf(worker.getPerson().getIdentificationNumber()));
        txtAge.setText(String.valueOf(InputValidator.timeElapsed(worker.getPerson().getBirthdate(), new Date())));
    }

    public WorkersInformationView(AdminHome principalJFrame, List<Worker> listWorker, int index) {
        this.WORKER_LIST = listWorker;
        this.workerObserved = index;
        this.PRINCIPALJFRAME = principalJFrame;
        initComponents();
        viewWorkerInformation(workerObserved);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonsPanel = new javax.swing.JPanel();
        btnDeleteWorker = new javax.swing.JButton();
        btnEditWorker = new javax.swing.JButton();
        btnNextWorker = new javax.swing.JButton();
        btnPreviousWorker = new javax.swing.JButton();
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
        txtBloodType = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        txtIdentificationType = new javax.swing.JTextField();
        txtPosition = new javax.swing.JTextField();
        information2Panel = new javax.swing.JPanel();
        lbsInformation2Panel = new javax.swing.JPanel();
        lbSecondName = new javax.swing.JLabel();
        lbSecondLastName = new javax.swing.JLabel();
        lbIdentificationNum = new javax.swing.JLabel();
        lbEps = new javax.swing.JLabel();
        lbDateVinculation = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        dataInformation2Panel = new javax.swing.JPanel();
        txtSecondName = new javax.swing.JTextField();
        txtSecondLastName = new javax.swing.JTextField();
        txtEps = new javax.swing.JTextField();
        txtIdentificationNum = new javax.swing.JTextField();
        txtDateVinculation = new javax.swing.JTextField();
        lbWorkerState = new javax.swing.JLabel();
        buttonListWorkersPanel = new javax.swing.JPanel();
        btnAllWorkerList = new javax.swing.JButton();

        setBackground(Colors.PRIMARY_200);
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INFORMACIÓN DEL TRABAJADOR", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 1, 18), Colors.PRIMARY_950)); // NOI18N
        setPreferredSize(new java.awt.Dimension(970, 576));

        buttonsPanel.setBackground(Colors.PRIMARY_200);
        buttonsPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonsPanel.setPreferredSize(new java.awt.Dimension(958, 150));

        btnDeleteWorker.setBackground(Colors.PRIMARY_400);
        btnDeleteWorker.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnDeleteWorker.setForeground(Colors.PRIMARY_950);
        btnDeleteWorker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconTrash.png"))); // NOI18N
        btnDeleteWorker.setText("Eliminar");
        btnDeleteWorker.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeleteWorker.setPreferredSize(new java.awt.Dimension(180, 60));
        btnDeleteWorker.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeleteWorker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteWorkerActionPerformed(evt);
            }
        });

        btnEditWorker.setBackground(Colors.PRIMARY_400);
        btnEditWorker.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnEditWorker.setForeground(Colors.PRIMARY_950);
        btnEditWorker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconEdit.png"))); // NOI18N
        btnEditWorker.setText("Editar");
        btnEditWorker.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditWorker.setPreferredSize(new java.awt.Dimension(180, 60));
        btnEditWorker.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditWorker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditWorkerActionPerformed(evt);
            }
        });

        btnNextWorker.setBackground(Colors.PRIMARY_500);
        btnNextWorker.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnNextWorker.setForeground(Colors.PRIMARY_950);
        btnNextWorker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images32x32/iconNext.png"))); // NOI18N
        btnNextWorker.setPreferredSize(new java.awt.Dimension(40, 40));
        btnNextWorker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextWorkerActionPerformed(evt);
            }
        });

        btnPreviousWorker.setBackground(Colors.PRIMARY_500);
        btnPreviousWorker.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnPreviousWorker.setForeground(Colors.PRIMARY_950);
        btnPreviousWorker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images32x32/iconPrevious.png"))); // NOI18N
        btnPreviousWorker.setPreferredSize(new java.awt.Dimension(40, 40));
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
                .addGap(93, 93, 93)
                .addComponent(btnDeleteWorker, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118)
                .addComponent(btnEditWorker, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114)
                .addComponent(btnNextWorker, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonsPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnNextWorker, btnPreviousWorker});

        buttonsPanelLayout.setVerticalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnPreviousWorker, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteWorker, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditWorker, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNextWorker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        buttonsPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnNextWorker, btnPreviousWorker});

        information1Panel.setBackground(Colors.PRIMARY_200);
        information1Panel.setPreferredSize(new java.awt.Dimension(476, 300));

        lbsInformation1Panel.setBackground(Colors.PRIMARY_200);
        lbsInformation1Panel.setPreferredSize(new java.awt.Dimension(150, 288));

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
        lbAge.setText("Edad:");
        lbAge.setPreferredSize(new java.awt.Dimension(138, 30));

        lbPosition.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lbPosition.setForeground(Colors.PRIMARY_950);
        lbPosition.setText("Cargo:");
        lbPosition.setPreferredSize(new java.awt.Dimension(138, 30));

        javax.swing.GroupLayout lbsInformation1PanelLayout = new javax.swing.GroupLayout(lbsInformation1Panel);
        lbsInformation1Panel.setLayout(lbsInformation1PanelLayout);
        lbsInformation1PanelLayout.setHorizontalGroup(
            lbsInformation1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbsInformation1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lbsInformation1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbIdentificationType, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbFirstName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbFirstlastName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbAge, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbBloodType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbPosition, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        dataInformation1Panel.setBackground(Colors.PRIMARY_200);
        dataInformation1Panel.setPreferredSize(new java.awt.Dimension(308, 288));

        txtFirstName.setEditable(false);
        txtFirstName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtFirstName.setPreferredSize(new java.awt.Dimension(296, 30));

        txtFirstLastName.setEditable(false);
        txtFirstLastName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtFirstLastName.setPreferredSize(new java.awt.Dimension(296, 30));

        txtBloodType.setEditable(false);
        txtBloodType.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtBloodType.setPreferredSize(new java.awt.Dimension(296, 30));

        txtAge.setEditable(false);
        txtAge.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtAge.setPreferredSize(new java.awt.Dimension(296, 30));

        txtIdentificationType.setEditable(false);
        txtIdentificationType.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtIdentificationType.setPreferredSize(new java.awt.Dimension(296, 30));

        txtPosition.setEditable(false);
        txtPosition.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtPosition.setPreferredSize(new java.awt.Dimension(296, 30));

        javax.swing.GroupLayout dataInformation1PanelLayout = new javax.swing.GroupLayout(dataInformation1Panel);
        dataInformation1Panel.setLayout(dataInformation1PanelLayout);
        dataInformation1PanelLayout.setHorizontalGroup(
            dataInformation1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataInformation1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataInformation1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtFirstLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtBloodType, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtIdentificationType, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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
                .addComponent(txtIdentificationType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(txtBloodType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
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
                    .addComponent(dataInformation1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbsInformation1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        information2Panel.setBackground(Colors.PRIMARY_200);
        information2Panel.setPreferredSize(new java.awt.Dimension(476, 300));

        lbsInformation2Panel.setBackground(Colors.PRIMARY_200);
        lbsInformation2Panel.setPreferredSize(new java.awt.Dimension(150, 288));

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

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jLabel1.setForeground(Colors.PRIMARY_950);
        jLabel1.setText("Estado del trabajador:");
        jLabel1.setPreferredSize(new java.awt.Dimension(138, 30));

        javax.swing.GroupLayout lbsInformation2PanelLayout = new javax.swing.GroupLayout(lbsInformation2Panel);
        lbsInformation2Panel.setLayout(lbsInformation2PanelLayout);
        lbsInformation2PanelLayout.setHorizontalGroup(
            lbsInformation2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbsInformation2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lbsInformation2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSecondLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbIdentificationNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbEps, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbDateVinculation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSecondName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(lbsInformation2PanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        lbsInformation2PanelLayout.setVerticalGroup(
            lbsInformation2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lbsInformation2PanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lbSecondName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbSecondLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbIdentificationNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbEps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbDateVinculation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        dataInformation2Panel.setBackground(Colors.PRIMARY_200);
        dataInformation2Panel.setPreferredSize(new java.awt.Dimension(308, 288));

        txtSecondName.setEditable(false);
        txtSecondName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtSecondName.setPreferredSize(new java.awt.Dimension(296, 30));

        txtSecondLastName.setEditable(false);
        txtSecondLastName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtSecondLastName.setPreferredSize(new java.awt.Dimension(296, 30));

        txtEps.setEditable(false);
        txtEps.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtEps.setPreferredSize(new java.awt.Dimension(296, 30));

        txtIdentificationNum.setEditable(false);
        txtIdentificationNum.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtIdentificationNum.setPreferredSize(new java.awt.Dimension(296, 30));

        txtDateVinculation.setEditable(false);
        txtDateVinculation.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtDateVinculation.setPreferredSize(new java.awt.Dimension(296, 30));

        lbWorkerState.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbWorkerState.setForeground(Colors.PRIMARY_950);
        lbWorkerState.setText("jLabel2");
        lbWorkerState.setPreferredSize(new java.awt.Dimension(41, 30));

        javax.swing.GroupLayout dataInformation2PanelLayout = new javax.swing.GroupLayout(dataInformation2Panel);
        dataInformation2Panel.setLayout(dataInformation2PanelLayout);
        dataInformation2PanelLayout.setHorizontalGroup(
            dataInformation2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataInformation2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataInformation2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSecondName, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(txtEps, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtSecondLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtIdentificationNum, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtDateVinculation, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(dataInformation2PanelLayout.createSequentialGroup()
                        .addComponent(lbWorkerState, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addComponent(txtEps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDateVinculation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbWorkerState, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout information2PanelLayout = new javax.swing.GroupLayout(information2Panel);
        information2Panel.setLayout(information2PanelLayout);
        information2PanelLayout.setHorizontalGroup(
            information2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(information2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbsInformation2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataInformation2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );
        information2PanelLayout.setVerticalGroup(
            information2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(information2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(information2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataInformation2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbsInformation2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        buttonListWorkersPanel.setBackground(Colors.PRIMARY_200);
        buttonListWorkersPanel.setPreferredSize(new java.awt.Dimension(958, 102));

        btnAllWorkerList.setBackground(Colors.PRIMARY_400);
        btnAllWorkerList.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnAllWorkerList.setForeground(Colors.PRIMARY_950);
        btnAllWorkerList.setText("VER COMO LISTADO");
        btnAllWorkerList.setPreferredSize(new java.awt.Dimension(180, 60));
        btnAllWorkerList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllWorkerListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonListWorkersPanelLayout = new javax.swing.GroupLayout(buttonListWorkersPanel);
        buttonListWorkersPanel.setLayout(buttonListWorkersPanelLayout);
        buttonListWorkersPanelLayout.setHorizontalGroup(
            buttonListWorkersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonListWorkersPanelLayout.createSequentialGroup()
                .addGap(343, 343, 343)
                .addComponent(btnAllWorkerList, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addGap(362, 362, 362))
        );
        buttonListWorkersPanelLayout.setVerticalGroup(
            buttonListWorkersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonListWorkersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAllWorkerList, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonListWorkersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(information1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(information2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
                    .addComponent(buttonsPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(information2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(information1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonListWorkersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextWorkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextWorkerActionPerformed
        if (workerObserved < this.WORKER_LIST.size() - 1) {
            workerObserved++;
            viewWorkerInformation(workerObserved);
        }
    }//GEN-LAST:event_btnNextWorkerActionPerformed

    private void btnPreviousWorkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousWorkerActionPerformed
        if (workerObserved > 0) {
            workerObserved--;
            viewWorkerInformation(workerObserved);
        }
    }//GEN-LAST:event_btnPreviousWorkerActionPerformed

    private void btnDeleteWorkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteWorkerActionPerformed
       int userAnswer = JPaneMessage.MessageOptionDialog(this, 
               "¿Está seguro que desea eliminar este trabajador?", 
               "Eliminar trabajador", new String[]{"Eliminar", "Volver"}, 2);
        if(userAnswer == 1){
            return;
        }
        try {
            Worker worker = this.WORKER_LIST.get(workerObserved);
            worker.setIsActive(false);
            worker.setIsDelete(true);

            REQUEST_WORKER.editWorker(worker);
            this.WORKER_LIST.remove(workerObserved);
            JPaneMessage.messageDialog(this, "El trabajador ha sido eliminado exitosamente.", "Eliminación exitosa", 1);

            if (this.WORKER_LIST.isEmpty()) {
                PeopleManagementView workersFirstView = new PeopleManagementView(this.PRINCIPALJFRAME);
                this.PRINCIPALJFRAME.replacePanel(workersFirstView);
                return;
            }

            if (workerObserved == (this.WORKER_LIST.size())) {
                workerObserved--;
            }

            viewWorkerInformation(workerObserved);
            

        } catch (Exception ex) {
            Logger.getLogger(WorkersInformationView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteWorkerActionPerformed

    private void btnEditWorkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditWorkerActionPerformed
        WorkerEditInformationView workerEditInformation = new WorkerEditInformationView(this.WORKER_LIST.get(workerObserved), this.PRINCIPALJFRAME);
        workerEditInformation.setVisible(true);
        this.PRINCIPALJFRAME.setVisible(false);
    }//GEN-LAST:event_btnEditWorkerActionPerformed

    private void btnAllWorkerListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllWorkerListActionPerformed
        List<Worker> workerList = REQUEST_WORKER.getNoDeletedWorker();

        WorkersListView workerListView = new WorkersListView(this.PRINCIPALJFRAME, workerList);
        this.PRINCIPALJFRAME.replacePanel(workerListView);
    }//GEN-LAST:event_btnAllWorkerListActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAllWorkerList;
    private javax.swing.JButton btnDeleteWorker;
    private javax.swing.JButton btnEditWorker;
    private javax.swing.JButton btnNextWorker;
    private javax.swing.JButton btnPreviousWorker;
    private javax.swing.JPanel buttonListWorkersPanel;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JPanel dataInformation1Panel;
    private javax.swing.JPanel dataInformation2Panel;
    private javax.swing.JPanel information1Panel;
    private javax.swing.JPanel information2Panel;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel lbWorkerState;
    private javax.swing.JPanel lbsInformation1Panel;
    private javax.swing.JPanel lbsInformation2Panel;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtBloodType;
    private javax.swing.JTextField txtDateVinculation;
    private javax.swing.JTextField txtEps;
    private javax.swing.JTextField txtFirstLastName;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtIdentificationNum;
    private javax.swing.JTextField txtIdentificationType;
    private javax.swing.JTextField txtPosition;
    private javax.swing.JTextField txtSecondLastName;
    private javax.swing.JTextField txtSecondName;
    // End of variables declaration//GEN-END:variables
}
