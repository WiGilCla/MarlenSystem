/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.marlenproject.userinterface.panelViews.workersSection;

/**
 *
 * @author willy
 */
public class AddWorkerView extends javax.swing.JPanel {

    /**
     * Creates new form SecondWorkersView
     */
    public AddWorkerView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        dataInformation1Panel = new javax.swing.JPanel();
        txtFirstName = new javax.swing.JTextField();
        txtFirstLastName = new javax.swing.JTextField();
        txtBloodType = new javax.swing.JTextField();
        sltIdentificationType = new javax.swing.JComboBox<>();
        txtAge = new javax.swing.JTextField();
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
        txtEps = new javax.swing.JTextField();
        dateVinculation = new com.toedter.calendar.JDateChooser();
        txtIdentificationNum = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "AGREGAR NUEVO TRABAJADOR", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        setPreferredSize(new java.awt.Dimension(800, 500));

        buttonsPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 204)));

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

        javax.swing.GroupLayout buttonsPanelLayout = new javax.swing.GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(buttonsPanelLayout);
        buttonsPanelLayout.setHorizontalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(btnCleanFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
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

        lbsInformation1Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
        lbAge.setText("Edad:");
        lbAge.setPreferredSize(new java.awt.Dimension(0, 25));

        javax.swing.GroupLayout lbsInformation1PanelLayout = new javax.swing.GroupLayout(lbsInformation1Panel);
        lbsInformation1Panel.setLayout(lbsInformation1PanelLayout);
        lbsInformation1PanelLayout.setHorizontalGroup(
            lbsInformation1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbFirstlastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbIdentificationType, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
            .addComponent(lbBloodType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap())
        );

        dataInformation1Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));
        dataInformation1Panel.setPreferredSize(new java.awt.Dimension(230, 300));

        txtFirstName.setPreferredSize(new java.awt.Dimension(75, 25));

        txtFirstLastName.setPreferredSize(new java.awt.Dimension(75, 25));
        txtFirstLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstLastNameActionPerformed(evt);
            }
        });

        txtBloodType.setPreferredSize(new java.awt.Dimension(75, 25));

        sltIdentificationType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cédula de ciudadanía", "Cédula de extranjería", "Tarjeta pasaporte", "Sin identificación" }));
        sltIdentificationType.setPreferredSize(new java.awt.Dimension(75, 25));

        txtAge.setPreferredSize(new java.awt.Dimension(75, 25));
        txtAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeActionPerformed(evt);
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
                    .addComponent(txtAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFirstLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBloodType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBloodType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout information1PanelLayout = new javax.swing.GroupLayout(information1Panel);
        information1Panel.setLayout(information1PanelLayout);
        information1PanelLayout.setHorizontalGroup(
            information1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(information1PanelLayout.createSequentialGroup()
                .addComponent(lbsInformation1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataInformation1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
        );
        information1PanelLayout.setVerticalGroup(
            information1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbsInformation1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addComponent(dataInformation1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );

        information2Panel.setPreferredSize(new java.awt.Dimension(350, 300));

        lbsInformation2Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
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
            .addComponent(lbIdentificationNum, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
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

        dataInformation2Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 51)));
        dataInformation2Panel.setPreferredSize(new java.awt.Dimension(230, 300));

        txtSecondName.setPreferredSize(new java.awt.Dimension(75, 25));

        txtSecondLastName.setPreferredSize(new java.awt.Dimension(75, 25));
        txtSecondLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSecondLastNameActionPerformed(evt);
            }
        });

        txtEps.setPreferredSize(new java.awt.Dimension(75, 25));

        dateVinculation.setPreferredSize(new java.awt.Dimension(75, 25));

        txtIdentificationNum.setPreferredSize(new java.awt.Dimension(75, 25));
        txtIdentificationNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdentificationNumActionPerformed(evt);
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
                    .addComponent(txtEps, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSecondLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIdentificationNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateVinculation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(dateVinculation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout information2PanelLayout = new javax.swing.GroupLayout(information2Panel);
        information2Panel.setLayout(information2PanelLayout);
        information2PanelLayout.setHorizontalGroup(
            information2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(information2PanelLayout.createSequentialGroup()
                .addComponent(lbsInformation2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataInformation2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
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
                .addComponent(information1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(information2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
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
                .addContainerGap(121, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtFirstLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstLastNameActionPerformed

    private void txtAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeActionPerformed

    private void txtSecondLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSecondLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSecondLastNameActionPerformed

    private void txtIdentificationNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdentificationNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdentificationNumActionPerformed

    private void btnCleanFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanFieldsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCleanFieldsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCleanFields;
    private javax.swing.JButton btnSaveWorker;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JPanel dataInformation1Panel;
    private javax.swing.JPanel dataInformation2Panel;
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
    private javax.swing.JLabel lbSecondLastName;
    private javax.swing.JLabel lbSecondName;
    private javax.swing.JPanel lbsInformation1Panel;
    private javax.swing.JPanel lbsInformation2Panel;
    private javax.swing.JComboBox<String> sltIdentificationType;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtBloodType;
    private javax.swing.JTextField txtEps;
    private javax.swing.JTextField txtFirstLastName;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtIdentificationNum;
    private javax.swing.JTextField txtSecondLastName;
    private javax.swing.JTextField txtSecondName;
    // End of variables declaration//GEN-END:variables
}
