/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.marlenproject.userinterface.panelViews.accountingSection;

import com.mycompany.marlenproject.logic.AccountBook;
import com.mycompany.marlenproject.logic.AccountBookRecords;
import com.mycompany.marlenproject.logic.request.RequestAccountBook;
import com.mycompany.marlenproject.logic.request.RequestAccountBookRecord;
import com.mycompany.marlenproject.userinterface.AdminHome;
import com.mycompany.marlenproject.utils.message.JPaneMessage;
import com.mycompany.marlenproject.utils.colors.Colors;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

public class EditAccountBookView extends javax.swing.JPanel {

    private AccountBook copyBook = new AccountBook();
    private AccountBook originalBook = new AccountBook();
    private final ArrayList<AccountBookRecords> copyBookRecords = new ArrayList<>();
    private final ArrayList<AccountBookRecords> bookRecordsDeleted = new ArrayList<>();
    private final RequestAccountBook NEW_REQUEST_BOOK = new RequestAccountBook();
    private final RequestAccountBookRecord NEW_REQUEST_RECORD = new RequestAccountBookRecord();

    private final AdminHome PRINCIPALJFRAME;
    private long totalIncome = 0L;
    private long totalExpense = 0L;
    private boolean isUpdating = false;
    private final String[] HEADER = {"N°", "Descripción", "Ingresos", "Gastos"};

    private Object[] createEmptyRow(String indexRow) {
        Object[] row = {indexRow, "", "", ""};
        return row;
    }

    private void returnToAccountingView() {
        List<AccountBook> listBooks = NEW_REQUEST_BOOK.getBooks();
        AccountingView accountingView = new AccountingView(PRINCIPALJFRAME, listBooks);
        PRINCIPALJFRAME.replacePanel(accountingView);
    }

    private int getIndexFromHeader(String textHeader) {
        for (int i = 0; i < this.HEADER.length; i++) {
            if (textHeader.equals(this.HEADER[i])) {
                return i;
            }
        }
        return -1;
    }

    private void updateTotalInflowCount(int editedRow, long value) {
        totalIncome -= copyBookRecords.get(editedRow).getCashInflow();
        copyBookRecords.get(editedRow).setCashInflow(value);
        totalIncome += copyBookRecords.get(editedRow).getCashInflow();
    }

    private void updateTotalExpenseCount(int editedRow, long value) {
        totalExpense -= copyBookRecords.get(editedRow).getCashExpenses();
        copyBookRecords.get(editedRow).setCashExpenses(value);
        totalExpense += copyBookRecords.get(editedRow).getCashExpenses();
    }

    private String formatNumberWithDots(long number) {
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

    private boolean isContentInLastRow(DefaultTableModel modelTable, int lastRow) {

        for (int col = 1; col < modelTable.getColumnCount(); col++) {
            Object value = modelTable.getValueAt(lastRow, col);
            if (value != null && !value.toString().trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkTitleBook() {
        return !lbTitleBook.getText().isBlank();
    }

    private boolean checkBookRecords() {
        int emptyRecords = 0;
        int indexToCorrect = 0;
        ArrayList<String> listIndexToCorrect = new ArrayList<>();

        for (AccountBookRecords record : copyBookRecords) {
            boolean blankDescription = record.getDescription().isBlank();
            boolean isZeroInflow = record.getCashInflow() == 0;
            boolean isZeroExpense = record.getCashInflow() == 0;

            if (blankDescription && !(isZeroInflow && isZeroExpense)) {
                listIndexToCorrect.add(String.valueOf(indexToCorrect + 1));
            } else if (record.getDescription().isBlank()) {
                emptyRecords++;
            }
            indexToCorrect++;
        }

        if (!listIndexToCorrect.isEmpty()) {
            JPaneMessage.messageDialog(this,
                    "Debe agregar una descripción en los siguientes resgistros: " + listIndexToCorrect.toString(), "Registros sin descripción", 2);
            return false;
        }

        if (emptyRecords == copyBookRecords.size()) {
            JPaneMessage.messageDialog(PRINCIPALJFRAME,
                    "Debe agregar registros al libro.", "Libro sin registros", 2);
            return false;
        }

        return true;
    }

    public EditAccountBookView(AdminHome principalJFrame, AccountBook book) {

        this.PRINCIPALJFRAME = principalJFrame;
        this.originalBook = book;
        initComponents();
        loadTable(this.originalBook);
    }

    private void loadTable(AccountBook book) {

        DefaultTableModel modelTable = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };

        String[] tableHead = this.HEADER;
        modelTable.setColumnIdentifiers(tableHead);

        int indexRow = 0;

        for (AccountBookRecords record : book.getListBookRecords()) {

            AccountBookRecords copyRecord = new AccountBookRecords(record.getAccountBookId(),
                    record.getDescription(), record.getCashInflow(), record.getCashExpenses());
            copyRecord.setRecordId(record.getRecordId());

            this.copyBookRecords.add(copyRecord);

            modelTable.addRow(new Object[]{indexRow + 1, copyRecord.getDescription(),
                copyRecord.getCashInflow(), copyRecord.getCashExpenses()});

            indexRow++;
            totalIncome += copyRecord.getCashInflow();
            totalExpense += copyRecord.getCashExpenses();
        }

        this.copyBook = new AccountBook(book.getAccountBookId(),
                book.getCreationDate(), book.getTitleBook(), this.copyBookRecords);

        modelTable.addRow(createEmptyRow(String.valueOf(this.copyBookRecords.size() + 1)));
        copyBookRecords.add(new AccountBookRecords(null, "", 0L, 0L));

        lbTitleBook.setText(book.getTitleBook());
        lbNumberBook.setText(String.valueOf(book.getAccountBookId()));
        lbNumberBook.setEnabled(false);
        lbTotal_In.setText(formatNumberWithDots(totalIncome));
        lbTotal_Ex.setText(formatNumberWithDots(totalExpense));
        lbTotal_InEx.setText(formatNumberWithDots((totalIncome - totalExpense)));

        addTableModelListener(modelTable);
        addListSelectionModelListener(recordsAccountTable.getSelectionModel());
        recordsAccountTable.setModel(modelTable);
        recordsAccountTable.getTableHeader().setFont(new java.awt.Font("Georgia", 1, 14));
        recordsAccountTable.getTableHeader().setForeground(Colors.PRIMARY_950);
    }

    private void addTableModelListener(DefaultTableModel modelTable) {
        modelTable.addTableModelListener((TableModelEvent e) -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                if (isUpdating) {
                    return;
                }
                isUpdating = true;

                int editedRow = e.getFirstRow();
                int editedColumn = e.getColumn();
                int lastRow = modelTable.getRowCount() - 1;

                if (editedRow == lastRow && isContentInLastRow(modelTable, lastRow)) {

                    Object[] row = createEmptyRow(String.valueOf(modelTable.getRowCount() + 1));
                    modelTable.addRow(row);
                    this.copyBookRecords.add(new AccountBookRecords(null, "", 0L, 0L));

                }

                updateInformation(modelTable, editedColumn, editedRow);
            }
        });
    }

    private void updateInformation(DefaultTableModel modelTable, int editedColumn, int editedRow) {
        String valueAdded = modelTable.getValueAt(editedRow, editedColumn).toString();

        if (editedColumn == getIndexFromHeader("Ingresos")) {
            if (!isIntegerOrLong(valueAdded)) {
                JPaneMessage.incorrectNumberField(this, "Solo se aceptan: ", null, null);
                Object oldValue = formatNumberWithDots(copyBookRecords.get(editedRow).getCashInflow());
                modelTable.setValueAt(oldValue, editedRow, editedColumn);
                isUpdating = false;
                return;
            }

            updateTotalInflowCount(editedRow, Long.parseLong(valueAdded));
            modelTable.setValueAt((Object) formatNumberWithDots(Long.parseLong(valueAdded)), editedRow, editedColumn);

        } else if (editedColumn == getIndexFromHeader("Gastos")) {
            if (!isIntegerOrLong(valueAdded)) {
                JPaneMessage.incorrectNumberField(this, "Solo se aceptan: ", null, null);
                Object oldValue = formatNumberWithDots(copyBookRecords.get(editedRow).getCashExpenses());
                modelTable.setValueAt(oldValue, editedRow, editedColumn);
                isUpdating = false;
                return;
            }

            updateTotalExpenseCount(editedRow, Long.parseLong(valueAdded));
            modelTable.setValueAt((Object) formatNumberWithDots(Long.parseLong(valueAdded)), editedRow, editedColumn);

        } else if (editedColumn == getIndexFromHeader("Descripción")) {
            copyBookRecords.get(editedRow).setDescription((String) modelTable.getValueAt(editedRow, editedColumn));
        }

        lbTotal_In.setText(formatNumberWithDots(totalIncome));
        lbTotal_Ex.setText(formatNumberWithDots(totalExpense));
        lbTotal_InEx.setText(formatNumberWithDots((totalIncome - totalExpense)));
        isUpdating = false;
    }

    private void addListSelectionModelListener(ListSelectionModel model) {
        model.addListSelectionListener((ListSelectionEvent e) -> {
            if (!recordsAccountTable.getSelectionModel().isSelectionEmpty()) {
                btnAddRow.setEnabled(true);
                btnDeleteRow.setEnabled(true);
            } else {
                btnAddRow.setEnabled(false);
                btnDeleteRow.setEnabled(false);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        identificationBookPanel = new javax.swing.JPanel();
        lbTitleBook = new javax.swing.JLabel();
        lbNumberBook = new javax.swing.JLabel();
        tableCalculationPanel = new javax.swing.JPanel();
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
        buttonsPanel = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        BtnSave = new javax.swing.JButton();

        setBackground(Colors.PRIMARY_200);

        identificationBookPanel.setBackground(Colors.PRIMARY_200);

        lbTitleBook.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        lbTitleBook.setForeground(Colors.PRIMARY_950);
        lbTitleBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitleBook.setText("Titulo");
        lbTitleBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbTitleBook.setMaximumSize(new java.awt.Dimension(280, 34));
        lbTitleBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTitleBookMouseClicked(evt);
            }
        });

        lbNumberBook.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        lbNumberBook.setForeground(Colors.PRIMARY_950);
        lbNumberBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNumberBook.setText("Número");
        lbNumberBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbNumberBook.setMaximumSize(new java.awt.Dimension(280, 34));

        javax.swing.GroupLayout identificationBookPanelLayout = new javax.swing.GroupLayout(identificationBookPanel);
        identificationBookPanel.setLayout(identificationBookPanelLayout);
        identificationBookPanelLayout.setHorizontalGroup(
            identificationBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(identificationBookPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTitleBook, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(lbNumberBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        identificationBookPanelLayout.setVerticalGroup(
            identificationBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, identificationBookPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(identificationBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTitleBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNumberBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tableCalculationPanel.setBackground(Colors.PRIMARY_200);
        tableCalculationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        recordsAccountTable.setBackground(Colors.PRIMARY_100);
        recordsAccountTable.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
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
        recordsAccountTable.setGridColor(new java.awt.Color(204, 204, 204));
        recordsAccountTable.setRowHeight(25);
        recordsAccountTable.setRowMargin(5);
        recordsAccountTable.setSelectionBackground(Colors.PRIMARY_300);
        recordsAccountTable.setShowGrid(true);
        jScrollPane1.setViewportView(recordsAccountTable);

        jPanel4.setBackground(Colors.PRIMARY_200);

        jPanel5.setBackground(Colors.PRIMARY_200);

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel1.setForeground(Colors.PRIMARY_950);
        jLabel1.setText("Total de ingresos:");
        jLabel1.setPreferredSize(new java.awt.Dimension(0, 30));

        jLabel2.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel2.setForeground(Colors.PRIMARY_950);
        jLabel2.setText("Total de gastos:");
        jLabel2.setPreferredSize(new java.awt.Dimension(0, 30));

        jLabel3.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel3.setForeground(Colors.PRIMARY_950);
        jLabel3.setText("Ingresos - gastos:");
        jLabel3.setPreferredSize(new java.awt.Dimension(0, 30));

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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(Colors.PRIMARY_200);

        lbTotal_In.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        lbTotal_In.setForeground(Colors.PRIMARY_950);
        lbTotal_In.setText("0");
        lbTotal_In.setPreferredSize(new java.awt.Dimension(11, 30));

        lbTotal_InEx.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        lbTotal_InEx.setForeground(Colors.PRIMARY_950);
        lbTotal_InEx.setText("0");
        lbTotal_InEx.setPreferredSize(new java.awt.Dimension(11, 30));

        lbTotal_Ex.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        lbTotal_Ex.setForeground(Colors.PRIMARY_950);
        lbTotal_Ex.setText("0");
        lbTotal_Ex.setPreferredSize(new java.awt.Dimension(11, 30));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTotal_In, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(lbTotal_Ex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTotal_InEx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTotal_In, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTotal_Ex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTotal_InEx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(Colors.PRIMARY_200);

        btnAddRow.setBackground(Colors.PRIMARY_100);
        btnAddRow.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnAddRow.setForeground(Colors.PRIMARY_950);
        btnAddRow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images32x32/iconPlus.png"))); // NOI18N
        btnAddRow.setText("Agregar fila");
        btnAddRow.setEnabled(false);
        btnAddRow.setPreferredSize(new java.awt.Dimension(150, 40));
        btnAddRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRowActionPerformed(evt);
            }
        });

        btnDeleteRow.setBackground(Colors.PRIMARY_100);
        btnDeleteRow.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnDeleteRow.setForeground(Colors.PRIMARY_950);
        btnDeleteRow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images32x32/iconMinus.png"))); // NOI18N
        btnDeleteRow.setText("Eliminar fila");
        btnDeleteRow.setEnabled(false);
        btnDeleteRow.setPreferredSize(new java.awt.Dimension(150, 40));
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
                .addContainerGap()
                .addComponent(btnAddRow, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteRow, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddRow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteRow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout tableCalculationPanelLayout = new javax.swing.GroupLayout(tableCalculationPanel);
        tableCalculationPanel.setLayout(tableCalculationPanelLayout);
        tableCalculationPanelLayout.setHorizontalGroup(
            tableCalculationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tableCalculationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tableCalculationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        tableCalculationPanelLayout.setVerticalGroup(
            tableCalculationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tableCalculationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        buttonsPanel.setBackground(Colors.PRIMARY_200);

        btnCancel.setBackground(Colors.PRIMARY_400);
        btnCancel.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconCancel.png"))); // NOI18N
        btnCancel.setText("Cancelar");
        btnCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancel.setPreferredSize(new java.awt.Dimension(130, 60));
        btnCancel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        BtnSave.setBackground(Colors.PRIMARY_400);
        BtnSave.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        BtnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconSave.png"))); // NOI18N
        BtnSave.setText("Guardar");
        BtnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnSave.setPreferredSize(new java.awt.Dimension(130, 60));
        BtnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonsPanelLayout = new javax.swing.GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(buttonsPanelLayout);
        buttonsPanelLayout.setHorizontalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191)
                .addComponent(BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buttonsPanelLayout.setVerticalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(BtnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(identificationBookPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tableCalculationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(identificationBookPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableCalculationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbTitleBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTitleBookMouseClicked
        
        String newTitleBook = JPaneMessage.inputDialog(this,
                "Ingrese el nuevo titulo del libro: ", "Cambiar titulo de libro", 1);

        if (newTitleBook != null && !newTitleBook.isBlank()) {
            lbTitleBook.setText(newTitleBook.toUpperCase());
        }
    }//GEN-LAST:event_lbTitleBookMouseClicked

    private void btnAddRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRowActionPerformed
        int selectedRow = recordsAccountTable.getSelectedRow();
        DefaultTableModel tableModel = (DefaultTableModel) recordsAccountTable.getModel();

        if (selectedRow != -1) {
            Object[] row = createEmptyRow(String.valueOf(selectedRow + 2));
            tableModel.insertRow(selectedRow + 1, row);
            for (int i = selectedRow + 2; i < tableModel.getRowCount(); i++) {
                tableModel.setValueAt(i + 1, i, 0);
            }
            copyBookRecords.add(selectedRow + 1, new AccountBookRecords(null, "", 0L, 0L));
        } else {
            
        JPaneMessage.messageDialog(this, "Selecciona una fila antes de agregar.", "Item no seleccionado", 1);
        }
    }//GEN-LAST:event_btnAddRowActionPerformed

    private void btnDeleteRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRowActionPerformed
        int selectedRow = recordsAccountTable.getSelectedRow();
        DefaultTableModel tableModel = (DefaultTableModel) recordsAccountTable.getModel();

        if (selectedRow != -1) {

            totalExpense -= copyBookRecords.get(selectedRow).getCashExpenses();
            totalIncome -= copyBookRecords.get(selectedRow).getCashInflow();
            if (copyBookRecords.get(selectedRow).getRecordId() != 0) {
                this.bookRecordsDeleted.add(copyBookRecords.get(selectedRow));
            }
            copyBookRecords.remove(selectedRow);
            tableModel.removeRow(selectedRow);
            for (int i = selectedRow; i < tableModel.getRowCount(); i++) {
                tableModel.setValueAt(i + 1, i, 0);
            }
        } else {
            JPaneMessage.messageDialog(this,
                    "Selecciona una fila antes de eliminar.", "Item no seleccionado", 1);
        }

        if (tableModel.getRowCount() == 0) {
            tableModel.addRow(createEmptyRow(String.valueOf(1)));
            copyBookRecords.add(new AccountBookRecords(null, "", 0L, 0L));
        }
    }//GEN-LAST:event_btnDeleteRowActionPerformed

    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed

        if (recordsAccountTable.isEditing()) {
            recordsAccountTable.getCellEditor().stopCellEditing();
        }

        if (checkTitleBook() && checkBookRecords()) {

            try {
                for (AccountBookRecords deleteRecord : bookRecordsDeleted) {
                    NEW_REQUEST_RECORD.deleteBookRecord(deleteRecord);
                }

                for (AccountBookRecords editeRecord : copyBookRecords) {
                    if (!editeRecord.getDescription().isBlank()) {
                        if (editeRecord.getAccountBookId() == null) {
                            editeRecord.setAccountBookId(copyBook);
                            NEW_REQUEST_RECORD.saveBookRecord(editeRecord);
                            continue;
                        }
                        NEW_REQUEST_RECORD.editBookRecord(editeRecord);
                    }
                }
                copyBook.setTitleBook(lbTitleBook.getText());
                copyBook.setListBookRecords(NEW_REQUEST_RECORD.getRecordsByBookId(copyBook));
                NEW_REQUEST_BOOK.editBook(copyBook);
                JPaneMessage.messageDialog(this, "El libro se ha editado exitosamente.", "Edición exitosa",1);

            } catch (Exception ex) {
                Logger.getLogger(EditAccountBookView.class.getName()).log(Level.SEVERE, null, ex);
            }
            returnToAccountingView();

        }
    }//GEN-LAST:event_BtnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        returnToAccountingView();
    }//GEN-LAST:event_btnCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSave;
    private javax.swing.JButton btnAddRow;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDeleteRow;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JPanel identificationBookPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JPanel tableCalculationPanel;
    // End of variables declaration//GEN-END:variables
}
