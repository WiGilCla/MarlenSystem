/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.marlenproject.userinterface.panelViews.ProductsSection;

import com.mycompany.marlenproject.logic.Product;
import com.mycompany.marlenproject.logic.request.RequestProduct;
import com.mycompany.marlenproject.userinterface.AdminHome;
import com.mycompany.marlenproject.utils.message.JPaneMessage;
import com.mycompany.marlenproject.utils.colors.Colors;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class ProductView extends javax.swing.JPanel {

    private final AdminHome PRINCIPALJFRAME;
    private final List<Product> products;
    private final RequestProduct NEW_REQUEST_PRODUCT = new RequestProduct();

    public ProductView(AdminHome principalJFrame, List<Product> productList) {
        this.PRINCIPALJFRAME = principalJFrame;
        this.products = productList;
        initComponents();
        uploadInfoToTable(productList);
    }

    private void uploadInfoToTable(List<Product> productsList) {
        DefaultTableModel modelTable = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String tableHead[] = {"N°", "ID", "Nombre", "Descripción"};
        modelTable.setColumnIdentifiers(tableHead);

        if (!productsList.isEmpty()) {
            int count = 0;
            for (Product product : productsList) {
                Object[] productsObject = {(count + 1), product.getId(), product.getName(), product.getDescription()};
                modelTable.addRow(productsObject);
                count++;
            }
        }

        addListSelectionListener();
        setModelSettings(modelTable);
    }

    private void addListSelectionListener() {
        productsTable.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (!productsTable.getSelectionModel().isSelectionEmpty()) {
                btnEditProduct.setEnabled(true);
                btnDeleteProduct.setEnabled(true);
            } else {
                btnEditProduct.setEnabled(false);
                btnDeleteProduct.setEnabled(false);
            }
        });
    }

    private void setModelSettings(DefaultTableModel modelTable) {
        productsTable.setModel(modelTable);
        productsTable.getColumnModel().getColumn(0).setMinWidth(25);
        productsTable.getColumnModel().getColumn(0).setMaxWidth(50);
        productsTable.getColumnModel().getColumn(1).setMinWidth(25);
        productsTable.getColumnModel().getColumn(1).setMaxWidth(100);
        productsTable.getColumnModel().getColumn(2).setMinWidth(150);
        productsTable.getColumnModel().getColumn(2).setMaxWidth(200);
        productsTable.getColumnModel().getColumn(0).setPreferredWidth(25);
        productsTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        productsTable.getColumnModel().getColumn(2).setPreferredWidth(150);
    }
    
    private void backProductListView() {
        List<Product> productList = new RequestProduct().getAllProducts();
        ProductView productView = new ProductView(PRINCIPALJFRAME, productList);
        PRINCIPALJFRAME.replacePanel(productView);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnAddProduct = new javax.swing.JButton();
        btnEditProduct = new javax.swing.JButton();
        btnDeleteProduct = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();

        setBackground(Colors.PRIMARY_200);

        jPanel1.setBackground(Colors.PRIMARY_200);

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel1.setForeground(Colors.PRIMARY_950);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MIS PRODUCTOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(406, 406, 406)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(361, 361, 361))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(Colors.PRIMARY_200);
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel3.setBackground(Colors.PRIMARY_200);

        btnAddProduct.setBackground(Colors.PRIMARY_300);
        btnAddProduct.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnAddProduct.setForeground(Colors.PRIMARY_950);
        btnAddProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconAddProduct.png"))); // NOI18N
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });

        btnEditProduct.setBackground(Colors.PRIMARY_300);
        btnEditProduct.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnEditProduct.setForeground(Colors.PRIMARY_950);
        btnEditProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconEdit.png"))); // NOI18N
        btnEditProduct.setEnabled(false);
        btnEditProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProductActionPerformed(evt);
            }
        });

        btnDeleteProduct.setBackground(Colors.PRIMARY_300);
        btnDeleteProduct.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnDeleteProduct.setForeground(Colors.PRIMARY_950);
        btnDeleteProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconTrash.png"))); // NOI18N
        btnDeleteProduct.setEnabled(false);
        btnDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(btnDeleteProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(Colors.PRIMARY_200);

        productsTable.setBackground(Colors.PRIMARY_100);
        productsTable.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        productsTable.setForeground(Colors.PRIMARY_950);
        productsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        productsTable.setGridColor(new java.awt.Color(204, 204, 204));
        productsTable.setRowHeight(25);
        productsTable.setSelectionBackground(Colors.PRIMARY_300);
        productsTable.setShowGrid(true);
        productsTable.setShowVerticalLines(false);
        jScrollPane1.setViewportView(productsTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed

        AddProductView addProduct = new AddProductView();
        PRINCIPALJFRAME.replacePanel(addProduct);
        
    }//GEN-LAST:event_btnAddProductActionPerformed

    private void btnDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProductActionPerformed
        if (productsTable.getSelectedRow() != -1) {
            try {
                Product deleteProduct = this.products.get(productsTable.getSelectedRow());
                NEW_REQUEST_PRODUCT.deteleProduct(deleteProduct);
                JPaneMessage.messageDialog(this, "El producto ha sido eliminado exitosamente.", "Eliminación exitosa", 1);
                
                backProductListView();
            } catch (Exception ex) {
                JPaneMessage.messageDialog(this, "Ha ocurrido un error durante la eliminación", "Error inesperado", 0);
            }
        }
    }//GEN-LAST:event_btnDeleteProductActionPerformed

    private void btnEditProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProductActionPerformed
        Product editProduct = this.products.get(productsTable.getSelectedRow());
        EditProductView editProductView = new EditProductView(PRINCIPALJFRAME, editProduct);
        editProductView.setLocationRelativeTo(PRINCIPALJFRAME);
        editProductView.setVisible(true);
        PRINCIPALJFRAME.setVisible(false);
    }//GEN-LAST:event_btnEditProductActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.JButton btnEditProduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productsTable;
    // End of variables declaration//GEN-END:variables
}
