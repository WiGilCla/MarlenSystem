/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.marlenproject.userinterface.panelViews.customerSection;

import com.mycompany.marlenproject.utils.fields.InputValidator;
import com.mycompany.marlenproject.logic.Customer;
import com.mycompany.marlenproject.userinterface.AdminHome;
import com.mycompany.marlenproject.utils.colors.Colors;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class CustomerListView extends javax.swing.JPanel {

    private final AdminHome PRINCIPALJFRAME;
    private final List<Customer> CUSTOMER_LIST;
    private final List<Customer> CUSTOMER_LIST_FILTER = new ArrayList<>();

    private void uploadInfoToTable(List<Customer> ListCustomer) {
        DefaultTableModel modelTable = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String tableHead[] = {"N°", "Dni", "Nombre", "Apellido", "Correo", "Telefono"};
        modelTable.setColumnIdentifiers(tableHead);

        if (!ListCustomer.isEmpty()) {

            int count = 0;
            for (Customer customer : ListCustomer) {

                Object[] workersObject = {(count + 1), customer.getPerson().getIdentificationNumber(), customer.getPerson().getFirstName(),
                    customer.getPerson().getFirstLastName(), customer.getEmail(), customer.getPhone()};
                modelTable.addRow(workersObject);
                count++;
            }
        }

        CustomerTable.setModel(modelTable);
        CustomerTable.getTableHeader().setFont(new java.awt.Font("Georgia", 1, 14));
        CustomerTable.getTableHeader().setForeground(Colors.PRIMARY_950);
    }

    public CustomerListView(AdminHome principalJFrame, List<Customer> customerList) {
        this.PRINCIPALJFRAME = principalJFrame;
        this.CUSTOMER_LIST = customerList;
        initComponents();
        uploadInfoToTable(this.CUSTOMER_LIST);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FilterPanel = new javax.swing.JPanel();
        Filter1Panel = new javax.swing.JPanel();
        textFilter1Panel = new javax.swing.JPanel();
        txtSearchCustomer = new javax.swing.JTextField();
        ButtonFilter1Panel = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        Filter2Panel = new javax.swing.JPanel();
        Filter3Panel = new javax.swing.JPanel();
        TablePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CustomerTable = new javax.swing.JTable();

        setBackground(Colors.PRIMARY_200);
        setPreferredSize(new java.awt.Dimension(970, 576));

        FilterPanel.setBackground(Colors.PRIMARY_200);
        FilterPanel.setPreferredSize(new java.awt.Dimension(958, 100));

        Filter1Panel.setBackground(Colors.PRIMARY_200);
        Filter1Panel.setPreferredSize(new java.awt.Dimension(467, 88));

        textFilter1Panel.setBackground(Colors.PRIMARY_200);
        textFilter1Panel.setPreferredSize(new java.awt.Dimension(350, 76));

        txtSearchCustomer.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtSearchCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtSearchCustomer.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout textFilter1PanelLayout = new javax.swing.GroupLayout(textFilter1Panel);
        textFilter1Panel.setLayout(textFilter1PanelLayout);
        textFilter1PanelLayout.setHorizontalGroup(
            textFilter1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textFilter1PanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        textFilter1PanelLayout.setVerticalGroup(
            textFilter1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textFilter1PanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(txtSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        ButtonFilter1Panel.setBackground(Colors.PRIMARY_200);
        ButtonFilter1Panel.setPreferredSize(new java.awt.Dimension(99, 76));

        btnSearch.setBackground(Colors.PRIMARY_100);
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images32x32/iconLupe.png"))); // NOI18N
        btnSearch.setPreferredSize(new java.awt.Dimension(40, 40));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ButtonFilter1PanelLayout = new javax.swing.GroupLayout(ButtonFilter1Panel);
        ButtonFilter1Panel.setLayout(ButtonFilter1PanelLayout);
        ButtonFilter1PanelLayout.setHorizontalGroup(
            ButtonFilter1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonFilter1PanelLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        ButtonFilter1PanelLayout.setVerticalGroup(
            ButtonFilter1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonFilter1PanelLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Filter1PanelLayout = new javax.swing.GroupLayout(Filter1Panel);
        Filter1Panel.setLayout(Filter1PanelLayout);
        Filter1PanelLayout.setHorizontalGroup(
            Filter1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Filter1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textFilter1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonFilter1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Filter1PanelLayout.setVerticalGroup(
            Filter1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Filter1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Filter1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonFilter1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFilter1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Filter2Panel.setBackground(Colors.PRIMARY_200);
        Filter2Panel.setPreferredSize(new java.awt.Dimension(234, 88));

        javax.swing.GroupLayout Filter2PanelLayout = new javax.swing.GroupLayout(Filter2Panel);
        Filter2Panel.setLayout(Filter2PanelLayout);
        Filter2PanelLayout.setHorizontalGroup(
            Filter2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Filter2PanelLayout.setVerticalGroup(
            Filter2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );

        Filter3Panel.setBackground(Colors.PRIMARY_200);
        Filter3Panel.setPreferredSize(new java.awt.Dimension(233, 88));

        javax.swing.GroupLayout Filter3PanelLayout = new javax.swing.GroupLayout(Filter3Panel);
        Filter3Panel.setLayout(Filter3PanelLayout);
        Filter3PanelLayout.setHorizontalGroup(
            Filter3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Filter3PanelLayout.setVerticalGroup(
            Filter3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout FilterPanelLayout = new javax.swing.GroupLayout(FilterPanel);
        FilterPanel.setLayout(FilterPanelLayout);
        FilterPanelLayout.setHorizontalGroup(
            FilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FilterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Filter1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Filter2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Filter3Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addContainerGap())
        );
        FilterPanelLayout.setVerticalGroup(
            FilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FilterPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(FilterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Filter1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Filter2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Filter3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        FilterPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Filter1Panel, Filter2Panel, Filter3Panel});

        TablePanel.setBackground(Colors.PRIMARY_200);
        TablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        TablePanel.setMinimumSize(new java.awt.Dimension(958, 100));
        TablePanel.setPreferredSize(new java.awt.Dimension(958, 352));

        CustomerTable.setBackground(Colors.PRIMARY_100);
        CustomerTable.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CustomerTable.setForeground(Colors.PRIMARY_950);
        CustomerTable.setModel(new javax.swing.table.DefaultTableModel(
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
        CustomerTable.setGridColor(new java.awt.Color(204, 204, 204));
        CustomerTable.setRowHeight(25);
        CustomerTable.setRowMargin(5);
        CustomerTable.setSelectionBackground(Colors.PRIMARY_300);
        CustomerTable.setShowGrid(true);
        CustomerTable.setShowVerticalLines(false);
        CustomerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomerTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(CustomerTable);

        javax.swing.GroupLayout TablePanelLayout = new javax.swing.GroupLayout(TablePanel);
        TablePanel.setLayout(TablePanelLayout);
        TablePanelLayout.setHorizontalGroup(
            TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
        );
        TablePanelLayout.setVerticalGroup(
            TablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 881, Short.MAX_VALUE)
                    .addComponent(FilterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 881, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FilterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String textFilter = InputValidator.removeStringBlanks(txtSearchCustomer.getText()).toLowerCase();
        this.CUSTOMER_LIST_FILTER.clear();

        if (!textFilter.equalsIgnoreCase("") && textFilter.length() > 0) {
            for (Customer customer : this.CUSTOMER_LIST) {
                if (customer.getPerson().getIdentificationNumber().toLowerCase().contains(textFilter)
                        || customer.getPerson().getFirstName().toLowerCase().contains(textFilter)
                        || customer.getPerson().getFirstLastName().toLowerCase().contains(textFilter)) {
                    CUSTOMER_LIST_FILTER.add(customer);
                }
            }
            uploadInfoToTable(this.CUSTOMER_LIST_FILTER);
        } else {
            CUSTOMER_LIST_FILTER.clear();
            uploadInfoToTable(this.CUSTOMER_LIST);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void CustomerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerTableMouseClicked
        if (CustomerTable.getRowCount() > 0) {
            if (CustomerTable.getSelectedRow() != -1) {
                CustomerInformationView customerInformationView;
                if (!this.CUSTOMER_LIST_FILTER.isEmpty()) {
                    customerInformationView = new CustomerInformationView(this.PRINCIPALJFRAME, this.CUSTOMER_LIST_FILTER,
                            (Integer.parseInt(String.valueOf(CustomerTable.getValueAt(CustomerTable.getSelectedRow(), 0)))) - 1);
                } else {
                    customerInformationView = new CustomerInformationView(this.PRINCIPALJFRAME, this.CUSTOMER_LIST,
                            (Integer.parseInt(String.valueOf(CustomerTable.getValueAt(CustomerTable.getSelectedRow(), 0))) - 1));
                }
                PRINCIPALJFRAME.replacePanel(customerInformationView);
            }
        }
    }//GEN-LAST:event_CustomerTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonFilter1Panel;
    private javax.swing.JTable CustomerTable;
    private javax.swing.JPanel Filter1Panel;
    private javax.swing.JPanel Filter2Panel;
    private javax.swing.JPanel Filter3Panel;
    private javax.swing.JPanel FilterPanel;
    private javax.swing.JPanel TablePanel;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel textFilter1Panel;
    private javax.swing.JTextField txtSearchCustomer;
    // End of variables declaration//GEN-END:variables
}
