/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.marlenproject.userinterface.panelViews.workersSection;

import com.mycompany.marlenproject.userinterface.AdminHome;

/**
 *
 * @author willy
 */
public class WorkersFirstView extends javax.swing.JPanel {
    private AdminHome adminHome; 

    /**
     * Creates new form workersView
     */
    public WorkersFirstView(AdminHome newPanel) {
        initComponents();
        this.adminHome = newPanel;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addWorkerbtnPanel = new javax.swing.JPanel();
        btnAddNewWorker = new javax.swing.JButton();
        listWorkerbtnPanel = new javax.swing.JPanel();
        btnListWorkers = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        addWorkerbtnPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        addWorkerbtnPanel.setName(""); // NOI18N

        btnAddNewWorker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconAddWorker.png"))); // NOI18N
        btnAddNewWorker.setText("Agregar nuevo trabajador");
        btnAddNewWorker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewWorkerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addWorkerbtnPanelLayout = new javax.swing.GroupLayout(addWorkerbtnPanel);
        addWorkerbtnPanel.setLayout(addWorkerbtnPanelLayout);
        addWorkerbtnPanelLayout.setHorizontalGroup(
            addWorkerbtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addWorkerbtnPanelLayout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(btnAddNewWorker, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addGap(241, 241, 241))
        );
        addWorkerbtnPanelLayout.setVerticalGroup(
            addWorkerbtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addWorkerbtnPanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(btnAddNewWorker, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addGap(64, 64, 64))
        );

        listWorkerbtnPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 51)));

        btnListWorkers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconList.png"))); // NOI18N
        btnListWorkers.setText("Ver mis trabajadores");
        btnListWorkers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListWorkersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout listWorkerbtnPanelLayout = new javax.swing.GroupLayout(listWorkerbtnPanel);
        listWorkerbtnPanel.setLayout(listWorkerbtnPanelLayout);
        listWorkerbtnPanelLayout.setHorizontalGroup(
            listWorkerbtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listWorkerbtnPanelLayout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(btnListWorkers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(239, 239, 239))
        );
        listWorkerbtnPanelLayout.setVerticalGroup(
            listWorkerbtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listWorkerbtnPanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(btnListWorkers, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addWorkerbtnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listWorkerbtnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addWorkerbtnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listWorkerbtnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddNewWorkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewWorkerActionPerformed
        AddWorkerView addWorkerView = new AddWorkerView();
        addWorkerView.setSize(800, 500);
        addWorkerView.setLocation(0, 0);
        adminHome.replacePanel(addWorkerView);
    }//GEN-LAST:event_btnAddNewWorkerActionPerformed

    private void btnListWorkersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListWorkersActionPerformed
        WorkersInformationView workersInformationView = new WorkersInformationView();
        workersInformationView.setSize(800, 500);
        workersInformationView.setLocation(0, 0);
        adminHome.replacePanel(workersInformationView);
    }//GEN-LAST:event_btnListWorkersActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addWorkerbtnPanel;
    private javax.swing.JButton btnAddNewWorker;
    private javax.swing.JButton btnListWorkers;
    private javax.swing.JPanel listWorkerbtnPanel;
    // End of variables declaration//GEN-END:variables
}
