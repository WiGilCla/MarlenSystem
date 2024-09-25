/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.marlenproject.userinterface.panelViews.ProductsSection;

import com.mycompany.marlenproject.logic.CheckFields;
import com.mycompany.marlenproject.logic.Product;
import com.mycompany.marlenproject.logic.request.RequestProduct;
import com.mycompany.marlenproject.userinterface.AdminHome;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;

public class AddProductView extends javax.swing.JFrame {

    private AdminHome PRINCIPALFRAME;
    private final Color COLOR_RED = new Color(255, 0, 0);
    private final Color COLOR_WHITE = new Color(255, 255, 255);
    private final CheckFields CHECKER = new CheckFields();

    public AddProductView(AdminHome principalFrame) {
        this.PRINCIPALFRAME = principalFrame;
        initComponents();
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelProductName = new javax.swing.JPanel();
        lbProductName = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        PanelProductDescription = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtADescriptionProduct = new javax.swing.JTextArea();
        PanelButtons = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelProductName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbProductName.setText("Nombre del producto:");
        lbProductName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtProductName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtProductNameMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelProductNameLayout = new javax.swing.GroupLayout(PanelProductName);
        PanelProductName.setLayout(PanelProductNameLayout);
        PanelProductNameLayout.setHorizontalGroup(
            PanelProductNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProductNameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelProductNameLayout.setVerticalGroup(
            PanelProductNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProductNameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelProductNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbProductName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtProductName, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addContainerGap())
        );

        PanelProductDescription.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtADescriptionProduct.setColumns(20);
        txtADescriptionProduct.setRows(5);
        jScrollPane1.setViewportView(txtADescriptionProduct);

        javax.swing.GroupLayout PanelProductDescriptionLayout = new javax.swing.GroupLayout(PanelProductDescription);
        PanelProductDescription.setLayout(PanelProductDescriptionLayout);
        PanelProductDescriptionLayout.setHorizontalGroup(
            PanelProductDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProductDescriptionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        PanelProductDescriptionLayout.setVerticalGroup(
            PanelProductDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProductDescriptionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelButtons.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconSave.png"))); // NOI18N
        btnSave.setText("Guardar");
        btnSave.setPreferredSize(new java.awt.Dimension(150, 60));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images48x48/iconCancel.png"))); // NOI18N
        btnCancel.setText("Cancelar");
        btnCancel.setPreferredSize(new java.awt.Dimension(150, 60));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelButtonsLayout = new javax.swing.GroupLayout(PanelButtons);
        PanelButtons.setLayout(PanelButtonsLayout);
        PanelButtonsLayout.setHorizontalGroup(
            PanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelButtonsLayout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );
        PanelButtonsLayout.setVerticalGroup(
            PanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelButtonsLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(PanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelProductName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelProductDescription, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelProductDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        List<Product> productList = new RequestProduct().getAllProducts();
        ProductView productView = new ProductView(PRINCIPALFRAME, productList);
        PRINCIPALFRAME.replacePanel(productView);
        this.dispose();
        PRINCIPALFRAME.setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (checkRequiredField() && checkNoRequiredField()) {
            try {
                RequestProduct requestProduct = new RequestProduct();

                String productName = txtProductName.getText();
                String productDescription = txtADescriptionProduct.getText();

                Product newProduct = new Product(productName, productDescription);
                requestProduct.saveProduct(newProduct);
                personalizedMessage("Information", "Se ha guardado el producto con exito.", "Operación exitosa");
                backProductListView();
            } catch (Exception ex) {
                personalizedMessage("Error", "Ha ocurrido un error durante el guardado de producto",
                        "Error de guardado");
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtProductNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtProductNameMouseClicked
        txtProductName.setBackground(COLOR_WHITE);
    }//GEN-LAST:event_txtProductNameMouseClicked

    private boolean checkRequiredField() {
        String productName = CHECKER.removeStringBlanks(txtProductName.getText());
        if (productName.isBlank()) {
            txtProductName.setBackground(COLOR_RED);
            personalizedMessage("Warning", "Debe dar un nombre al producto", "Campo requerido");
            return false;
        }
        if (!productName.isBlank() && !CHECKER.checkStringField(productName)) {
            txtProductName.setBackground(COLOR_RED);
            personalizedMessage("Warning", "Debe usar carácteres válidos", "Carácter no válido");
            return false;
        }

        return true;
    }

    private boolean checkNoRequiredField() {
        String productDescription = CHECKER.removeStringBlanks(txtADescriptionProduct.getText());

        if (!productDescription.isBlank() && !CHECKER.checkStringField(productDescription)) {
            txtADescriptionProduct.setBackground(COLOR_RED);
            personalizedMessage("Warning", "No debe usar caracteres especiales", "Carácter no válido");
            return false;
        }

        return true;
    }

    private void personalizedMessage(String type, String message, String title) {
        int typeMessage = 0;
        typeMessage = switch (type) {
            case "Error" ->
                0;
            case "Information" ->
                1;
            case "Warning" ->
                2;
            case "Question" ->
                3;
            default ->
                1;
        };
        JOptionPane.showMessageDialog(this, message, title, typeMessage);
    }
    
    private void backProductListView(){
        this.dispose();
        List<Product> productList = new RequestProduct().getAllProducts();
        ProductView productView = new ProductView(PRINCIPALFRAME, productList);
        PRINCIPALFRAME.replacePanel(productView);
        PRINCIPALFRAME.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelButtons;
    private javax.swing.JPanel PanelProductDescription;
    private javax.swing.JPanel PanelProductName;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbProductName;
    private javax.swing.JTextArea txtADescriptionProduct;
    private javax.swing.JTextField txtProductName;
    // End of variables declaration//GEN-END:variables
}
