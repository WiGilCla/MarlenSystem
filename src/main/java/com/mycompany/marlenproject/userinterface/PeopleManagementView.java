/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.marlenproject.userinterface;

import com.mycompany.marlenproject.logic.Customer;
import com.mycompany.marlenproject.logic.Worker;
import com.mycompany.marlenproject.logic.request.RequestCustomer;
import com.mycompany.marlenproject.logic.request.requestWorker;
import com.mycompany.marlenproject.userinterface.panelViews.customerSection.AddCustomerView;
import com.mycompany.marlenproject.userinterface.panelViews.customerSection.CustomerListView;
import com.mycompany.marlenproject.userinterface.panelViews.workersSection.AddWorkerView;
import com.mycompany.marlenproject.userinterface.panelViews.workersSection.WorkersListView;
import com.mycompany.marlenproject.utils.message.JPaneMessage;
import com.mycompany.marlenproject.utils.colors.Colors;
import java.util.List;

public class PeopleManagementView extends javax.swing.JPanel {

    private final AdminHome PRINCIPALJFRAME;

    public PeopleManagementView(AdminHome principalJFrame) {
        initComponents();
        this.PRINCIPALJFRAME = principalJFrame;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        firstSectionPanel = new javax.swing.JPanel();
        workersPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnAddNewWorker = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnListWorkers = new javax.swing.JButton();
        customerPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnAddCustomer = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnCustomerList = new javax.swing.JButton();

        setBackground(Colors.PRIMARY_200);
        setPreferredSize(new java.awt.Dimension(970, 576));

        firstSectionPanel.setBackground(Colors.PRIMARY_200);
        firstSectionPanel.setName(""); // NOI18N
        firstSectionPanel.setPreferredSize(new java.awt.Dimension(958, 300));

        workersPanel.setBackground(Colors.PRIMARY_200);
        workersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TRABAJADORES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 1, 18), Colors.PRIMARY_900)); // NOI18N
        workersPanel.setPreferredSize(new java.awt.Dimension(467, 282));

        jPanel3.setBackground(Colors.PRIMARY_200);
        jPanel3.setPreferredSize(new java.awt.Dimension(226, 264));

        btnAddNewWorker.setBackground(Colors.PRIMARY_300);
        btnAddNewWorker.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnAddNewWorker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconAddWorker.png"))); // NOI18N
        btnAddNewWorker.setText("Agregar");
        btnAddNewWorker.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddNewWorker.setMaximumSize(new java.awt.Dimension(200, 50));
        btnAddNewWorker.setPreferredSize(new java.awt.Dimension(170, 60));
        btnAddNewWorker.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAddNewWorker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewWorkerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddNewWorker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnAddNewWorker, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(Colors.PRIMARY_200);
        jPanel4.setPreferredSize(new java.awt.Dimension(226, 264));

        btnListWorkers.setBackground(Colors.PRIMARY_300);
        btnListWorkers.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnListWorkers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconList.png"))); // NOI18N
        btnListWorkers.setText("Listado");
        btnListWorkers.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListWorkers.setMaximumSize(new java.awt.Dimension(200, 50));
        btnListWorkers.setPreferredSize(new java.awt.Dimension(170, 60));
        btnListWorkers.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListWorkers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListWorkersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnListWorkers, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnListWorkers, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout workersPanelLayout = new javax.swing.GroupLayout(workersPanel);
        workersPanel.setLayout(workersPanelLayout);
        workersPanelLayout.setHorizontalGroup(
            workersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workersPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
        workersPanelLayout.setVerticalGroup(
            workersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, workersPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(workersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addGap(46, 46, 46))
        );

        customerPanel.setBackground(Colors.PRIMARY_200);
        customerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CLIENTES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 1, 18), Colors.PRIMARY_900)); // NOI18N
        customerPanel.setPreferredSize(new java.awt.Dimension(467, 282));

        jPanel5.setBackground(Colors.PRIMARY_200);
        jPanel5.setPreferredSize(new java.awt.Dimension(226, 264));

        btnAddCustomer.setBackground(Colors.PRIMARY_300);
        btnAddCustomer.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnAddCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconAddWorker.png"))); // NOI18N
        btnAddCustomer.setText("Agregar");
        btnAddCustomer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddCustomer.setPreferredSize(new java.awt.Dimension(170, 60));
        btnAddCustomer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnAddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel6.setBackground(Colors.PRIMARY_200);
        jPanel6.setPreferredSize(new java.awt.Dimension(226, 264));

        btnCustomerList.setBackground(Colors.PRIMARY_300);
        btnCustomerList.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnCustomerList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconList.png"))); // NOI18N
        btnCustomerList.setText("Listado");
        btnCustomerList.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCustomerList.setPreferredSize(new java.awt.Dimension(170, 60));
        btnCustomerList.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCustomerList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCustomerList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnCustomerList, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout customerPanelLayout = new javax.swing.GroupLayout(customerPanel);
        customerPanel.setLayout(customerPanelLayout);
        customerPanelLayout.setHorizontalGroup(
            customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
        );
        customerPanelLayout.setVerticalGroup(
            customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout firstSectionPanelLayout = new javax.swing.GroupLayout(firstSectionPanel);
        firstSectionPanel.setLayout(firstSectionPanelLayout);
        firstSectionPanelLayout.setHorizontalGroup(
            firstSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(firstSectionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(workersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addContainerGap())
        );
        firstSectionPanelLayout.setVerticalGroup(
            firstSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(firstSectionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(firstSectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(customerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(workersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(282, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(firstSectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(firstSectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void btnCustomerListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerListActionPerformed
        List<Customer> customerList = new RequestCustomer().getNoDeleteCustomer();

        if (!customerList.isEmpty()) {

            CustomerListView customerListView = new CustomerListView(this.PRINCIPALJFRAME, customerList);
            PRINCIPALJFRAME.replacePanel(customerListView);

        } else {

            JPaneMessage.messageDialog(PRINCIPALJFRAME, "No tiene clientes registrados", "Sin registros", 0);

        }
    }//GEN-LAST:event_btnCustomerListActionPerformed

    private void btnAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCustomerActionPerformed
        AddCustomerView addCustomerView = new AddCustomerView();
        addCustomerView.setLocation(0, 0);
        PRINCIPALJFRAME.replacePanel(addCustomerView);
    }//GEN-LAST:event_btnAddCustomerActionPerformed

    private void btnListWorkersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListWorkersActionPerformed
        List<Worker> workerList = new requestWorker().getNoDeletedWorker();

        if (!workerList.isEmpty()) {

            WorkersListView workerListView = new WorkersListView(this.PRINCIPALJFRAME, workerList);
            PRINCIPALJFRAME.replacePanel(workerListView);

        } else {

            JPaneMessage.messageDialog(PRINCIPALJFRAME, "No tiene trabajadores registrados", "Sin registros", 0);

        }
    }//GEN-LAST:event_btnListWorkersActionPerformed

    private void btnAddNewWorkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewWorkerActionPerformed
        AddWorkerView addWorkerView = new AddWorkerView();
        addWorkerView.setLocation(0, 0);
        PRINCIPALJFRAME.replacePanel(addWorkerView);
    }//GEN-LAST:event_btnAddNewWorkerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCustomer;
    private javax.swing.JButton btnAddNewWorker;
    private javax.swing.JButton btnCustomerList;
    private javax.swing.JButton btnListWorkers;
    private javax.swing.JPanel customerPanel;
    private javax.swing.JPanel firstSectionPanel;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel workersPanel;
    // End of variables declaration//GEN-END:variables
}
