/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.marlenproject.userinterface.panelViews.accountingSection;

import com.mycompany.marlenproject.userinterface.AdminHome;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

public class AccountBookView extends javax.swing.JPanel {

    private final AdminHome PRINCIPALJFRAME;
    private final int DEFAULT_ROWS = 10;
    private final ArrayList<Long> INCOME_CELLS = new ArrayList<>(DEFAULT_ROWS);
    private final ArrayList<Long> EXPENSES_CELLS = new ArrayList<>(DEFAULT_ROWS);
    private long totalIncome = 0L;
    private long totalExpense = 0L;
    private boolean isUpdating = false;

    private void updateCellValue(int editedRow, int editedColumn, ArrayList<Long> cells, boolean isExpense, DefaultTableModel modelTable) {
        String newValue = modelTable.getValueAt(editedRow, editedColumn).toString();
        int index = Integer.parseInt(modelTable.getValueAt(editedRow, 0).toString());

        if (isIntegerOrLong(newValue)) {
            long newValueLong = Long.parseLong(newValue);
            Object newValueFormat = formatNumber(newValueLong);
            modelTable.setValueAt(newValueFormat, editedRow, editedColumn);
            if (isExpense) {
                totalExpense -= cells.get(index - 1);
                cells.set(index - 1, newValueLong);
                totalExpense += cells.get(index - 1);
            } else {
                totalIncome -= cells.get(index - 1);
                cells.set(index - 1, newValueLong);
                totalIncome += cells.get(index - 1);
            }
        } else {
            JOptionPane.showMessageDialog(PRINCIPALJFRAME, "Solo se aceptan números, sin espacios ni comas.", "Error de número", JOptionPane.ERROR_MESSAGE);

            Object oldValue = formatNumber(cells.get(index - 1));
            modelTable.setValueAt(oldValue, editedRow, editedColumn);
        }
    }

    private String formatNumber(long number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");

        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);

        String formattedNumber = decimalFormat.format(number).replace(',', '.');

        return formattedNumber;
    }

    private boolean isIntegerOrLong(String number) {
        try {
            Long.valueOf(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void loadTable() {
        DefaultTableModel modelTable = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };
        String[] tableHead = {"N°", "Descripción", "Ingresos", "Gastos"};
        modelTable.setColumnIdentifiers(tableHead);
        for (int i = 0; i < DEFAULT_ROWS; i++) {
            modelTable.addRow(new Object[]{i + 1, "", "", ""});
            INCOME_CELLS.add(0L);
            EXPENSES_CELLS.add(0L);
        }

        modelTable.addTableModelListener((TableModelEvent e) -> {
            if (e.getType() == TableModelEvent.UPDATE) {

                if (isUpdating) {
                    return;
                }

                isUpdating = true;

                int editedRow = e.getFirstRow();
                int editedColumn = e.getColumn();
                int lastRow = modelTable.getRowCount() - 1;

                if (editedRow == lastRow) {
                    for (int col = 1; col < modelTable.getColumnCount(); col++) {
                        Object value = modelTable.getValueAt(lastRow, col);
                        if (value != null && !value.toString().trim().isEmpty()) {
                            modelTable.addRow(new Object[]{modelTable.getRowCount() + 1, "", "", ""});
                            INCOME_CELLS.add(0L);
                            EXPENSES_CELLS.add(0L);
                            break;
                        }
                    }
                }

                if (editedColumn == tableHead.length - 1) {
                    updateCellValue(editedRow, editedColumn, EXPENSES_CELLS, true, modelTable);
                } else if (editedColumn == tableHead.length - 2) {
                    updateCellValue(editedRow, editedColumn, INCOME_CELLS, false, modelTable);
                }

                lbTotal_In.setText(formatNumber(totalIncome));
                lbTotal_Ex.setText(formatNumber(totalExpense));
                lbTotal_InEx.setText(formatNumber((totalIncome - totalExpense)));
                isUpdating = false;
            }
        });

        recordsAccountTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!recordsAccountTable.getSelectionModel().isSelectionEmpty()) {
                    btnAddRow.setEnabled(true);
                } else {
                    btnAddRow.setEnabled(false);
                }
            }
        });
        recordsAccountTable.setModel(modelTable);
        recordsAccountTable.setRowHeight(25);
    }

    public AccountBookView(AdminHome principalJFeame) {
        this.PRINCIPALJFRAME = principalJFeame;
        initComponents();
        loadTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbTitleBook = new javax.swing.JLabel();
        lbNumberBook = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recordsAccountTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbTotal_In = new javax.swing.JLabel();
        lbTotal_InEx = new javax.swing.JLabel();
        lbTotal_Ex = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnAddRow = new javax.swing.JButton();
        btnDeleteRow = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        BtnSave = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbTitleBook.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        lbTitleBook.setText("Inserte titulo");
        lbTitleBook.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbTitleBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbTitleBook.setMaximumSize(new java.awt.Dimension(280, 34));
        lbTitleBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTitleBookMouseClicked(evt);
            }
        });

        lbNumberBook.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        lbNumberBook.setText("Inserte número de libro");
        lbNumberBook.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbNumberBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbNumberBook.setMaximumSize(new java.awt.Dimension(280, 34));
        lbNumberBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNumberBookMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTitleBook, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(lbNumberBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTitleBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNumberBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        recordsAccountTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(recordsAccountTable);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel1.setText("Total de ingresos:");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel2.setText("Total de gastos:");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel3.setText("Ingresos - gastos:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbTotal_In.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lbTotal_In.setText("0");

        lbTotal_InEx.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lbTotal_InEx.setText("0");

        lbTotal_Ex.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lbTotal_Ex.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTotal_In)
                    .addComponent(lbTotal_Ex)
                    .addComponent(lbTotal_InEx))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTotal_In)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTotal_Ex)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTotal_InEx)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        btnAddRow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images32x32/iconPlus.png"))); // NOI18N
        btnAddRow.setText("Agregar fila");
        btnAddRow.setEnabled(false);
        btnAddRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRowActionPerformed(evt);
            }
        });

        btnDeleteRow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images32x32/iconMinus.png"))); // NOI18N
        btnDeleteRow.setText("Eliminar fila");
        btnDeleteRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteRowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnAddRow)
                .addGap(48, 48, 48)
                .addComponent(btnDeleteRow)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddRow)
                    .addComponent(btnDeleteRow))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconCancel.png"))); // NOI18N
        btnCancel.setText("Cancelar");
        btnCancel.setPreferredSize(new java.awt.Dimension(130, 60));

        BtnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconSave.png"))); // NOI18N
        BtnSave.setText("Guardar");
        BtnSave.setPreferredSize(new java.awt.Dimension(130, 60));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbTitleBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTitleBookMouseClicked
        String newTitleBook = JOptionPane.showInputDialog(this.PRINCIPALJFRAME, "¿Qué titulo desea darle a este libro?",
                "Cambiar titulo de libro", 1);

        if (newTitleBook != null && !newTitleBook.isEmpty()) {
            lbTitleBook.setText(newTitleBook.toUpperCase());
        }
    }//GEN-LAST:event_lbTitleBookMouseClicked

    private void lbNumberBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNumberBookMouseClicked
        String newNumberBook = JOptionPane.showInputDialog(this.PRINCIPALJFRAME, "¿Qué numero tiene este libro?",
                "Cambiar numero de libro", 1);

        if (newNumberBook != null && !newNumberBook.isEmpty()) {
            lbNumberBook.setText(newNumberBook.toUpperCase());
        }
    }//GEN-LAST:event_lbNumberBookMouseClicked

    private void btnAddRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRowActionPerformed
        int selectedRow = recordsAccountTable.getSelectedRow();
        DefaultTableModel tableModel = (DefaultTableModel) recordsAccountTable.getModel();

        if (selectedRow != -1) {
            tableModel.insertRow(selectedRow + 1, new Object[]{"popo", "", "", ""});
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                tableModel.setValueAt(i + 1, i, 0);
            }
            INCOME_CELLS.add(selectedRow + 1, 0L);
            EXPENSES_CELLS.add(selectedRow + 1, 0L);
        } else {
            JOptionPane.showMessageDialog(PRINCIPALJFRAME, "Selecciona una fila antes de agregar.", "Advertencia", 1);
        }
    }//GEN-LAST:event_btnAddRowActionPerformed

    private void btnDeleteRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRowActionPerformed
        int selectedRow = recordsAccountTable.getSelectedRow();
        DefaultTableModel tableModel = (DefaultTableModel) recordsAccountTable.getModel();

        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
            totalExpense -= EXPENSES_CELLS.get(selectedRow);
            totalIncome -= INCOME_CELLS.get(selectedRow);
            INCOME_CELLS.remove(selectedRow);
            EXPENSES_CELLS.remove(selectedRow);
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                tableModel.setValueAt(i + 1, i, 0);
            }
        } else {
            JOptionPane.showMessageDialog(PRINCIPALJFRAME, "Selecciona una fila antes de eliminar.", "Advertencia", 1);
        }

        if (tableModel.getRowCount() == 0) {
            tableModel.addRow(new Object[]{1, "", "", ""});
            INCOME_CELLS.add(0L);
            EXPENSES_CELLS.add(0L);
        }
    }//GEN-LAST:event_btnDeleteRowActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSave;
    private javax.swing.JButton btnAddRow;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDeleteRow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbNumberBook;
    private javax.swing.JLabel lbTitleBook;
    private javax.swing.JLabel lbTotal_Ex;
    private javax.swing.JLabel lbTotal_In;
    private javax.swing.JLabel lbTotal_InEx;
    private javax.swing.JTable recordsAccountTable;
    // End of variables declaration//GEN-END:variables
}
