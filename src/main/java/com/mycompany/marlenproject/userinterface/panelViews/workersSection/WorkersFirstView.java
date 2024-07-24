/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.marlenproject.userinterface.panelViews.workersSection;

import com.mycompany.marlenproject.logic.Worker;
import com.mycompany.marlenproject.logic.request.requestWorker;
import com.mycompany.marlenproject.userinterface.AdminHome;
import java.util.List;
import javax.swing.JOptionPane;

public class WorkersFirstView extends javax.swing.JPanel {

    private final AdminHome principalJFrame;

    public WorkersFirstView(AdminHome principalJFrame) {
        initComponents();
        this.principalJFrame = principalJFrame;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addWorkerbtnPanel = new javax.swing.JPanel();
        btnAddNewWorker = new javax.swing.JButton();
        listWorkerbtnPanel = new javax.swing.JPanel();
        btnListWorkers = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(970, 576));

        addWorkerbtnPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        addWorkerbtnPanel.setName(""); // NOI18N
        addWorkerbtnPanel.setPreferredSize(new java.awt.Dimension(958, 282));

        btnAddNewWorker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconAddWorker.png"))); // NOI18N
        btnAddNewWorker.setText("Agregar nuevo trabajador");
        btnAddNewWorker.setMaximumSize(new java.awt.Dimension(200, 50));
        btnAddNewWorker.setPreferredSize(new java.awt.Dimension(250, 60));
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddNewWorker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addWorkerbtnPanelLayout.setVerticalGroup(
            addWorkerbtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addWorkerbtnPanelLayout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addComponent(btnAddNewWorker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        listWorkerbtnPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        listWorkerbtnPanel.setPreferredSize(new java.awt.Dimension(958, 282));

        btnListWorkers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconList.png"))); // NOI18N
        btnListWorkers.setText("Ver mis trabajadores");
        btnListWorkers.setMaximumSize(new java.awt.Dimension(200, 50));
        btnListWorkers.setPreferredSize(new java.awt.Dimension(200, 60));
        btnListWorkers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListWorkersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout listWorkerbtnPanelLayout = new javax.swing.GroupLayout(listWorkerbtnPanel);
        listWorkerbtnPanel.setLayout(listWorkerbtnPanelLayout);
        listWorkerbtnPanelLayout.setHorizontalGroup(
            listWorkerbtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listWorkerbtnPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnListWorkers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        listWorkerbtnPanelLayout.setVerticalGroup(
            listWorkerbtnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listWorkerbtnPanelLayout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addComponent(btnListWorkers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
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
                .addComponent(addWorkerbtnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listWorkerbtnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddNewWorkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewWorkerActionPerformed
        AddWorkerView addWorkerView = new AddWorkerView();
        addWorkerView.setSize(800, 500);
        addWorkerView.setLocation(0, 0);
        principalJFrame.replacePanel(addWorkerView);
    }//GEN-LAST:event_btnAddNewWorkerActionPerformed

    private void btnListWorkersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListWorkersActionPerformed
//        List<Worker> workers;
//        workers = new requestWorker().getNoDeletedWorker();

//        if(!workers.isEmpty()){
//            WorkersInformationView workersInformationView = new WorkersInformationView(this.principalJFrame,workers, 0);
//            workersInformationView.setSize(970, 576);
//            workersInformationView.setLocation(0, 0);
//            principalJFrame.replacePanel(workersInformationView);
//            
//            
//        }else{
//            JOptionPane.showMessageDialog(principalJFrame, "No tiene trabajadores registrados", "Sin registros", 0);
//        }
        List<Worker> workerList;
        workerList = new requestWorker().getNoDeletedWorker();

        if (!workerList.isEmpty()) {
            WorkersListView workerListView = new WorkersListView(this.principalJFrame, workerList);
            workerListView.setSize(970, 576);
            principalJFrame.replacePanel(workerListView);
        } else {
            JOptionPane.showMessageDialog(principalJFrame, "No tiene trabajadores registrados", "Sin registros", 0);
        }
    }//GEN-LAST:event_btnListWorkersActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addWorkerbtnPanel;
    private javax.swing.JButton btnAddNewWorker;
    private javax.swing.JButton btnListWorkers;
    private javax.swing.JPanel listWorkerbtnPanel;
    // End of variables declaration//GEN-END:variables
}
