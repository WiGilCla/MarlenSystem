/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.marlenproject.userinterface.panelViews.accountingSection;

import com.mycompany.marlenproject.logic.AccountBook;
import com.mycompany.marlenproject.logic.request.RequestAccountBook;
import com.mycompany.marlenproject.logic.request.RequestAccountBookRecord;
import com.mycompany.marlenproject.userinterface.AdminHome;
import com.mycompany.marlenproject.utils.date.DateFunctions;
import com.mycompany.marlenproject.utils.colors.Colors;
import com.mycompany.marlenproject.utils.message.JPaneMessage;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu.Separator;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class AccountingView extends javax.swing.JPanel {

    private final AdminHome PRINCIPALJFRAME;
    private List<AccountBook> Books = new ArrayList<>();
    private final RequestAccountBook NEW_REQUEST_ACCOUNTBOOK = new RequestAccountBook();
    private final RequestAccountBookRecord NEW_REQUEST_RECORD = new RequestAccountBookRecord();

    public AccountingView(AdminHome principalJFrame, List<AccountBook> listBooks) {
        this.PRINCIPALJFRAME = principalJFrame;
        this.Books = listBooks;
        initComponents();
        showAccountRecords(listBooks);
    }

    private boolean isDateInRange(Date starDate, Date endDate, Date dateToCheck) {
        if (starDate == null || endDate == null) {
            return false;
        }
        return (dateToCheck.after(starDate) && dateToCheck.before(endDate));
    }

    private void settingsBtnWatchRecord(JButton watchButton, AccountBook book) {
        watchButton.addActionListener((ActionEvent e) -> {
            BookView bookView = new BookView(book.getListBookRecords(), book);
            bookView.setVisible(true);
            bookView.setLocationRelativeTo(null);
        });
    }

    private void settingsBtnEditRecord(JButton editButton, AccountBook book) {
        editButton.addActionListener((ActionEvent e) -> {
            EditAccountBookView editAccountBookView = new EditAccountBookView(this.PRINCIPALJFRAME, book);
            this.PRINCIPALJFRAME.replacePanel(editAccountBookView);
        });
    }

    private void settingsBtnDeleteRecord(JButton deleteButton, AccountBook book) {
        deleteButton.addActionListener((ActionEvent e) -> {

            int userAnswer = JPaneMessage.MessageOptionDialog(this, "<html>"
                    + "<body style='font-family: Arial, sans-serif;'>"
                    + "<p style='font-size: 16px; color: #2E8B57; text-align: center;'><b>¿Está seguro de eliminar este libro?</b></p>"
                    + "<p style='font-size: 14px; color: #8B0000; text-align: center;'>Será <b>ELIMINADO PERMANENTEMENTE</b>.</p>"
                    + "<br>"
                    + "</body>"
                    + "</html>", "Eliminar libro", new String[]{"Continuar", "Volver"}, 2);

            if (userAnswer == 0) {
                try {
                    NEW_REQUEST_RECORD.deleteRecordByBook(book);
                    NEW_REQUEST_ACCOUNTBOOK.deleteBook(book);
                    JPaneMessage.messageDialog(this, "El libro ha sido eliminado exitosamente", "Eliminación exitosa", 1);
                } catch (Exception ex) {
                    Logger.getLogger(AccountingView.class.getName()).log(Level.SEVERE, null, ex);
                }

                List<AccountBook> listBooks = NEW_REQUEST_ACCOUNTBOOK.getBooks();
                AccountingView accountingView = new AccountingView(PRINCIPALJFRAME, listBooks);
                PRINCIPALJFRAME.replacePanel(accountingView);
            }
        });
    }

    private void showAccountRecords(List<AccountBook> listBooks) {
        RecordsPanel.removeAll();
        RecordsPanel.revalidate();
        RecordsPanel.repaint();
        if (listBooks.isEmpty()) {
            return;
        }
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        contentPane.setBackground(Colors.PRIMARY_200);

        for (AccountBook book : listBooks) {

            JPanel panelExterior = new JPanel();
            panelExterior.setLayout(new BoxLayout(panelExterior, BoxLayout.X_AXIS));
            panelExterior.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
            panelExterior.setBackground(Colors.PRIMARY_300);

            JPanel dataPanel = new JPanel();
            dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.X_AXIS));
            dataPanel.setBackground(Colors.PRIMARY_300);

            JPanel numRecordPanel = new JPanel(new GridLayout(1, 1, 6, 6));
            numRecordPanel.setPreferredSize(new Dimension(100, 44));
            numRecordPanel.setMaximumSize(new Dimension(100, 44));
            numRecordPanel.setBackground(Colors.PRIMARY_300);
            JLabel numRecordLabel = new JLabel(String.valueOf(book.getAccountBookId()));
            numRecordLabel.setFont(new java.awt.Font("Georgia", 0, 14));
            numRecordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            numRecordLabel.setForeground(Colors.PRIMARY_950);
            numRecordPanel.add(numRecordLabel);
            dataPanel.add(numRecordPanel);

            Separator separatorNum = new Separator();
            separatorNum.setOrientation(1);
            separatorNum.setMaximumSize(new Dimension(1, 44));
            dataPanel.add(separatorNum);

            JPanel dateRecordPanel = new JPanel(new GridLayout(1, 1, 6, 6));
            dateRecordPanel.setPreferredSize(new Dimension(100, 44));
            dateRecordPanel.setMaximumSize(new Dimension(100, 44));
            dateRecordPanel.setBackground(Colors.PRIMARY_300);
            JLabel dateRecordLabel = new JLabel(DateFunctions.dateFormatDD_MM_YY(book.getCreationDate()));
            dateRecordLabel.setFont(new java.awt.Font("Georgia", 0, 14));
            dateRecordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            dateRecordLabel.setForeground(Colors.PRIMARY_950);
            dateRecordPanel.add(dateRecordLabel);
            dataPanel.add(dateRecordPanel);

            Separator separatorDate = new Separator();
            separatorDate.setOrientation(1);
            separatorDate.setMaximumSize(new Dimension(1, 44));
            dataPanel.add(separatorDate);

            JPanel titleRecordPanel = new JPanel(new GridLayout(1, 1, 6, 6));
            titleRecordPanel.setPreferredSize(new Dimension(350, 44));
            titleRecordPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 44));
            titleRecordPanel.setBackground(Colors.PRIMARY_300);
            JLabel titleRecordLabel = new JLabel(book.getTitleBook());
            titleRecordLabel.setFont(new java.awt.Font("Georgia", 0, 14));
            titleRecordLabel.setForeground(Colors.PRIMARY_950);
            titleRecordPanel.add(titleRecordLabel);
            dataPanel.add(titleRecordPanel);

            JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 6, 6));
            buttonPanel.setMaximumSize(new Dimension(158, 44));
            buttonPanel.setBackground(Colors.PRIMARY_300);

            JPanel watchRecordPanel = new JPanel(new GridLayout(1, 1, 6, 6));
            watchRecordPanel.setPreferredSize(new Dimension(44, 44));
            watchRecordPanel.setMaximumSize(new Dimension(44, 44));
            watchRecordPanel.setBackground(Colors.PRIMARY_300);
            JButton btnWatchRecord = new JButton();
            btnWatchRecord.setBackground(Colors.PRIMARY_200);
            settingsBtnWatchRecord(btnWatchRecord, book);
            btnWatchRecord.setPreferredSize(new Dimension(32, 32));
            btnWatchRecord.setMaximumSize(new Dimension(32, 32));
            btnWatchRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images32x32/iconWatch.png")));
            watchRecordPanel.add(btnWatchRecord);
            buttonPanel.add(watchRecordPanel);

            JPanel editRecordPanel = new JPanel(new GridLayout(1, 1, 6, 6));
            editRecordPanel.setPreferredSize(new Dimension(44, 44));
            editRecordPanel.setMaximumSize(new Dimension(44, 44));
            editRecordPanel.setBackground(Colors.PRIMARY_300);
            JButton btnEditRecord = new JButton();
            btnEditRecord.setBackground(Colors.PRIMARY_200);
            settingsBtnEditRecord(btnEditRecord, book);
            btnEditRecord.setPreferredSize(new Dimension(32, 32));
            btnEditRecord.setMaximumSize(new Dimension(32, 32));
            btnEditRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images32x32/iconEdit.png")));
            editRecordPanel.add(btnEditRecord);
            buttonPanel.add(editRecordPanel);

            JPanel deleteRecordPanel = new JPanel(new GridLayout(1, 1, 6, 6));
            deleteRecordPanel.setPreferredSize(new Dimension(44, 44));
            deleteRecordPanel.setMaximumSize(new Dimension(44, 44));
            deleteRecordPanel.setBackground(Colors.PRIMARY_300);
            JButton btnDeleteRecord = new JButton();
            btnDeleteRecord.setBackground(Colors.PRIMARY_200);
            settingsBtnDeleteRecord(btnDeleteRecord, book);
            btnDeleteRecord.setPreferredSize(new Dimension(32, 32));
            btnDeleteRecord.setMaximumSize(new Dimension(32, 32));
            btnDeleteRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images32x32/iconTrash.png")));
            deleteRecordPanel.add(btnDeleteRecord);
            buttonPanel.add(deleteRecordPanel);

            JPanel downloadRecordPanel = new JPanel(new GridLayout(1, 1, 6, 6));
            downloadRecordPanel.setPreferredSize(new Dimension(44, 44));
            downloadRecordPanel.setMaximumSize(new Dimension(44, 44));
            downloadRecordPanel.setBackground(Colors.PRIMARY_300);
            JButton btnDownloadRecord = new JButton();
            btnDownloadRecord.setBackground(Colors.PRIMARY_200);
            btnDownloadRecord.setPreferredSize(new Dimension(32, 32));
            btnDownloadRecord.setMaximumSize(new Dimension(32, 32));
            btnDownloadRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images32x32/iconDownload.png")));
            downloadRecordPanel.add(btnDownloadRecord);
            buttonPanel.add(downloadRecordPanel);

            panelExterior.add(dataPanel);

            Separator separatorTitle = new Separator();
            separatorTitle.setOrientation(1);
            separatorTitle.setMaximumSize(new Dimension(1, 44));
            panelExterior.add(separatorTitle);

            panelExterior.add(buttonPanel);

            contentPane.add(panelExterior);

            Separator separatorRecord = new Separator();
            separatorRecord.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
            contentPane.add(separatorRecord);
        }
        JScrollPane scrollPane = new JScrollPane(contentPane);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        RecordsPanel.add(scrollPane);
        RecordsPanel.revalidate();
        RecordsPanel.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitlePanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        FiltersPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtFilterText = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        dtStarDate = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        dtEndDate = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        tablePanel = new javax.swing.JPanel();
        OptionsPanel = new javax.swing.JPanel();
        btnAddAccount = new javax.swing.JButton();
        RecordsPanel = new javax.swing.JPanel();

        setBackground(Colors.PRIMARY_200);
        setPreferredSize(new java.awt.Dimension(970, 576));

        TitlePanel.setBackground(Colors.PRIMARY_200);

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel4.setForeground(Colors.PRIMARY_950);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("HISTORIAL DE REGISTROS CONTABLES");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout TitlePanelLayout = new javax.swing.GroupLayout(TitlePanel);
        TitlePanel.setLayout(TitlePanelLayout);
        TitlePanelLayout.setHorizontalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitlePanelLayout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(277, 277, 277))
        );
        TitlePanelLayout.setVerticalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        FiltersPanel.setBackground(Colors.PRIMARY_200);

        jPanel4.setBackground(Colors.PRIMARY_200);

        txtFilterText.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtFilterText.setPreferredSize(new java.awt.Dimension(64, 30));

        btnSearch.setBackground(Colors.PRIMARY_100);
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images32x32/iconLupe.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel1.setForeground(Colors.PRIMARY_950);
        jLabel1.setText("Titulo / N° de folio:");
        jLabel1.setPreferredSize(new java.awt.Dimension(143, 30));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFilterText, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFilterText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(Colors.PRIMARY_200);

        dtStarDate.setBackground(Colors.PRIMARY_200);
        dtStarDate.setMaxSelectableDate(new Date());
        dtStarDate.setPreferredSize(new java.awt.Dimension(82, 30));

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel2.setForeground(Colors.PRIMARY_950);
        jLabel2.setText("Desde:");
        jLabel2.setPreferredSize(new java.awt.Dimension(48, 30));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dtStarDate, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(dtStarDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(Colors.PRIMARY_200);

        dtEndDate.setBackground(Colors.PRIMARY_200);
        dtEndDate.setMaxSelectableDate(new Date());
        dtEndDate.setPreferredSize(new java.awt.Dimension(82, 30));

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel3.setForeground(Colors.PRIMARY_950);
        jLabel3.setText("Hasta:");
        jLabel3.setPreferredSize(new java.awt.Dimension(46, 30));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dtEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
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
                .addContainerGap(8, Short.MAX_VALUE))
        );

        tablePanel.setBackground(Colors.PRIMARY_200);
        tablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        OptionsPanel.setBackground(Colors.PRIMARY_200);

        btnAddAccount.setBackground(Colors.PRIMARY_400);
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
                .addContainerGap(349, Short.MAX_VALUE))
        );

        RecordsPanel.setBackground(Colors.PRIMARY_200);
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
                    .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FiltersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        AddAccountBookView accountBookView = new AddAccountBookView(this.PRINCIPALJFRAME);
        this.PRINCIPALJFRAME.replacePanel(accountBookView);
    }//GEN-LAST:event_btnAddAccountActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        List<AccountBook> filteredBooks = new ArrayList<>();

        String filterWord = txtFilterText.getText();
        Date starDate = (dtStarDate.getDate() != null) ? DateFunctions.setToStartOfDay(dtStarDate.getDate()) : null;
        Date endDate = (dtEndDate.getDate() != null) ? DateFunctions.setToendtOfDay(dtEndDate.getDate()) : null;

        if (starDate != null && endDate != null && !starDate.before(endDate)) {
            JPaneMessage.messageDialog(this, "Debe ingresar un rango de fechas válido", "Error en el rango de fechas", 1);
            return;
        }

        for (AccountBook book : this.Books) {
            boolean textFilter = filterWord.isBlank()
                    || book.getTitleBook().toLowerCase().contains(filterWord)
                    || String.valueOf(book.getAccountBookId()).contains(filterWord);

            boolean dateFilter = (starDate == null && endDate == null)
                    || isDateInRange(starDate, endDate, book.getCreationDate())
                    || (starDate == null && book.getCreationDate().before(endDate))
                    || (endDate == null && book.getCreationDate().after(starDate));
            if (textFilter && dateFilter) {
                filteredBooks.add(book);
            }
        }
        txtFilterText.setText("");
        showAccountRecords(filteredBooks);
    }//GEN-LAST:event_btnSearchActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FiltersPanel;
    private javax.swing.JPanel OptionsPanel;
    private javax.swing.JPanel RecordsPanel;
    private javax.swing.JPanel TitlePanel;
    private javax.swing.JButton btnAddAccount;
    private javax.swing.JButton btnSearch;
    private com.toedter.calendar.JDateChooser dtEndDate;
    private com.toedter.calendar.JDateChooser dtStarDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JTextField txtFilterText;
    // End of variables declaration//GEN-END:variables
}
