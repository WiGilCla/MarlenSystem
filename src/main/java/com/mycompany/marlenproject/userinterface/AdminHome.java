/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.marlenproject.userinterface;

import com.mycompany.marlenproject.logic.AccountBook;
import com.mycompany.marlenproject.logic.request.RequestAccountBook;
import com.mycompany.marlenproject.userinterface.panelViews.accountingSection.AccountingView;
import com.mycompany.marlenproject.userinterface.panelViews.workersSection.WorkersFirstView;
import java.util.List;

import javax.swing.JPanel;

public class AdminHome extends javax.swing.JFrame {

    public AdminHome() {
        initComponents();
        setTitle("Administrador");
        setLocationRelativeTo(null);
    }
    
    public void replacePanel(JPanel newPanel){
        javax.swing.GroupLayout viewPanelLayout = new javax.swing.GroupLayout(viewPanel);
        viewPanel.removeAll();
        viewPanel.setLayout(viewPanelLayout);
        viewPanelLayout.setHorizontalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        viewPanelLayout.setVerticalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                
                .addContainerGap())
        );
        
        viewPanel.revalidate();
        viewPanel.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        defaultPanel = new javax.swing.JPanel();
        optionsPanel = new javax.swing.JPanel();
        accountingPanel = new javax.swing.JPanel();
        btnAccountingSection = new javax.swing.JButton();
        quotesPanel = new javax.swing.JPanel();
        btnQuotesSection = new javax.swing.JButton();
        workersPanel = new javax.swing.JPanel();
        btnWorkersSection = new javax.swing.JButton();
        viewPanel = new javax.swing.JPanel();
        welcomeMsgPanel = new javax.swing.JPanel();
        lbWelcome = new javax.swing.JLabel();
        timeZonePanel = new javax.swing.JPanel();
        lbTimeZone = new javax.swing.JLabel();
        ViewsPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 600));

        defaultPanel.setPreferredSize(new java.awt.Dimension(1200, 600));

        optionsPanel.setPreferredSize(new java.awt.Dimension(200, 588));

        accountingPanel.setPreferredSize(new java.awt.Dimension(188, 100));

        btnAccountingSection.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconCalculation.png"))); // NOI18N
        btnAccountingSection.setText("Contabilidad");
        btnAccountingSection.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAccountingSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountingSectionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout accountingPanelLayout = new javax.swing.GroupLayout(accountingPanel);
        accountingPanel.setLayout(accountingPanelLayout);
        accountingPanelLayout.setHorizontalGroup(
            accountingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAccountingSection, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addContainerGap())
        );
        accountingPanelLayout.setVerticalGroup(
            accountingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAccountingSection, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addContainerGap())
        );

        quotesPanel.setPreferredSize(new java.awt.Dimension(188, 100));

        btnQuotesSection.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconNewPage.png"))); // NOI18N
        btnQuotesSection.setText("Cotizaciones");
        btnQuotesSection.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout quotesPanelLayout = new javax.swing.GroupLayout(quotesPanel);
        quotesPanel.setLayout(quotesPanelLayout);
        quotesPanelLayout.setHorizontalGroup(
            quotesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quotesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnQuotesSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        quotesPanelLayout.setVerticalGroup(
            quotesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quotesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnQuotesSection, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        workersPanel.setPreferredSize(new java.awt.Dimension(188, 100));

        btnWorkersSection.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconWorker.png"))); // NOI18N
        btnWorkersSection.setText("Trabajadores");
        btnWorkersSection.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnWorkersSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWorkersSectionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout workersPanelLayout = new javax.swing.GroupLayout(workersPanel);
        workersPanel.setLayout(workersPanelLayout);
        workersPanelLayout.setHorizontalGroup(
            workersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, workersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnWorkersSection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        workersPanelLayout.setVerticalGroup(
            workersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, workersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnWorkersSection, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout optionsPanelLayout = new javax.swing.GroupLayout(optionsPanel);
        optionsPanel.setLayout(optionsPanelLayout);
        optionsPanelLayout.setHorizontalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(workersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accountingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quotesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        optionsPanelLayout.setVerticalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(accountingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quotesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(workersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        viewPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        viewPanel.setPreferredSize(new java.awt.Dimension(982, 588));

        welcomeMsgPanel.setPreferredSize(new java.awt.Dimension(970, 100));

        lbWelcome.setFont(new java.awt.Font("Yu Gothic UI", 1, 48)); // NOI18N
        lbWelcome.setText("¡Bienvenido!");
        lbWelcome.setPreferredSize(new java.awt.Dimension(300, 70));

        javax.swing.GroupLayout welcomeMsgPanelLayout = new javax.swing.GroupLayout(welcomeMsgPanel);
        welcomeMsgPanel.setLayout(welcomeMsgPanelLayout);
        welcomeMsgPanelLayout.setHorizontalGroup(
            welcomeMsgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcomeMsgPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(lbWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        welcomeMsgPanelLayout.setVerticalGroup(
            welcomeMsgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcomeMsgPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        timeZonePanel.setPreferredSize(new java.awt.Dimension(970, 75));

        lbTimeZone.setText("Hoy estamos a xxx, xxx de xxx de xxx ");

        javax.swing.GroupLayout timeZonePanelLayout = new javax.swing.GroupLayout(timeZonePanel);
        timeZonePanel.setLayout(timeZonePanelLayout);
        timeZonePanelLayout.setHorizontalGroup(
            timeZonePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timeZonePanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(lbTimeZone)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        timeZonePanelLayout.setVerticalGroup(
            timeZonePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timeZonePanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lbTimeZone)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        ViewsPanel.setPreferredSize(new java.awt.Dimension(970, 389));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(30);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Su sistema de control y registro, es una herramienta que le permitirá realizar sus operaciones a través de diferentes herramientas que cumplen tareas especificas como realizar registro de sus operaciones, controlar la información de sus empleados o realizar documentación necesaria, todo en un mismo lugar.\n\n¡Trabaje de manera óptima y sencilla!");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextArea1.setOpaque(false);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout ViewsPanelLayout = new javax.swing.GroupLayout(ViewsPanel);
        ViewsPanel.setLayout(ViewsPanelLayout);
        ViewsPanelLayout.setHorizontalGroup(
            ViewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewsPanelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
                .addGap(53, 53, 53))
        );
        ViewsPanelLayout.setVerticalGroup(
            ViewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(195, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout viewPanelLayout = new javax.swing.GroupLayout(viewPanel);
        viewPanel.setLayout(viewPanelLayout);
        viewPanelLayout.setHorizontalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(welcomeMsgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
                    .addComponent(timeZonePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
                    .addComponent(ViewsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE))
                .addContainerGap())
        );
        viewPanelLayout.setVerticalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomeMsgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeZonePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ViewsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout defaultPanelLayout = new javax.swing.GroupLayout(defaultPanel);
        defaultPanel.setLayout(defaultPanelLayout);
        defaultPanelLayout.setHorizontalGroup(
            defaultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(optionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        defaultPanelLayout.setVerticalGroup(
            defaultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, defaultPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(defaultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(optionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(defaultPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(defaultPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnWorkersSectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWorkersSectionActionPerformed
        WorkersFirstView workersFirstView  = new WorkersFirstView(this);
        workersFirstView.setSize(970, 576);
        workersFirstView.setLocation(0, 0);
        replacePanel(workersFirstView);
    }//GEN-LAST:event_btnWorkersSectionActionPerformed

    private void btnAccountingSectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountingSectionActionPerformed
        // TODO add your handling code here:
        RequestAccountBook requestBook = new RequestAccountBook();
        List<AccountBook> listBooks = requestBook.getBooks();
        AccountingView accountingView = new AccountingView(this,listBooks);
        accountingView.setSize(970, 576);
        accountingView.setLocation(0, 0);
        replacePanel(accountingView);
    }//GEN-LAST:event_btnAccountingSectionActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ViewsPanel;
    private javax.swing.JPanel accountingPanel;
    private javax.swing.JButton btnAccountingSection;
    private javax.swing.JButton btnQuotesSection;
    private javax.swing.JButton btnWorkersSection;
    private javax.swing.JPanel defaultPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbTimeZone;
    private javax.swing.JLabel lbWelcome;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JPanel quotesPanel;
    private javax.swing.JPanel timeZonePanel;
    private javax.swing.JPanel viewPanel;
    private javax.swing.JPanel welcomeMsgPanel;
    private javax.swing.JPanel workersPanel;
    // End of variables declaration//GEN-END:variables
}
