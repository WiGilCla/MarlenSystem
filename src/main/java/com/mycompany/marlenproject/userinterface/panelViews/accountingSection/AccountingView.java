/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.marlenproject.userinterface.panelViews.accountingSection;

import com.mycompany.marlenproject.userinterface.AdminHome;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JPopupMenu.Separator;
import javax.swing.JScrollPane;

/**
 *
 * @author willy
 */
public class AccountingView extends javax.swing.JPanel {

    private final AdminHome PRINCIPALJFRAME;

    public AccountingView(AdminHome principalJFrame) {
        this.PRINCIPALJFRAME = principalJFrame;

        initComponents();
        showAccountRecords();

    }

    private void showAccountRecords() {
        
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));

        for (int i = 0; i < 10; i++) {
            
            JPanel panelExterior = new JPanel();
            panelExterior.setLayout(new BoxLayout(panelExterior, BoxLayout.X_AXIS));
            
            JPanel dataPanel = new JPanel();
            dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.X_AXIS));
            dataPanel.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));

            JPanel numRecordPanel = new JPanel(new GridLayout(1, 1));
            numRecordPanel.setPreferredSize(new Dimension(100, 44));
            numRecordPanel.setMaximumSize(new Dimension(100, 44));
            JLabel numRecordLabel = new JLabel("registro");
            numRecordPanel.add(numRecordLabel);
            dataPanel.add(numRecordPanel);
            
            Separator separatorNum = new Separator();
            separatorNum.setOrientation(1);
            dataPanel.add(separatorNum);
            
            JPanel dateRecordPanel = new JPanel(new GridLayout(1, 1));
            dateRecordPanel.setPreferredSize(new Dimension(100, 44));
            dateRecordPanel.setMaximumSize(new Dimension(100, 44));
            JLabel dateRecordLabel = new JLabel("Date");
            dateRecordPanel.add(dateRecordLabel);
            dataPanel.add(dateRecordPanel);
            Separator separatorDate = new Separator();
            separatorDate.setOrientation(1);
            dataPanel.add(separatorDate);

            JPanel titleRecordPanel = new JPanel(new GridLayout(1, 1));
            titleRecordPanel.setPreferredSize(new Dimension(350, 44));
            JLabel titleRecordLabel = new JLabel("titulo");
            titleRecordPanel.add(titleRecordLabel);
            dataPanel.add(titleRecordPanel);
            Separator separatorTitle = new Separator();
            separatorTitle.setOrientation(1);
            dataPanel.add(separatorTitle);
            
            JPanel buttonPanel = new JPanel(new GridLayout(1, 4,6,6));            
            buttonPanel.setMaximumSize(new Dimension(158,44));

            JPanel watchRecordPanel = new JPanel(new GridLayout(1, 1));
            watchRecordPanel.setPreferredSize(new Dimension(44, 44));
            JButton btnWatchRecord = new JButton();
            btnWatchRecord.setPreferredSize(new Dimension(32, 32));
            btnWatchRecord.setMaximumSize(new Dimension(32, 32));
            btnWatchRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images32x32/iconWatch.png")));
            watchRecordPanel.add(btnWatchRecord);
            buttonPanel.add(watchRecordPanel);

            JPanel editRecordPanel = new JPanel(new GridLayout(1, 1));
            editRecordPanel.setPreferredSize(new Dimension(44, 44));
            JButton btnEditRecord = new JButton();
            btnEditRecord.setPreferredSize(new Dimension(32, 32));
            btnEditRecord.setMaximumSize(new Dimension(32, 32));
            btnEditRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images32x32/iconEdit.png")));
            editRecordPanel.add(btnEditRecord);
            buttonPanel.add(editRecordPanel);

            JPanel deleteRecordPanel = new JPanel(new GridLayout(1, 1));
            deleteRecordPanel.setPreferredSize(new Dimension(44, 44));
            JButton btnDeleteRecord = new JButton();
            btnDeleteRecord.setPreferredSize(new Dimension(32, 32));
            btnDeleteRecord.setMaximumSize(new Dimension(32, 32));
            btnDeleteRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images32x32/iconTrash.png")));
            deleteRecordPanel.add(btnDeleteRecord);
            buttonPanel.add(deleteRecordPanel);

            JPanel downloadRecordPanel = new JPanel(new GridLayout(1, 1));
            downloadRecordPanel.setPreferredSize(new Dimension(44, 44));
            JButton btnDownloadRecord = new JButton();
            btnDownloadRecord.setPreferredSize(new Dimension(32, 32));
            btnDownloadRecord.setMaximumSize(new Dimension(32, 32));
            btnDownloadRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images32x32/iconDownload.png")));
            downloadRecordPanel.add(btnDownloadRecord);
            buttonPanel.add(downloadRecordPanel);
            
            panelExterior.add(dataPanel);
            panelExterior.add(buttonPanel);
            
            contentPane.add(panelExterior);
            contentPane.add(new JPopupMenu.Separator());
        }
        JScrollPane scrollPane = new JScrollPane(contentPane);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        RecordsPanel.add(scrollPane);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitlePanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        FiltersPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        tablePanel = new javax.swing.JPanel();
        OptionsPanel = new javax.swing.JPanel();
        btnAddAccount = new javax.swing.JButton();
        RecordsPanel = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 0)));
        setPreferredSize(new java.awt.Dimension(970, 576));

        TitlePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel4.setText("HISTORIAL DE REGISTROS CONTABLES");

        javax.swing.GroupLayout TitlePanelLayout = new javax.swing.GroupLayout(TitlePanel);
        TitlePanel.setLayout(TitlePanelLayout);
        TitlePanelLayout.setHorizontalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TitlePanelLayout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(301, 301, 301))
        );
        TitlePanelLayout.setVerticalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        FiltersPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 255)));

        jTextField1.setText("jTextField1");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images32x32/iconLupe.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel1.setText("Titulo / N° de folio:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1)
                .addGap(18, 18, 18)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 255)));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel2.setText("Desde:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 255)));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel3.setText("Hasta:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout FiltersPanelLayout = new javax.swing.GroupLayout(FiltersPanel);
        FiltersPanel.setLayout(FiltersPanelLayout);
        FiltersPanelLayout.setHorizontalGroup(
            FiltersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FiltersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        FiltersPanelLayout.setVerticalGroup(
            FiltersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FiltersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FiltersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        OptionsPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 102)));

        btnAddAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconNewPage.png"))); // NOI18N
        btnAddAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout OptionsPanelLayout = new javax.swing.GroupLayout(OptionsPanel);
        OptionsPanel.setLayout(OptionsPanelLayout);
        OptionsPanelLayout.setHorizontalGroup(
            OptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addContainerGap())
        );
        OptionsPanelLayout.setVerticalGroup(
            OptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddAccount)
                .addContainerGap(331, Short.MAX_VALUE))
        );

        RecordsPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 102)));
        RecordsPanel.setLayout(new javax.swing.BoxLayout(RecordsPanel, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RecordsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OptionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OptionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RecordsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FiltersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FiltersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAccountActionPerformed
        // TODO add your handling code here:
        AccountBookView accountBookView = new AccountBookView(this.PRINCIPALJFRAME);
        accountBookView.setSize(970, 576);
        accountBookView.setLocation(0, 0);
        this.PRINCIPALJFRAME.replacePanel(accountBookView);
    }//GEN-LAST:event_btnAddAccountActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FiltersPanel;
    private javax.swing.JPanel OptionsPanel;
    private javax.swing.JPanel RecordsPanel;
    private javax.swing.JPanel TitlePanel;
    private javax.swing.JButton btnAddAccount;
    private javax.swing.JButton btnSearch;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel tablePanel;
    // End of variables declaration//GEN-END:variables
}
